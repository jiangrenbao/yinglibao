package com.bjpowernode.web.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author jiangrenbao
 * @date 2021/11/28
 * @description
 */
@Component
@ConfigurationProperties(prefix = "jdwx.identity")
public class JdwxIdentityConfig {

    private String url;
    private String appkey;

    public String getUrl() {
        return url;
    }

    public JdwxIdentityConfig setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getAppkey() {
        return appkey;
    }

    public JdwxIdentityConfig setAppkey(String appkey) {
        this.appkey = appkey;
        return this;
    }

    public JdwxIdentityConfig() {
    }

    public JdwxIdentityConfig(String url, String appkey) {
        this.url = url;
        this.appkey = appkey;
    }

    @Override
    public String toString() {
        return "JdwxIdentityConfig{" +
                "url='" + url + '\'' +
                ", appkey='" + appkey + '\'' +
                '}';
    }
}
