package com.Simba.Utils;

import android.util.Log;

public  class  UtilsLog {
    //true正式，true测试
    public static boolean isTest=true;//true打log；false不打log
    public boolean isCeshi = true;
    public static boolean isWrite=true;
    public static void d(String key,String value) {
        if (isTest) {
            Log.d(key,value);
        }
    }
    public static void i(String key,String value) {
        if (isTest) {
            Log.i(key,value);
        }
    }
    public static void v(String key,String value) {
        if (isTest) {
            Log.v(key,value);
        }
    }
    public static void w(String key,String value) {
        if (isWrite && value!=null) {
            StringUtils.writeToSdcard(key+":"+value,"/MyApp/","CrashLog.trace",100);
        }
    }

    public static void log(String key,String value) {
        StackTraceElement[] elements=new Throwable().getStackTrace();
        StackTraceElement element=elements[1];
        if (isTest) {
            Log.e(key,String.format("\"======[%s][%s][%s]=====%s\"",element.getClassName(),element.getLineNumber(),element.getMethodName(),value));
        }



    }


}

