package com.taotao.portal.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taotao.portal.bean.IndexAd;
import com.taotao.portal.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ContentController {

    @Autowired
    private ContentService service;

    @RequestMapping("/index")
    //使用Model可以在jsp页面加载时直接被渲染，页面源码可动态变化，有利于SEO优化
    public String showIndex(Model model){
        List<IndexAd> indexAdList = service.getContentList();
        try {
            model.addAttribute("ad1",new ObjectMapper().writeValueAsString(indexAdList));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "index";
    }
}
