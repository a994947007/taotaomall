package com.taotao.rest.aspect;

import com.taotao.bean.Content;
import com.taotao.common.utils.JsonUtil;
import com.taotao.rest.dao.JedisClient;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;

@Component
@Aspect
public class GetContentListAspect {
    @Autowired
    private JedisClient jedisClient;

    @Value("${CONTENT_REDIS_KEY}")
    private String CONTENT_REDIS_KEY;

    @Pointcut("execution(public * com.taotao.rest.service.ContentService.getContentList(..))")
    public void msg(){}

    //拦截spring
    @Around(value = "msg()")
    public List<Content> execute(ProceedingJoinPoint proceedingJoinPoint){
        //查询业务，查询后需要将数据写入到缓存中
        try {
            Object [] args = proceedingJoinPoint.getArgs();
            if(args != null && args.length > 0){
                String field = String.valueOf(args[0]);
                String json =  jedisClient.hget(CONTENT_REDIS_KEY,field);
                if(json != null && !json.isEmpty()){
                    List<Content> list = JsonUtil.jsonToList(json,Content.class);
                    return list;
                }else{   //缓存为空，则执行原来的业务方法，并将其写入缓存
                    List<Content> list = (List<Content>)proceedingJoinPoint.proceed();
                    String listJson = JsonUtil.objectToJson(list);
                    jedisClient.hset(CONTENT_REDIS_KEY,field,listJson);
                    return list;
                }
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            //遇到异常，执行原来的业务方法
            List<Content> list = null;
            try {
                list = (List<Content>)proceedingJoinPoint.proceed();
            } catch (Throwable throwable1) {
                throwable1.printStackTrace();
            }
            return list;
        }
        return null;
    }
}

