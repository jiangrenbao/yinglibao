package com.bjpowernode.dataservice.service.impl;

import com.bjpowernode.constant.RedisConstant;
import com.bjpowernode.dataservice.mapper.FinanceAccountMapper;
import com.bjpowernode.dataservice.mapper.InvestInfoMapper;
import com.bjpowernode.dataservice.mapper.ProductInfoMapper;
import com.bjpowernode.model.FinanceAccount;
import com.bjpowernode.model.InvestInfo;
import com.bjpowernode.model.ProductInfo;
import com.bjpowernode.model.User;
import com.bjpowernode.pojo.JsonResult;
import com.bjpowernode.service.ProductInfoService;
import com.bjpowernode.util.DecimalTools;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author jiangrenbao
 * @date 2021/11/26
 * @description
 */
@Service
@DubboService(interfaceClass = ProductInfoService.class,version = "1.0")
public class ProductInfoServiceImpl implements ProductInfoService {

    @Resource
    private ProductInfoMapper productInfoMapper;

    @Resource
    private FinanceAccountMapper financeAccountMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private InvestInfoMapper InvestInfoMapper;

    @Override
    public BigDecimal queryAVGRate() {
        BigDecimal avgRate = (BigDecimal) redisTemplate.opsForValue().get(RedisConstant.HISTORY_AVG_RATE);
        if (avgRate == null){
                 synchronized (this){
                     avgRate = (BigDecimal) redisTemplate.opsForValue().get(RedisConstant.HISTORY_AVG_RATE);
                     if (avgRate == null){
                         avgRate = productInfoMapper.queryAVGRate();
                         redisTemplate.opsForValue().set(RedisConstant.HISTORY_AVG_RATE,
                                                         avgRate,
                                                         20,
                                                         TimeUnit.MINUTES);
                     }
                 }


        }
        return avgRate;
    }

    @Override
    public List<ProductInfo> queryProductInfoPageByType(int type, int pageNo, int pageSize) {
        int start = (pageNo - 1) * pageSize;
        int length = pageSize;
        return productInfoMapper.queryProductInfoPageByType(type,start,length);
    }

    @Override
    public int queryProductSumByType(int productType) {
        return productInfoMapper.queryProductSumByType(productType);
    }

    @Override
    public ProductInfo queryProductById(int id) {

        return productInfoMapper.queryProductById(id);
    }

    @Override
    public List<Map<String, Object>> queryCurrentThreeRecordByPid(int id) {
        return productInfoMapper.queryCurrentThreeRecordByPid(id);
    }

    @Override
    public JsonResult invest(Integer id, BigDecimal money, Integer loanId) {
        // ??????????????????????????????,????????????finance_account????????????for update??????
        FinanceAccount financeAccount = financeAccountMapper.queryAccountByUid(id);
        if( financeAccount != null){
            // ??????????????????????????????
            if(DecimalTools.ge(financeAccount.getAvailableMoney(),money)){
                //?????????????????????
                ProductInfo loanInfo = productInfoMapper.selectByPrimaryKey(loanId);
                if( loanInfo != null){
                    // ??????????????? leftMoney, min ,max
                    BigDecimal min = loanInfo.getInvestMinLimit();
                    BigDecimal max = loanInfo.getInvestMaxLimit();
                    BigDecimal left = loanInfo.getLeftProductMoney();
                    //???????????????????????????????????????
                    if( DecimalTools.ge(money,min) && DecimalTools.le( money,max) && DecimalTools.le( money,left) ){
                        // ????????????
                        //1.??????????????????
                        int rows = financeAccountMapper.updateMoneyInvestByUid(id,money,financeAccount.getAvailableMoney());
                        if( rows < 1){
                            throw new RuntimeException("?????????????????????????????????");
                        }
                        //2.????????????????????????????????????
                        rows = productInfoMapper.updateLeftMoneyInvest(loanId,money);
                        if( rows < 1){
                            throw new RuntimeException("????????????????????????????????????????????????");
                        }
                        //3.?????????????????? b_bid_info
                        InvestInfo investInfo = new InvestInfo();
                        investInfo.setProductId(loanId);
                        investInfo.setInvestMoney(money);
                        investInfo.setInvestStatus(1);
                        investInfo.setInvestTime(new Date());
                        investInfo.setUserId(id);
                        rows = InvestInfoMapper.insertSelective(investInfo);
                        if( rows < 1){
                            throw new RuntimeException("?????????????????????????????????");
                        }
                        // 4.????????????????????????
                        loanInfo = productInfoMapper.selectByPrimaryKey(loanId);
                        if( loanInfo.getLeftProductMoney().intValue() == 0){
                            // ?????????:????????????,????????????????????????????????????????????????
                            loanInfo.setProductStatus(1);
                            loanInfo.setProductFullTime( new Date());
                            rows = productInfoMapper.updateByPrimaryKeySelective(loanInfo);
                            if( rows < 1){
                                throw new RuntimeException("?????????????????????????????????????????????");
                            }
                        }
                        return new JsonResult(true,"?????????????????????!!!");
                    }
                }
            }
        }

        return new JsonResult(false, "????????????");
    }

    @Override
    public List<ProductInfo> queryProductByStatusOne() {
      return productInfoMapper.queryProductByStatusOne();
    }
}
