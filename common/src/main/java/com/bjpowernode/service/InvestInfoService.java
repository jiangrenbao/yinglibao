package com.bjpowernode.service;

import com.bjpowernode.model.InvestInfo;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author jiangrenbao
 * @date 2021/11/26
 * @description
 */
public interface InvestInfoService {

    /**
     * 查询累计成交额
     * @return
     */
    BigDecimal querySumInvestMoney();

    List<InvestInfo> queryInvestRecordByProductId(Integer id);
}
