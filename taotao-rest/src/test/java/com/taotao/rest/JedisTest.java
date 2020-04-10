package com.taotao.rest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.JedisCluster;

import java.io.IOException;

public class JedisTest {

    @Test
    public void Test() throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-*.xml");
        JedisCluster jc = (JedisCluster) context.getBean("redisClient");
        System.out.println( jc.get("name"));
        jc.close();
    }
}
