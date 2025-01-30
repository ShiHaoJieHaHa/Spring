package com.demo.utils;


import lombok.Getter;

//自定义异常枚举
@Getter
public enum ErrorCode {
    SUCCESS(0, "ok", ""),
    PARAMS_ERROR(40000, "请求参数错误", ""),
    NULL_ERROR(40001, "请求数据为空", ""),
    NOT_LOGIN(40100, "未登录", ""),
    NO_AUTH(40101, "无权限", ""),
    FORBIDDEN(40300, "禁止访问", ""),
    SYSTEM_ERROR(50000, "系统内部错误", ""),
    OPERATION_FAILED(50100, "操作失败", "");
    private final int code;
    private final String message;
    private final String description;

    ErrorCode(int code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }

}
