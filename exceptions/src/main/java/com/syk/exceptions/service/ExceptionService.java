package com.syk.exceptions.service;


import com.syk.exceptions.consts.MsgConsts;
import com.syk.exceptions.enums.CustomExceptionType;
import com.syk.exceptions.exception.CustomException;
import org.springframework.stereotype.Service;

/**
 * @Author 沈永康
 * @Date 2022/4/11 12:57
 * @Version 1.0
 */

@Service
public class ExceptionService {
    public  void systemBizError(){
        try {
            Class.forName("co.mysql.jdbc.cj.Driver");
        }catch (ClassNotFoundException e){
            throw new CustomException(CustomExceptionType.SYSTEM_ERROR,"在xxx业务，myBiz（）方法类，出现ClassNotFoundException,请讲想嘻嘻告知管理员 ！");
        }
    }
    public void  userBizError(int input){
        if (input < 0){
            throw new CustomException(
                    CustomExceptionType.USER_INPUT_ERROR,
                    MsgConsts.PHONE_ERROR
            );
        }
    }
}
