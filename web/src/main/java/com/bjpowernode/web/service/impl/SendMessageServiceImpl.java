package com.bjpowernode.web.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bjpowernode.constant.RedisConstant;
import com.bjpowernode.model.FinanceAccount;
import com.bjpowernode.model.User;
import com.bjpowernode.pojo.JsonResult;
import com.bjpowernode.service.FinanceAccountService;
import com.bjpowernode.service.InvestInfoService;
import com.bjpowernode.service.ProductInfoService;
import com.bjpowernode.service.UserService;
import com.bjpowernode.util.BaseUtil;
import com.bjpowernode.util.DateUtil;
import com.bjpowernode.web.config.JdwxSmsConfig;
import com.bjpowernode.web.service.SendMessageService;
import com.sun.xml.internal.ws.assembler.jaxws.BasicTransportTubeFactory;
import org.apache.dubbo.common.threadpool.manager.Ring;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yaml.snakeyaml.events.Event;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author jiangrenbao
 * @date 2021/11/28
 * @description
 */
@Service
public class SendMessageServiceImpl implements SendMessageService {

    @Resource
    private JdwxSmsConfig jdwxSmsConfig;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

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
    public JsonResult sendJdwxSms(HttpServletRequest request) {
        // http://localhost:8888/money/send/sms?phone=15842623506
        String phone = request.getParameter("phone");
        // 使用httpclient调用京东万象接口发送短信
        /*

          接口文档地址:
            https://wx.jdcloud.com/market/datas/5/10665
          接口地址:
            https://way.jd.com/chuangxin/dxjk
            ?mobile=13568813957
            &content=【创信】你的验证码是：5873，3分钟内有效！
            &appkey=您申请的APPKEY 点此获取APPKEY
        */
        String securityCode = BaseUtil.random(4);
        String content = String.format(jdwxSmsConfig.getContent(), securityCode);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String url = jdwxSmsConfig.getUrl() + "?mobile=" + phone
                                            + "&content=" + content
                                            + "&appkey=" + jdwxSmsConfig.getAppkey();
        HttpGet httpGet = new HttpGet(url);
        try {
            CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);
            if (closeableHttpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // 展示不调用第三方接口,没必要,直接给个成功发送短信的值
                /*String jsonResult = EntityUtils.toString(closeableHttpResponse.getEntity());*/
                // 使用fastjson处理返回来的json格式的字符串
                /*
                    {
                        "code": "10000",
                        "charge": false,
                        "remain": 1305,
                        "msg": "查询成功",
                        "result": {
                            "ReturnStatus": "Success",
                            "Message": "ok",
                            "RemainPoint": 420842,
                            "TaskID": 18424321,
                            "SuccessCounts": 1
                        }
                    }
                */
                String jsonResult = "{\n" +
                        "                        \"code\": \"10000\",\n" +
                        "                        \"charge\": false,\n" +
                        "                        \"remain\": 1305,\n" +
                        "                        \"msg\": \"查询成功\",\n" +
                        "                        \"result\": {\n" +
                        "                            \"ReturnStatus\": \"Success\",\n" +
                        "                            \"Message\": \"ok\",\n" +
                        "                            \"RemainPoint\": 420842,\n" +
                        "                            \"TaskID\": 18424321,\n" +
                        "                            \"SuccessCounts\": 1\n" +
                        "                        }\n" +
                        "                    }";
                JSONObject jsonObject = JSONObject.parseObject(jsonResult);
                if ("10000".equals(jsonObject.getString("code"))) {
                    JSONObject result = jsonObject.getJSONObject("result");
                    if ("Success".equalsIgnoreCase(result.getString("ReturnStatus"))) {
                        System.out.println("短信验证码===========" + securityCode + "=============");
                        stringRedisTemplate.opsForValue().set(RedisConstant.JDWX_SMS,
                                                              securityCode + "&" + phone,
                                                              3,
                                                              TimeUnit.MINUTES);
                        return new JsonResult(true, "短信发送成功",securityCode);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new JsonResult(false, "请稍后重试");
    }

    @Override
    @Transactional
    public JsonResult registerbutton(HttpServletRequest request) {
        String phone = request.getParameter("phone");
        String pwd = request.getParameter("pwd");
        String code = request.getParameter("code");
        // 第一步:判断手机号是否注册过
        User checkUser = userService.checkPhone(phone);
        if (checkUser == null){
            // 第二步:验证短信验证码
            String securityCode = stringRedisTemplate.opsForValue().get(RedisConstant.JDWX_SMS);
            if (code != "" && code != null && (code + "&" + phone).equals(securityCode)){
                //第三步:添加一条user数据
                User user = new User();
                user.setPhone(phone);
                user.setLoginPassword(pwd);
                user.setAddTime(new Date());
                user.setLastLoginTime(new Date());
                int result = userService.addUser(user);
                if (result > 0) {
                    //第四步:添加一条finance_account数据
                    FinanceAccount financeAccount = new FinanceAccount();
                    // TODO: 2021/11/28  <selectkey>不好使
                    Integer id = userService.queryUserIdByPhone(phone);
                    user.setId(id);
                    financeAccount.setuId(id);
                    financeAccount.setAvailableMoney(new BigDecimal("888"));
                    result = financeAccountService.AddAccount(financeAccount);
                    if (result > 0){
                        // 第五步:将user存到session作用域中
                        HttpSession session = request.getSession();
                        session.setAttribute("user", user);
                        return new JsonResult(true, "注册成功,注册的手机号为" + phone);
                    }


                }
            }

        }
        return new JsonResult(false, "注册失败");
    }
}
