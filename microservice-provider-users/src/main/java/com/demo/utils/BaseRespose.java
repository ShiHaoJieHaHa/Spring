package com.demo.utils;

import lombok.Data;

import java.io.Serializable;

//通用返回类
@Data
public class BaseRespose<T> implements Serializable {
    private int code;
    /**
     * 返回数据
     */
    private T data;
    /**
     * 返回概括信息
     */
    private String message;
    /**
     * 详细描述
     */
    private String description;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public  BaseRespose(int code, T data, String message, String description) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.description = description;
    }


    public BaseRespose(int code, T data,String message) {
        this(code,data,message,"");
    }
    public BaseRespose(int code, T data) {
        this(code,data,"","");
    }
    public BaseRespose(ErrorCode errorCode) {
        this(errorCode.getCode(), null, errorCode.getMessage(), errorCode.getDescription());

    }


}
