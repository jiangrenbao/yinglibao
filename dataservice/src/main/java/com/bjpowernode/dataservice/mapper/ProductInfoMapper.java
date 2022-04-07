package com.bjpowernode.dataservice.mapper;

import com.bjpowernode.model.FinanceAccount;
import com.bjpowernode.model.ProductInfo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ProductInfoMapper {

    //<editor-fold desc="逆向工程生成">
    int deleteByPrimaryKey(Integer id);

    int insert(ProductInfo record);

    int insertSelective(ProductInfo record);

    ProductInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductInfo record);

    int updateByPrimaryKey(ProductInfo record);
    //</editor-fold>

    //<editor-fold desc="自定义接口">
    /**
     * 返回历史年化收益率
     * @return
     */
    BigDecimal queryAVGRate();

    /**
     * 分页查询不用产品信息
     * @param type
     * @param start
     * @param length
     * @return
     */
    List<ProductInfo> queryProductInfoPageByType(@Param("type") int type, @Param("start") int start, @Param("length") int length);

    /**
     * 查询指定产品类型的产品数量
     * @param productType
     * @return
     */
    int queryProductSumByType(int productType);

    /**
     * 根据id查询产品
     * @param id
     * @return
     */
    ProductInfo queryProductById(@Param("id") int id);

    /**
     * 查询指定产品的最近的三条记录
     * @param id
     * @return
     */
    List<Map<String, Object>> queryCurrentThreeRecordByPid(@Param("id") int id);

    FinanceAccount queryAccountByUid(@Param("id") Integer id);

    int updateLeftMoneyInvest(@Param("loanId") Integer loanId, @Param("money") BigDecimal money);

    List<ProductInfo> queryProductByStatusOne();



    //</editor-fold>
}