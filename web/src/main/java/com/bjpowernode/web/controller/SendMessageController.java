package com.bjpowernode.web.controller;

import com.bjpowernode.pojo.JsonResult;
import com.bjpowernode.web.service.SendMessageService;
import org.apache.dubbo.remoting.http.HttpServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author jiangrenbao
 * @date 2021/11/28
 * @description
 */
@Controller
public class SendMessageController extends BaseController {

    @Resource
    private SendMessageService sendMessageService;

    @RequestMapping("/send/sms")
    @ResponseBody
    public JsonResult sendSms(HttpServletRequest request) {
        return sendMessageService.sendJdwxSms(request);
    }
}
