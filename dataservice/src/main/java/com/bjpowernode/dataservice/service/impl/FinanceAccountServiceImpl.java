package com.bjpowernode.dataservice.service.impl;

import com.bjpowernode.dataservice.mapper.FinanceAccountMapper;
import com.bjpowernode.model.FinanceAccount;
import com.bjpowernode.service.FinanceAccountService;
import com.bjpowernode.service.InvestInfoService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author jiangrenbao
 * @date 2021/11/28
 * @description
 */
@Service
@DubboService(interfaceClass = FinanceAccountService.class,version = "1.0")
public class FinanceAccountServiceImpl implements FinanceAccountService {

    @Resource
    private FinanceAccountMapper financeAccountMapper;

    @Override
    public int AddAccount(FinanceAccount financeAccount) {
        return financeAccountMapper.insertSelective(financeAccount);
    }

    @Override
    public BigDecimal queryAccountByUserId(Integer id) {
        return financeAccountMapper.queryAccountByUserId(id);
    }
}
