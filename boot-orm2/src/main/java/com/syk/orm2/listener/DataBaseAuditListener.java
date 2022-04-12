package com.syk.orm2.listener;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * @Author 沈永康
 * @Date 2022/3/18 15:08
 * @Version 1.0
 */

@Component
@Slf4j
public class DataBaseAuditListener {

    public void  prePersist(Object object) throws  IllegalArgumentException,IllegalAccessException{
        Class<?> aClass = object.getClass();
        try {
            addOperateTime(object,aClass,"createTime");

        }catch (NoSuchFieldException e){
            log.error("反射获取属性异常",e);
        }
    }

    public void preUpdate(Object object) throws IllegalArgumentException,IllegalAccessException{
        Class<?> aClass = object.getClass();
        try {
            addOperateTime(object,aClass,"createTime");

        }catch (NoSuchFieldException e){
            log.error("反射获取属性异常",e);
        }
    }
    protected  void addOperateTime(Object object,Class<?> aClass, String propertyName) throws IllegalAccessException, NoSuchFieldException {
        Field time = aClass.getDeclaredField(propertyName);
        time.setAccessible(true);

        Object createdTimeValue = time.get(object);
        if(createdTimeValue == null){
            time.set(object,new Date());
        }
    }
}
