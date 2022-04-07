package com.bjpowernode.dataservice.service.impl;

import com.bjpowernode.dataservice.mapper.FinanceAccountMapper;
import com.bjpowernode.dataservice.mapper.IncomeRecordMapper;
import com.bjpowernode.dataservice.mapper.ProductInfoMapper;
import com.bjpowernode.model.FinanceAccount;
import com.bjpowernode.model.IncomeRecord;
import com.bjpowernode.model.InvestInfo;
import com.bjpowernode.model.ProductInfo;
import com.bjpowernode.service.IncomeRecordService;
import com.bjpowernode.service.InvestInfoService;
import com.bjpowernode.service.ProductInfoService;
import com.bjpowernode.util.BaseUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author jiangrenbao
 * @date 2021/12/4
 * @description
 */
@Service
@DubboService(interfaceClass = IncomeRecordService.class, version = "1.0")
public class IncomeRecordServiceImpl implements IncomeRecordService {

    @Resource
    private ProductInfoService productInfoService;

    @Resource
    private InvestInfoService investInfoService;

    @Resource
    private IncomeRecordMapper incomeRecordMapper;

    @Resource
    private ProductInfoMapper productInfoMapper;

    @Resource
    private FinanceAccountMapper financeAccountMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public synchronized boolean scheduledIncomeByProduct() {
        // 第一步:查询所有已满标但为生成收益的产品
        List<ProductInfo> productInfoList = productInfoService.queryProductByStatusOne();
        for (ProductInfo productInfo : productInfoList) {
            // 第二步:查询产品的所有投资记录
            List<InvestInfo> investInfoList = investInfoService.queryInvestRecordByProductId(productInfo.getId());
            for (InvestInfo investInfo : investInfoList) {
                // 第三步:计算每个投资记录的收益
                BigDecimal income = BaseUtil.calculateEarnings(investInfo, productInfo);
                Date incomeDate = null;
                // 第四步:计算产品收益的到期时间(满标时间 + 周期)
                if (productInfo.getProductType() == 0) {
                    incomeDate = DateUtils.addDays(productInfo.getProductFullTime(), productInfo.getCycle());
                } else {
                    incomeDate = DateUtils.addMonths(productInfo.getProductFullTime(), productInfo.getCycle());
                }
                // 第五步:创建收益记录数据
                IncomeRecord incomeRecord = new IncomeRecord();
                incomeRecord.setuId(investInfo.getUserId());
                incomeRecord.setProductId(productInfo.getId());
                incomeRecord.setInvestId(investInfo.getId());
                incomeRecord.setInvestMoney(investInfo.getInvestMoney());
                incomeRecord.setIncomeDate(incomeDate);
                incomeRecord.setIncomeMoney(income);
                incomeRecord.setIncomeStatus(0);
                int row = incomeRecordMapper.insertSelective(incomeRecord);
                if (row <= 0){
                    throw new RuntimeException("生成收益计划失败");
                }
            }
            // 第六步:更新产品的状态为2
            productInfo.setProductStatus(2);
            int row = productInfoMapper.updateByPrimaryKey(productInfo);
            if (row <= 0){
                throw new RuntimeException("产品状态更新失败");
            }
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean scheduledIncomeBack() {
        // 第一步:查询收益记录中所有收益时间为当天且收益状态为未返还的收益记录
        List<IncomeRecord> incomeRecordList = queryRecordByToday();
        for (IncomeRecord incomeRecord : incomeRecordList) {
            // 第二步: 判断该用户资金账号是否存在
            FinanceAccount financeAccount = financeAccountMapper.queryAccountByUid(incomeRecord.getuId());
            if (financeAccount != null){
                // 第三步:更新该用户的资金账号可用余额,在当前可用余额上加上投资金额以及收益金额
                int row = financeAccountMapper.IncomeBack(incomeRecord.getuId(),
                                                          incomeRecord.getInvestMoney(),
                                                          incomeRecord.getIncomeMoney());
                if (row < 1){
                    throw new RuntimeException("收益返还失败");
                }else{
                    // 第四步: 更新收益记录的状态为1[收益以返还]
                    incomeRecord.setIncomeStatus(1);
                    row = incomeRecordMapper.updateByPrimaryKey(incomeRecord);
                    if (row < 1){
                        throw new RuntimeException("更新收益记录的状态失败");
                    }
                }
            }
        }
        return true;
    }

    @Override
    public List<IncomeRecord> queryRecordByToday() {

        return incomeRecordMapper.queryRecordByToday();
    }
}
