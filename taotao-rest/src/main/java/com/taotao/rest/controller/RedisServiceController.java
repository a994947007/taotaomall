package com.taotao.rest.controller;

import com.taotao.common.bean.TaotaoResult;
import com.taotao.rest.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 开放一个服务，用于清除缓存
 */
@Controller
@RequestMapping("/cache")
public class RedisServiceController {

    @Autowired
    private RedisService service;

    @RequestMapping("/sync/content/{categoryId}")
    @ResponseBody
    public TaotaoResult syncContent(@PathVariable Long categoryId){
        return service.syncContent(categoryId);
    }
}
