package com.bjpowernode.web.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author jiangrenbao
 * @date 2021/11/28
 * @description
 */
@Component
@ConfigurationProperties(prefix = "jdwx.sms")
public class JdwxSmsConfig {

    private String url;
    private String content;
    private String appkey;

    public String getUrl() {
        return url;
    }

    public JdwxSmsConfig setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getContent() {
        return content;
    }

    public JdwxSmsConfig setContent(String content) {
        this.content = content;
        return this;
    }

    public String getAppkey() {
        return appkey;
    }

    public JdwxSmsConfig setAppkey(String appkey) {
        this.appkey = appkey;
        return this;
    }

    public JdwxSmsConfig() {
    }

    public JdwxSmsConfig(String url, String content, String appkey) {
        this.url = url;
        this.content = content;
        this.appkey = appkey;
    }

    @Override
    public String toString() {
        return "JdwxSmsConfig{" +
                "url='" + url + '\'' +
                ", content='" + content + '\'' +
                ", appkey='" + appkey + '\'' +
                '}';
    }
}
