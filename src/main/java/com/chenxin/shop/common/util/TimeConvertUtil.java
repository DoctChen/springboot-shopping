package com.chenxin.shop.common.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Description:
 * @title: TimeConvertUtil
 * @Author Star_Chen
 * @Date: 2022/5/1 21:22
 * @Version 1.0
 */
public class TimeConvertUtil {

    public static String getCurrentDay(){
        LocalDateTime nowDateTime = LocalDateTime.now();
        String time = nowDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return time;
    }

}
