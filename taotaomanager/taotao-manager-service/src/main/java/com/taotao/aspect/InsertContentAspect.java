package com.taotao.aspect;

import com.taotao.bean.Content;
import com.taotao.common.bean.TaotaoResult;
import com.taotao.common.utils.HttpClientUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class InsertContentAspect {

    @Value("${REST_BASE_URL}")
    private String REST_BASE_URL;

    @Value("${CONTENT_CACHE_URL}")
    private String CONTENT_CACHE_URL;

    @Pointcut("execution(public * com.taotao.service.ContentService.insertContent(..))")
    public void msg(){}

    @After(value = "msg()")
    public void excute(JoinPoint joinPoint){
        try {
            Object [] args = joinPoint.getArgs();
            if(args != null && args.length > 0){
                Content content = (Content)args[0];
                HttpClientUtil.doGet(REST_BASE_URL + CONTENT_CACHE_URL + String.valueOf(content.getCategoryId()),null);
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
