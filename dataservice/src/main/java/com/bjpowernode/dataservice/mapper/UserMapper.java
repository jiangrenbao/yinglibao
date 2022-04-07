package com.bjpowernode.dataservice.mapper;

import com.bjpowernode.model.User;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface UserMapper {
    //<editor-fold desc="逆向工程提供接口">
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    //</editor-fold>



    //<editor-fold desc="自定义接口">


    /**
     * 查询注册用户数量
     * @return
     */
    int selectUserNum();

    User checkPhone(@Param("phone") String phone);

    int addUser(User user);

    int queryUserIdByPhone(@Param("phone") String phone);

    int updateUserByRealName( User user);

    User queryUserByPhoneAndPwd(@Param("phone") String phone, @Param("pwd") String pwd);

    BigDecimal queryLeftMoneyByUid(@Param("id") Integer id);

    List<Map<String, Object>> queryFiveInvestByUid(@Param("id") Integer id);

    List<Map<String, Object>> queryFiveChargeByUid(@Param("id") Integer id);

    List<Map<String, Object>> queryFiveIncomeByUid(@Param("id") Integer id);
    //</editor-fold>
}