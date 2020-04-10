package com.taotao.rest.aspect;

import com.taotao.bean.Content;
import com.taotao.common.utils.JsonUtil;
import com.taotao.rest.bean.CatResult;
import com.taotao.rest.dao.JedisClient;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class GetItemCatListAspect {

    @Autowired
    private JedisClient jedisClient;

    @Value("${ITEMCAT_REDIS_KEY}")
    private String ITEMCAT_REDIS_KEY;

    @Pointcut("execution(public * com.taotao.rest.service.ItemCatService.getItemCatList(..))")
    public void msg(){}

    @Around(value = "msg()")
    public CatResult excute(ProceedingJoinPoint proceedingJoinPoint){
        String json =  jedisClient.hget(ITEMCAT_REDIS_KEY,"0");
        try {
            if (json != null && !json.isEmpty()) {
                CatResult catResult = JsonUtil.jsonToPojo(json, CatResult.class);
                return catResult;
            } else {   //缓存为空，则执行原来的业务方法，并将其写入缓存
                CatResult catResult = (CatResult) proceedingJoinPoint.proceed();
                String listJson = JsonUtil.objectToJson(catResult);
                jedisClient.hset(ITEMCAT_REDIS_KEY, "0", listJson);
                return catResult;
            }
        }catch (Throwable throwable){
            throwable.printStackTrace();
            CatResult catResult = null;
            try {
                catResult = (CatResult) proceedingJoinPoint.proceed();
            } catch (Throwable throwable1) {
                throwable1.printStackTrace();
            }
            return catResult;
        }
    }
}
