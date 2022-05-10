package com.syk.boot.utils.commom;


/**
 * @Author 沈永康
 * @Date 2022/5/6 10:43
 * @Version 1.0
 */


public enum CustomExceptionType {
    /**
     * 参数非法异常
     */
    ARGUMENTS_ERROR(100, "参数错误，请检查！"),

    /**
     * 客户端异常
     */
    USER_INPUT_ERROR(400, "您输入的数据错误或您没有权限访问资源！"),

    /**
     * 服务器异常
     */
    SYSTEM_ERROR(500, "系统出现异常，请您稍后再试或联系管理员！"),


    /**
     * 未知异常
     */
    OTHER_ERROR(999, "系统出现未知异常，请联系管理员！");

    CustomExceptionType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 异常类型状态码
     */
    private final int code;

    /**
     * 异常类型中文描述
     */
    private final String desc;


    public String getDesc() {
        return desc;
    }

    public int getCode() {
        return code;
    }
}