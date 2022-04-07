package com.bjpowernode.util;

import com.bjpowernode.model.InvestInfo;
import com.bjpowernode.model.ProductInfo;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author jiangrenbao
 * @date 2021/11/28
 * @description
 */
public class BaseUtil {

    /**
     * 返回指定位数的数字组成的随机数
     */
    public static String random(int length) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public static BigDecimal calculateEarnings(InvestInfo investInfo, ProductInfo productInfo) {
        // 收益 = 投标金额 * 周期 * 利率
        BigDecimal invest_money = investInfo.getInvestMoney();
        int cycle = productInfo.getCycle();
        int productType = productInfo.getProductType();
        BigDecimal rate = productInfo.getRate();
        BigDecimal dayRate = DecimalTools.div(DecimalTools.div(rate, new BigDecimal(100)), new BigDecimal(365));
        // 新手宝
        if (productType != 0) {
        } else {
          cycle = cycle * 30;
        }
        return DecimalTools.income(invest_money, dayRate, cycle);
    }
}
