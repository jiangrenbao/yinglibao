package com.bjpowernode.web.controller;

import com.bjpowernode.model.User;
import com.bjpowernode.pojo.JsonResult;
import com.bjpowernode.web.service.RealNameService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author jiangrenbao
 * @date 2021/11/28
 * @description
 */
@Controller
public class RealNameController extends BaseController {

    @Resource
    private RealNameService realNameService;

    @RequestMapping("/realName/realNameButton")
    @ResponseBody
    public JsonResult realNameButton(HttpServletRequest request){
        return realNameService.jdwxRealNameApi(request);
    }

    @RequestMapping("/toMyCenter")
    public String toMyCenter(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null){
            // 查询余额
            BigDecimal leftMoney = userService.queryLeftMoneyByUid(user.getId());
            request.setAttribute("leftMoney", leftMoney);
            // 查询最近投资五条投资记录
            List<Map<String,Object>> fiveInvest = userService.queryFiveInvestByUid(user.getId());
            if (fiveInvest != null && fiveInvest.size() > 0){
                request.setAttribute("fiveInvest",fiveInvest);
            }
            // 查询最近五条投资记录
            List<Map<String,Object>> fiveCharge = userService.queryFiveChargeByUid(user.getId());
            if (fiveCharge != null && fiveCharge.size() > 0){
                request.setAttribute("fiveCharge",fiveCharge);
            }
            // 查询最近五条收益记录
            List<Map<String,Object>> fiveIncome = userService.queryFiveIncomeByUid(user.getId());
            if (fiveIncome != null && fiveIncome.size() > 0){
                request.setAttribute("fiveIncome",fiveIncome);
            }
        }
        return "myCenter";
    }
}
