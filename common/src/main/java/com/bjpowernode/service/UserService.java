package com.bjpowernode.service;

import com.bjpowernode.model.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author jiangrenbao
 * @date 2021/11/26
 * @description
 */
public interface UserService {

    /**
     * 用户注册
     * @return
     */
    int addUser(User user);

    /**
     * 查询注册用户数量
     * @return
     */
    int selectUserNum();

    /**
     * 根据手机号查询用户
     * @return
     */
    User checkPhone(String phone);

    int queryUserIdByPhone(String phone);

    int updateUserByRealName(User user);

    User queryUserByPhoneAndPwd(String phone, String pwd);

    BigDecimal queryLeftMoneyByUid(Integer id);

    List<Map<String, Object>> queryFiveInvestByUid(Integer id);

    List<Map<String, Object>> queryFiveChargeByUid(Integer id);

    List<Map<String, Object>> queryFiveIncomeByUid(Integer id);
}
