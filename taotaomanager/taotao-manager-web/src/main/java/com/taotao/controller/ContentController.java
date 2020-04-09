package com.taotao.controller;

import com.taotao.bean.Content;
import com.taotao.common.bean.EasyUIDataGridResult;
import com.taotao.common.bean.TaotaoResult;
import com.taotao.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentService service;

    @RequestMapping("/query/list")
    @ResponseBody
    public EasyUIDataGridResult getContentListByCategoryId(Long categoryId) {
        return service.getContentList(categoryId);
    }


    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult insertContent(Content content){
        return service.insertContent(content);
    }
}
