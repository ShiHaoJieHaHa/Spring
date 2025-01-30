package com.demo.utils;

//请求返回工具类
public class ResultUtils {
    /**
     * 成功
     * @param data
     * @param <T>
     * @return
     */
    public static <T> BaseRespose<T> success(T data) {
        return new BaseRespose<T>(0,data,"ok");
    }


    public static  BaseRespose error(ErrorCode errorCode) {
        return new BaseRespose(errorCode);
    }
    public static  BaseRespose error(ErrorCode errorCode,String message,String description) {
        return new BaseRespose(errorCode.getCode(),null,message,description);
    }


    public static  BaseRespose error(int code,String message,String description) {
        return new BaseRespose(code,null,message,description);
    }

    public static  BaseRespose error(ErrorCode errorCode,String description) {
        return new BaseRespose(errorCode.getCode(),null,errorCode.getMessage(),description);
    }



}
