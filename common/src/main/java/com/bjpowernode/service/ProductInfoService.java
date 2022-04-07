package com.bjpowernode.service;

import com.bjpowernode.model.ProductInfo;
import com.bjpowernode.pojo.JsonResult;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author jiangrenbao
 * @date 2021/11/26
 * @description
 */
public interface ProductInfoService {

    /**
     * 查询历史年化收益率
     * @return
     */
    BigDecimal queryAVGRate();

    /**
     * 分页查询不同类型产品信息
     * @param type
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<ProductInfo> queryProductInfoPageByType(int type,
                                                 int pageNo,
                                                 int pageSize);

    /**
     * 查询指定类型产品的总数
     * @param productType
     * @return
     */
    int queryProductSumByType(int productType);

    /**
     * 根据id查询产品
     * @param id
     * @return
     */
    ProductInfo queryProductById(int id);

    /**
     * 查询指定产品最近的三条投资记录
     * @param id
     * @return
     */
    List<Map<String, Object>> queryCurrentThreeRecordByPid(int id);

    JsonResult invest(Integer id, BigDecimal money, Integer loanId);

    List<ProductInfo> queryProductByStatusOne();

}
