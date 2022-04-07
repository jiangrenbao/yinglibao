package com.bjpowernode.web.service;

import com.bjpowernode.pojo.JsonResult;
import com.bjpowernode.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.PrivateKey;

/**
 * @author jiangrenbao
 * @date 2021/11/28
 * @description
 */
public interface SendMessageService  {
    /**
     * 调用京东万象接口给用户发送短信
     * @param request
     * @return
     */
    JsonResult sendJdwxSms(HttpServletRequest request);

    /**
     * 注册功能
     * @param request
     * @return
     */
    JsonResult registerbutton(HttpServletRequest request);

}
