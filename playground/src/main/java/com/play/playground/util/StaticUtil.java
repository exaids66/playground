package com.play.playground.util;


import java.time.LocalDateTime;

public class StaticUtil {

    // 字符串
    public static boolean isNullOrEmpty(String o){
        if(o == null || o.equals(""))
            return true;
        return false;
    }

    // 时间
    public static boolean isRedundancy(LocalDateTime target){
        return false;
    }


}
