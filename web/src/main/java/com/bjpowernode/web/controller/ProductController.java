package com.bjpowernode.web.controller;

import com.bjpowernode.constant.RedisConstant;
import com.bjpowernode.model.ProductInfo;
import com.bjpowernode.model.User;
import com.bjpowernode.pojo.JsonResult;
import com.bjpowernode.pojo.PageInfo;
import com.bjpowernode.web.service.SendMessageService;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author jiangrenbao
 * @date 2021/11/27
 * @description 产品信息controller
 */
@Controller
@RequestMapping("/product")
public class ProductController extends BaseController{

    @Resource
    private SendMessageService sendMessageService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 产品信息,每页显示9个
     * @param request
     * @return
     */
    @RequestMapping("/product")
    public String product(HttpServletRequest request,
                          @RequestParam(value = "ptype") int productType,
                          @RequestParam(value = "pageNo",required = false,defaultValue = "1") int pageNo,
                          @RequestParam(value = "pageSize",required = false,defaultValue = "9") int pageSize){
        List<ProductInfo> pInfoList = productInfoService.queryProductInfoPageByType(productType, pageNo, pageSize);
        request.setAttribute("pInfoList",pInfoList);
        int productSum = productInfoService.queryProductSumByType(productType);
        PageInfo pageInfo = new PageInfo(pageNo, pageSize, productSum);
        request.setAttribute("pageInfo", pageInfo);
        request.setAttribute("ptype", productType);
        //<editor-fold desc="投资排行榜[取]">
        Set<ZSetOperations.TypedTuple<String>> typedTuples =
                stringRedisTemplate.opsForZSet().reverseRangeWithScores(RedisConstant.INVEST_TOP, 0, 5);
        List<Map<String,Object>> topList = new ArrayList<>();
        for (ZSetOperations.TypedTuple<String> typedTuple : typedTuples) {
            String value = typedTuple.getValue();
            Double score = typedTuple.getScore();
            Map<String,Object> topMap = new HashMap<>();
            topMap.put("phone", value);
            topMap.put("money", score);
            topList.add(topMap);
        }
        request.setAttribute("topList", topList);
        //</editor-fold>
        return "product";
    }

    @RequestMapping("/productInfo")
    public String productInfo(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("pid"));
        ProductInfo productInfo = productInfoService.queryProductById(id);
        request.setAttribute("productInfo", productInfo);
        // 查询最近三条该产品的投资记录
        List<Map<String, Object>> currentThreeList = productInfoService.queryCurrentThreeRecordByPid(id);
        request.setAttribute("currentThreeList", currentThreeList);
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if (user != null){
            //查询余额
            BigDecimal account = financeAccountService.queryAccountByUserId(user.getId());
            request.setAttribute("account", account);
        }
        return "productInfo";
    }

    @RequestMapping("/register")
    public String register(HttpServletRequest request){
        return "register";
    }

    @RequestMapping("/checkPhone")
    @ResponseBody
    public JsonResult checkPhone(HttpServletRequest request,String phone){
        User user = userService.checkPhone(phone);
        if (user == null){
            return new JsonResult(true, "该手机号可以注册");
        }else{
            return new JsonResult(false, "该手机号已经被注册");
        }
    }

    @RequestMapping("/registerbutton")
    @ResponseBody
    public JsonResult registerbutton(HttpServletRequest request){
        return sendMessageService.registerbutton(request);
    }

    @RequestMapping("/toRealName")
    public String toRealName(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null){
            request.setAttribute("phone", user.getPhone());
        }
        return "realName";
    }

    @PostMapping("/invest")
    @ResponseBody
    public JsonResult  invest(@RequestParam("money") BigDecimal money,
                                @RequestParam("loanId") Integer loanId,
                                HttpSession session){
        //对money简单处理
        if( money == null && money.intValue() < 100 ){
            return new JsonResult(false, "金额必须有效的数字");
        } else if( money.intValue() % 100 !=0 ){
            return new JsonResult(false, "金额是100的整数倍");
        } else if( loanId == null || loanId < 1 ){
            return new JsonResult(false,"购买产品不存在") ;
        } else {
            User user = (User) session.getAttribute("user");
            JsonResult result = productInfoService.invest(user.getId(), money, loanId);
            if (result.getResult()){
                // 第六步: 投资排行榜[存,value一样时,会自动增加delta]
                stringRedisTemplate.opsForZSet().incrementScore(RedisConstant.INVEST_TOP,
                                                                user.getPhone(),
                                                                money.doubleValue());
            }
            return result;
        }
    }
}
