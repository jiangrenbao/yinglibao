package com.bjpowernode.web.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bjpowernode.constant.RedisConstant;
import com.bjpowernode.model.User;
import com.bjpowernode.pojo.JsonResult;
import com.bjpowernode.service.FinanceAccountService;
import com.bjpowernode.service.InvestInfoService;
import com.bjpowernode.service.ProductInfoService;
import com.bjpowernode.service.UserService;
import com.bjpowernode.web.config.JdwxIdentityConfig;
import com.bjpowernode.web.service.RealNameService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author jiangrenbao
 * @date 2021/11/28
 * @description
 */
@Service
public class RealNameServiceImpl implements RealNameService {

    @Resource
    private JdwxIdentityConfig jdwxIdentityConfig;

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

    @Override
    public JsonResult jdwxRealNameApi(HttpServletRequest request) {
        String name = request.getParameter("name");
        String card = request.getParameter("card");
        // 调用京东万象第三方接口进行姓名与身份证认证
        /*
            接口文档地址:
                https://wx.jdcloud.com/market/datas/5/11556

https://way.jd.com/youhuoBeijing/test?cardNo=150429198407091210&realName=乐天磊&appkey=您申请的APPKEY
            返回值:
                {
                    "code": "10000",
                        "charge": false,
                        "remain": 1305,
                        "msg": "查询成功",
                        "result":{
                            "error_code":0,
                            "reason":"成功",
                            "result":{
                            "realname":"乐天磊",
                                "idcard":"350721197702134399",
                                "isok":true
                            }
                        }
                }
            */
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String url = jdwxIdentityConfig.getUrl() + "?cardNo=" + card
                                                 + "&realName=" + name
                                                 + "&appkey=" + jdwxIdentityConfig.getAppkey();
        HttpGet httpGet = new HttpGet(url);
        try {
            CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);
            if (closeableHttpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                /*String jsonResult = EntityUtils.toString(closeableHttpResponse.getEntity());*/
                String jsonResult = "{\n" +
                        "                    \"code\": \"10000\",\n" +
                        "                        \"charge\": false,\n" +
                        "                        \"remain\": 1305,\n" +
                        "                        \"msg\": \"查询成功\",\n" +
                        "                        \"result\":{\n" +
                        "                            \"error_code\":0,\n" +
                        "                            \"reason\":\"成功\",\n" +
                        "                            \"result\":{\n" +
                        "                            \"realname\":\"乐天磊\",\n" +
                        "                                \"idcard\":\"350721197702134399\",\n" +
                        "                                \"isok\":true\n" +
                        "                            }\n" +
                        "                        }\n" +
                        "                }";
                // 使用fastjson处理返回来的json格式的字符串
                JSONObject jsonObject = JSONObject.parseObject(jsonResult);
                if ("10000".equals(jsonObject.getString("code"))) {
                    JSONObject result = jsonObject.getJSONObject("result");
                    if (result != null){
                         result = result.getJSONObject("result");
                         if (result != null){
                             boolean isok = (boolean) result.get("isok");
                             if (isok){
                                 // 认证成功,更新session中的user
                                 HttpSession session = request.getSession();
                                 User user = (User) session.getAttribute("user");
                                 user.setIdCard(card);
                                 user.setName(name);
                                 int row = userService.updateUserByRealName(user);
                                 if (row > 0){
                                     return new JsonResult(true,"实名认证成功");
                                 }

                             }
                         }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JsonResult(false, "实名认证失败");
    }
}
