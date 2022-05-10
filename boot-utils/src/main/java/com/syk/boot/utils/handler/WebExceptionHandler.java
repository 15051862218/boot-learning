package com.syk.boot.utils.handler;


import com.syk.boot.utils.commom.AjaxResponse;
import com.syk.boot.utils.commom.CustomExceptionType;
import com.syk.boot.utils.exception.CustomException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author 沈永康
 * @Date 2022/5/6 10:48
 * @Version 1.0
 */


@ControllerAdvice
public class WebExceptionHandler {

    /**
     * 处理程序员主动转换的自定义异常
     *
     * @param e 异常
     * @return AjaxResponse
     */
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public AjaxResponse customerException(CustomException e) {
        if (e.getCode() == CustomExceptionType.SYSTEM_ERROR.getCode()) {
            //400异常不需要持久化，将异常信息以友好的方式告知用户就可以
            //将500异常信息持久化处理，方便运维人员处理
        }
        return AjaxResponse.error(e);
    }

    /**
     * IllegalArgumentException:参数非法异常
     *
     * @param e 异常
     * @return AjaxResponse
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public AjaxResponse illegalArgumentException(IllegalArgumentException e) {
        CustomException exception = new CustomException(CustomExceptionType.ARGUMENTS_ERROR, e.getMessage());
        return AjaxResponse.error(exception);
    }

    /**
     * 处理程序员在程序中未能捕获（遗漏的）异常
     *
     * @param e 异常
     * @return AjaxResponse
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public AjaxResponse exception(Exception e) {
        return AjaxResponse.error(new CustomException(CustomExceptionType.OTHER_ERROR));
    }
}