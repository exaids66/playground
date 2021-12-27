package com.play.playground.util;


import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
public class StaticUtil {

    // 字符串
    public static boolean isNullOrEmpty(String o){
        if(o == null || o.equals(""))
            return true;
        return false;
    }

    // 时间
    public static int[] getTimeSection(LocalDateTime startTime, LocalDateTime endTime, int[] time){
        int startHour = startTime.getHour();
        int endHour = endTime.getHour();
        log.info(String.format("%d %d", startHour, endHour));
        for(int i = startHour; i < endHour; i++){
            time[i] = 1;
        }
        return time;
    }

    public static boolean isRedundancy(LocalDateTime startTime, LocalDateTime endTime, int[] time){
        int startHour = startTime.getHour();
        int endHour = endTime.getHour();
        for(int i = startHour; i < endHour; i++){
            if(time[i] == 1) return true;
        }
        return false;
    }

    public static int[] initTimeSection(){
        return new int[24];
    }
}
