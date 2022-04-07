package com.bjpowernode.dataservice.mapper;

import com.bjpowernode.model.FinanceAccount;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface FinanceAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FinanceAccount record);

    int insertSelective(FinanceAccount record);

    FinanceAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FinanceAccount record);

    int updateByPrimaryKey(FinanceAccount record);

    BigDecimal queryAccountByUserId(@Param("id") Integer id);

    int updateMoneyInvestByUid(@Param("id") Integer id, @Param("money") BigDecimal money, @Param("avaible_money") BigDecimal avaible_money);

    FinanceAccount queryAccountByUid(@Param("id") Integer id);


    int IncomeBack(@Param("getuId") Integer getuId, @Param("investMoney") BigDecimal investMoney, @Param("incomeMoney") BigDecimal incomeMoney);
}