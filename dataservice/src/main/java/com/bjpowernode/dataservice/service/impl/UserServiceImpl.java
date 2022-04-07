package com.bjpowernode.dataservice.service.impl;

import com.bjpowernode.constant.RedisConstant;
import com.bjpowernode.dataservice.mapper.UserMapper;
import com.bjpowernode.model.User;
import com.bjpowernode.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author jiangrenbao
 * @date 2021/11/26
 * @description
 */
@Service
@DubboService(interfaceClass = UserService.class,version = "1.0")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int selectUserNum() {
        Integer userNum = (Integer) redisTemplate.opsForValue().get(RedisConstant.REGISTER_USER_NUM);
        if (userNum == null){
            synchronized (this){
                userNum = (Integer) redisTemplate.opsForValue().get(RedisConstant.REGISTER_USER_NUM);
                if (userNum == null){
                    userNum = userMapper.selectUserNum();
                    redisTemplate.opsForValue().set(RedisConstant.REGISTER_USER_NUM,
                            userNum,
                            20,
                            TimeUnit.MINUTES);
                }
            }
        }
        return userNum;

    }

    @Override
    public User checkPhone(String phone) {
        return userMapper.checkPhone(phone);
    }

    @Override
    public int queryUserIdByPhone(String phone) {
        return userMapper.queryUserIdByPhone(phone);
    }

    @Override
    public int updateUserByRealName(User user) {
        return userMapper.updateUserByRealName(user);
    }

    @Override
    public User queryUserByPhoneAndPwd(String phone, String pwd) {

        return userMapper.queryUserByPhoneAndPwd(phone,pwd);
    }

    @Override
    public BigDecimal queryLeftMoneyByUid(Integer id) {
        return userMapper.queryLeftMoneyByUid(id);
    }

    @Override
    public List<Map<String, Object>> queryFiveInvestByUid(Integer id) {
        return userMapper.queryFiveInvestByUid(id);
    }

    @Override
    public List<Map<String, Object>> queryFiveChargeByUid(Integer id) {
        return userMapper.queryFiveChargeByUid(id);
    }

    @Override
    public List<Map<String, Object>> queryFiveIncomeByUid(Integer id) {
        return userMapper.queryFiveIncomeByUid(id);
    }
}
