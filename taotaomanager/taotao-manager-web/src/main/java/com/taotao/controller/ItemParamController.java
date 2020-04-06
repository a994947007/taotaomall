package com.taotao.controller;

import com.taotao.bean.ItemParam;
import com.taotao.common.bean.EasyUIDataGridResult;
import com.taotao.common.bean.TaotaoResult;
import com.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/item/param")
public class ItemParamController {

    @Autowired
    private ItemParamService service;

    @RequestMapping("/list")
    @ResponseBody
    public EasyUIDataGridResult getItemParamList(Integer page,Integer rows){
        return service.getItemParamList(page,rows);
    }

    @RequestMapping("/query/itemcatid/{itemcatid}")
    @ResponseBody
    public TaotaoResult getItemParamByCid(@PathVariable Long itemcatid){
        return service.getItemParamByCid(itemcatid);
    }

    @RequestMapping("/save/{itemcatid}")
    @ResponseBody
    public TaotaoResult insertItemParam(@PathVariable Long itemcatid,String paramData){
        ItemParam param = new ItemParam();
        param.setItemCatId(itemcatid);
        param.setParamData(paramData);
        return service.insertItemParam(param);
    }
}
