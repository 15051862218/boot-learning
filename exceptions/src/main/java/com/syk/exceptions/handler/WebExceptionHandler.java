package com.syk.exceptions.handler;


import com.syk.exceptions.enums.CustomExceptionType;
import com.syk.exceptions.exception.CustomException;
import com.syk.exceptions.service.ExceptionService;
import com.syk.exceptions.utils.AjaxResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author 沈永康
 * @Date 2022/4/11 13:19
 * @Version 1.0
 */

@ControllerAdvice
public class WebExceptionHandler {
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public AjaxResponse customerException(CustomException e) {
        if (e.getCode() == CustomExceptionType.SYSTEM_ERROR.getCode()) {
            //400异常不需要持久化，将异常信息以友好的方式告知用户就可以
            //将50异常信息持久化处理，方便运维人员处理
        }
        return AjaxResponse.error(e);
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public AjaxResponse exception(Exception e) {
        return  AjaxResponse.error(new CustomException(
                CustomExceptionType.OTHER_ERROR
        ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public AjaxResponse handleBindexception(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        assert fieldError!=null;
        return AjaxResponse.error(new CustomException(CustomExceptionType.USER_INPUT_ERROR,fieldError.getDefaultMessage()));
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public AjaxResponse handleBindexception(BindException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        assert fieldError!=null;
        return AjaxResponse.error(new CustomException(CustomExceptionType.USER_INPUT_ERROR,fieldError.getDefaultMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public AjaxResponse handleIllegalArgumentExceeption(IllegalArgumentException e) {

        return AjaxResponse.error(new CustomException(CustomExceptionType.USER_INPUT_ERROR,e.getMessage()));
    }


}