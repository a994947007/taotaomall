package com.taotao.rest;

import com.taotao.rest.service.ContentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectTest {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-*.xml");
        System.out.println(context.getBean("getContentListAspect"));
        ContentService serivce = (ContentService) context.getBean("contentServiceImpl");
        System.out.println( serivce.getContentList(89));
    }
}
