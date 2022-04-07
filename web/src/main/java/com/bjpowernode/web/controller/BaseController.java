package com.bjpowernode.web.controller;

import com.bjpowernode.service.FinanceAccountService;
import com.bjpowernode.service.InvestInfoService;
import com.bjpowernode.service.ProductInfoService;
import com.bjpowernode.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;

/**
 * @author jiangrenbao
 * @date 2021/11/27
 * @description
 */
//把公用内容放到BaseController
public class BaseController {

    //引用远程对象
    @DubboReference(interfaceClass = UserService.class,version = "1.0")
    protected UserService userService;

    //引用远程对象
    @DubboReference(interfaceClass = ProductInfoService.class,version = "1.0")
    protected ProductInfoService productInfoService;


    //引用远程的 投资Service
    @DubboReference(interfaceClass = InvestInfoService.class,version = "1.0")
    protected InvestInfoService investInfoService;

    //引用远程的 钱包Service
    @DubboReference(interfaceClass = FinanceAccountService.class,version = "1.0")
    protected FinanceAccountService financeAccountService;

}
