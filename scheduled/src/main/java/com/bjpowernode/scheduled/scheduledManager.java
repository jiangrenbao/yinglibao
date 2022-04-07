package com.bjpowernode.scheduled;

import com.bjpowernode.service.IncomeRecordService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author jiangrenbao
 * @date 2021/12/1
 * @description
 */
@Component
public class scheduledManager {

    @Resource
    @DubboReference(interfaceClass = IncomeRecordService.class,version = "1.0")
    private IncomeRecordService incomeRecordService;

    /**
     *   投资收益计划定时任务(每30分钟执行一次)
     */
    @Scheduled(cron = " * */30 * * * ?")
    public void incomeScheduled(){
        boolean result = incomeRecordService.scheduledIncomeByProduct();
        if (result){
            System.out.println("投资收益计划定时任务完成");
        }

    }

    /**
     * 投资收益返回定时任务[每天00:01:01执行一次]
     */
    //@Scheduled(cron = " 1 1 0 * * ?")
   /* public void incomeBackScheduled(){
        boolean result = incomeRecordService.scheduledIncomeBack();
        if (result){
            System.out.println("投资收益返回定时任务完成");
        }

    }*/

}
