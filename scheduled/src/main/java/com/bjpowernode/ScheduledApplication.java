package com.bjpowernode;

import com.bjpowernode.service.IncomeRecordService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.Resource;

@EnableDubbo
@EnableScheduling
@SpringBootApplication
public class ScheduledApplication implements CommandLineRunner {

    @DubboReference(interfaceClass = IncomeRecordService.class,version = "1.0")
    private IncomeRecordService incomeRecordService;
    public static void main(String[] args) {
        SpringApplication.run(ScheduledApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("---------定时任务已启动---------");
        //incomeRecordService.scheduledIncomeByProduct();
        //incomeRecordService.scheduledIncomeBack();
    }
}
