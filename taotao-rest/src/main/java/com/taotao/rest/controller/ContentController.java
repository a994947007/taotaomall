package com.taotao.rest.controller;

import com.taotao.bean.Content;
import com.taotao.common.bean.TaotaoResult;
import com.taotao.rest.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentService service;

    @RequestMapping("/list/{categoryId}")
    @ResponseBody
    public TaotaoResult getContentList(@PathVariable Long categoryId) {
        try{
            List<Content> list = service.getContentList(categoryId);
            return TaotaoResult.ok(list);
        }catch (Exception e){
            e.printStackTrace();
            return TaotaoResult.build(500,"获取时发生异常");
        }
    }
}
