package com.bjpowernode.dataservice;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@EnableDubbo
@MapperScan(basePackages = "com.bjpowernode.dataservice.mapper")
@SpringBootApplication
public class DataserviceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DataserviceApplication.class, args);
    }

    /**
     * 项目启动时立即执行
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        System.out.println("dataservice服务已经启动");
    }
}
