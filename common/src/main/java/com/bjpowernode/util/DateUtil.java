package com.bjpowernode.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jiangrenbao
 * @date 2021/11/21
 * @description date util class
 */
public class DateUtil {

    /**
     * 将Date对象转换为2222-11-21 12:12:12格式的字符串
     */
    public static String formatDateTime(Date date){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str=sdf.format(date);
        return str;
    }
}
