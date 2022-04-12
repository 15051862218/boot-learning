package com.syk.exceptions.advice;


import com.syk.exceptions.utils.AjaxResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Author 沈永康
 * @Date 2022/4/11 16:26
 * @Version 1.0
 */

@Component
@ControllerAdvice
public class GlobalResponseAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (selectedContentType.equalsTypeAndSubtype(MediaType.APPLICATION_JSON)) {
            if (body instanceof  AjaxResponse ajaxResponse){
                if (ajaxResponse.getCode() != 999){
                    response.setStatusCode(HttpStatus.valueOf(
                            ajaxResponse.getCode()
                    ));
                }
                return  body;
            }else {
                response.setStatusCode(HttpStatus.OK);
                return AjaxResponse.success(body);

            }
        }
        return body;
    }
}
