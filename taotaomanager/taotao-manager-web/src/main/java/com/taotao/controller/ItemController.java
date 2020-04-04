package com.taotao.controller;

import com.taotao.bean.ItemDesc;
import com.taotao.common.bean.EasyUIDataGridResult;
import com.taotao.bean.Item;
import com.taotao.common.bean.TaotaoResult;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/save")
    @ResponseBody
    public TaotaoResult addItem(Item item,String desc){
        ItemDesc itemDesc = new ItemDesc();
        itemDesc.setItemDesc(desc);
        TaotaoResult taotaoResult = itemService.addItem(item, itemDesc);
        return taotaoResult;
    }
}
