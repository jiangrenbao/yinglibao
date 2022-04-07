package com.bjpowernode.dataservice.service.impl;

import com.bjpowernode.constant.RedisConstant;
import com.bjpowernode.dataservice.mapper.InvestInfoMapper;
import com.bjpowernode.model.InvestInfo;
import com.bjpowernode.service.InvestInfoService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author jiangrenbao
 * @date 2021/11/26
 * @description
 */
@Service
@DubboService(interfaceClass = InvestInfoService.class,version = "1.0")
public class InvestInfoServiceImpl implements InvestInfoService {

    @Resource
    private InvestInfoMapper investInfoMapper;

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public BigDecimal querySumInvestMoney() {
        BigDecimal investMoney = (BigDecimal) redisTemplate.opsForValue().get(RedisConstant.TOTAL_INVEST_MONEY);
        if (investMoney == null){
            synchronized (this){
                investMoney = (BigDecimal) redisTemplate.opsForValue().get(RedisConstant.TOTAL_INVEST_MONEY);
                if (investMoney == null){
                    investMoney = investInfoMapper.querySumInvestMoney();
                    redisTemplate.opsForValue().set(RedisConstant.TOTAL_INVEST_MONEY,
                            investMoney,
                            20,
                            TimeUnit.MINUTES);
                }
            }
        }
        return investMoney;
    }

    @Override
    public List<InvestInfo> queryInvestRecordByProductId(Integer id) {
     return investInfoMapper.queryInvestRecordByProductId(id);
    }
}
