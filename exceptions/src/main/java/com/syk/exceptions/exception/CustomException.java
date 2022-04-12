package com.syk.exceptions.exception;


import com.syk.exceptions.enums.CustomExceptionType;

/**
 * @Author 沈永康
 * @Date 2022/4/11 11:47
 * @Version 1.0
 */


public class CustomException extends RuntimeException{
    private  int code;
    private  String message;

    private CustomException(){

    }
    public CustomException(CustomExceptionType exceptionType){
        this.code = exceptionType.getCode();
        this.message = exceptionType.getDesc();
    }
    public  CustomException(CustomExceptionType customExceptionType,String message){
        this.code = customExceptionType.getCode();
        this.message = message;
    }
    public  int getCode() {
        return  code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
