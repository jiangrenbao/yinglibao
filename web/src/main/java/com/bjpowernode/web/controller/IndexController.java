package com.bjpowernode.web.controller;

import com.bjpowernode.constant.CommonConstant;
import com.bjpowernode.model.ProductInfo;
import com.bjpowernode.model.User;
import com.bjpowernode.pojo.JsonResult;
import com.bjpowernode.service.InvestInfoService;
import com.bjpowernode.service.ProductInfoService;
import com.bjpowernode.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author jiangrenbao
 * @date 2021/11/26
 * @description 首页controller
 */
@Controller
public class IndexController extends BaseController {


    @RequestMapping({"/index","/"})
    public String init(HttpServletRequest request){
        // 平台用户数,平均年化率,总投资金额存在缓存中,20分钟一更新
        int userNum = userService.selectUserNum();
        BigDecimal avgRate = productInfoService.queryAVGRate();
        request.setAttribute("userNum", userNum);
        request.setAttribute("avgRate", avgRate);
        BigDecimal sumInvestMoney = investInfoService.querySumInvestMoney();
        request.setAttribute("sumInvestMoney", sumInvestMoney);
        List<ProductInfo> xinInfoList = productInfoService.queryProductInfoPageByType(CommonConstant.XIN_PRODUCT_TYPE, 1, 1);
        ProductInfo xinInfo = xinInfoList.get(0);
        request.setAttribute("xinInfo", xinInfo);
        List<ProductInfo> youInfoList = productInfoService.queryProductInfoPageByType(CommonConstant.YOU_PRODUCT_TYPE, 1, 4);
        request.setAttribute("youInfoList", youInfoList);
        List<ProductInfo> shanInfoList = productInfoService.queryProductInfoPageByType(CommonConstant.SHAN_PRODUCT_TYPE, 1, 8);
        request.setAttribute("shanInfoList", shanInfoList);
        return "index";
    }

    @RequestMapping("/toLogin")
    public String toLogin(HttpServletRequest request){
        int userNum = userService.selectUserNum();
        BigDecimal avgRate = productInfoService.queryAVGRate();
        BigDecimal totlMoney = investInfoService.querySumInvestMoney();
        request.setAttribute("userNum", userNum);
        request.setAttribute("avgRate", avgRate);
        request.setAttribute("totalMoney", totlMoney);
        String returnUrl = request.getParameter("returnUrl");
        request.setAttribute("returnUrl", returnUrl);
        return "login";
    }

    @RequestMapping("/login")
    @ResponseBody
    public JsonResult login(HttpServletRequest request){
        String phone = request.getParameter("phone");
        String pwd = request.getParameter("pwd");
        User user = userService.queryUserByPhoneAndPwd(phone,pwd);
        if (user != null){
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return new JsonResult(true,"登录成功") ;
        }
        return new JsonResult(false,"登录失败") ;
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/index";
    }

    @RequestMapping("/headerData")
    @ResponseBody
    public JsonResult headerData(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null){
            return new JsonResult(false, "用户还未登陆");
        }
        BigDecimal leftMoney = userService.queryLeftMoneyByUid(user.getId());
        if (leftMoney != null){
            return new JsonResult(true, "查询成功",leftMoney);
        }else{
            return new JsonResult(false, "查询失败");
        }
    }
}
