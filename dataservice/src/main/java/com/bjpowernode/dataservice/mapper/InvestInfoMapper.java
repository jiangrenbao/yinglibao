package com.bjpowernode.dataservice.mapper;

import com.bjpowernode.model.InvestInfo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface InvestInfoMapper {

    //<editor-fold desc="逆向工程生成">
    int deleteByPrimaryKey(Integer id);

    int insert(InvestInfo record);

    int insertSelective(InvestInfo record);

    InvestInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InvestInfo record);

    int updateByPrimaryKey(InvestInfo record);
    //</editor-fold>

    //<editor-fold desc="自定义接口">
    /**
     * 查询累计成交额
     * @return
     */
    BigDecimal querySumInvestMoney();

    List<InvestInfo> queryInvestRecordByProductId(@Param("id") Integer id);

    //</editor-fold>
}