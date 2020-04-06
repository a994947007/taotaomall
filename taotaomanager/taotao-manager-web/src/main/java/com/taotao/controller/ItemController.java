package com.taotao.controller;

import com.taotao.bean.ItemDesc;
import com.taotao.bean.ItemParamItem;
import com.taotao.common.bean.EasyUIDataGridResult;
import com.taotao.bean.Item;
import com.taotao.common.bean.TaotaoResult;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/{itemId}")
    @ResponseBody
    public Item getItemById(@PathVariable  Long itemId){
        Item item = itemService.getItemById(itemId);
        return item;
    }

    @RequestMapping("/list")
    @ResponseBody
    public EasyUIDataGridResult getItemList(Integer page,Integer rows){
        return itemService.getItemList(page,rows);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult addItem(Item item,String desc,String itemParams){
        ItemDesc itemDesc = new ItemDesc();
        itemDesc.setItemDesc(desc);
        ItemParamItem itemParamItem = new ItemParamItem();
        itemParamItem.setParamData(itemParams);
        TaotaoResult taotaoResult = itemService.addItem(item, itemDesc,itemParamItem);
        return taotaoResult;
    }
}
