package com.taotao.controller;

import com.taotao.common.bean.TaotaoResult;
import com.taotao.service.ItemParamItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/item/param/item")
public class ItemParamItemControlloer {

    @Autowired
    private ItemParamItemService service;

    @RequestMapping("/{itemId}")
    @ResponseBody
    public TaotaoResult getItemParamItemByItemId(@PathVariable Long itemId){
        return service.getItemParamItemByItemId(itemId);
    }
}
