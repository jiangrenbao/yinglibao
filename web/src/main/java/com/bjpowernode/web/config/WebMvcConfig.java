package com.bjpowernode.web.config;

import com.bjpowernode.web.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author jiangrenbao
 * @date 2021/12/5
 * @description
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 注册拦截器[还有问题,先这样了]
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] pathPatterns = {
                "/product/toRealName",
                "/realName/realNameButton",
                "/toMyCenter"
        };
        String[] excludePathPatterns = {
                "/send/sms",
                "/product/checkPhone",
                "/product/product",
                "/product/productInfo",
                "/toLogin",
                "/loginOut",
                "/login",
                "/product/register",
                "/product/registerbutton",
                "/index",
                "/"
        };
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns(pathPatterns)
                .excludePathPatterns(excludePathPatterns);
    }
}
