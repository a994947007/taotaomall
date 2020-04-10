package com.taotao.rest.service;

import com.taotao.common.bean.TaotaoResult;
import com.taotao.rest.dao.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {

    @Value("CONTENT_REDIS_KEY")
    private String CONTENT_REDIS_KEY;

    @Autowired
    private JedisClient jedisClient;

    @Override
    public TaotaoResult syncContent(long categoryId) {
        try{
            jedisClient.hdel(CONTENT_REDIS_KEY,String.valueOf(categoryId));
        }catch (Exception e){
            e.printStackTrace();
            return TaotaoResult.build(500,"缓存同步异常");
        }
        return TaotaoResult.ok();
    }
}
