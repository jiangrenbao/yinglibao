package com.bjpowernode.web.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.bjpowernode.model.User;
import com.bjpowernode.pojo.JsonResult;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * @author jiangrenbao
 * @date 2021/12/5
 * @description
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        // 判断用户是否登录,如果没有登录,重定向到登录的界面
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        System.out.println("--------拦截器:当前用户:" + user + "--------");
        if (user == null){
            System.out.println("--------被拦截器拦截--------" + request.getContextPath() + "/toLogin");
            // 区分ajax请求与普通页面请求
            String header = request.getHeader("X-Requested-With");
            if ("XMLHttpRequest".equals(header)){
                // 返回数据
                JsonResult jsonResult = new JsonResult(false, "请求错误");
                String jsonString = JSONObject.toJSONString(jsonResult);
                PrintWriter writer = response.getWriter();
                writer.println(jsonString);
                writer.flush();
                writer.close();
                return false;
            }else{
                // 重定向到登录的界面
                response.sendRedirect(request.getContextPath() + "/toLogin");
                return false;
            }
        }
        return true;
    }
}
