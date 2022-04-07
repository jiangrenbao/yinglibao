package com.bjpowernode.service;

import com.bjpowernode.model.IncomeRecord;

import java.util.List;

/**
 * @author jiangrenbao
 * @date 2021/12/4
 * @description
 */
public interface IncomeRecordService {



    /**
     * 产生产品收益的定时任务(30分钟执行一次)
     * @return
     */
    boolean scheduledIncomeByProduct();

    boolean scheduledIncomeBack();

    List<IncomeRecord> queryRecordByToday();

}
