package com.taotao.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.bean.Item;
import com.taotao.bean.ItemExample;
import com.taotao.mapper.ItemMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestPageHelper {


    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/spring-*.xml");
        ItemMapper mapper = applicationContext.getBean(ItemMapper.class);
        ItemExample example = new ItemExample();
        PageHelper.startPage(1,10);
        List<Item> list = mapper.selectByExample(example);
        for (Item item:list){
            System.out.println(item.getTitle());
        }
        PageInfo<Item> pageInfo = new PageInfo<>(list);
        System.out.println(pageInfo.getTotal());
    }
}
