package com.syk.exceptions.enums;


/**
 * @Author 沈永康
 * @Date 2022/4/11 11:37
 * @Version 1.0
 */


public enum CustomExceptionType {
    /**
     * 客户端异常
     */
    USER_INPUT_ERROR(400,"您输入的数据错误或您没有权限访问资源"),
    /**
     * 客户端异常
     */
    SYSTEM_ERROR(500,"系统出现异常，请您稍后再试或联系管理员！"),
    /**
     * 客户端异常
     */
  OTHER_ERROR(999,"系统出现未知异常，请联系管理员！");

  CustomExceptionType(int code, String desc){
      this.code = code;
      this.desc = desc;
  }

  private  final  String desc;
  private  final  int code;


  public  String getDesc(){return  desc;}
    public  int getCode(){return  code;}
}
