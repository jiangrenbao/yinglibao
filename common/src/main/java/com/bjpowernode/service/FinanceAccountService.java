package com.bjpowernode.service;

import com.bjpowernode.model.FinanceAccount;

import java.math.BigDecimal;

/**
 * @author jiangrenbao
 * @date 2021/11/28
 * @description
 */
public interface FinanceAccountService {

    int AddAccount(FinanceAccount financeAccount) ;

    BigDecimal queryAccountByUserId(Integer id);
}
