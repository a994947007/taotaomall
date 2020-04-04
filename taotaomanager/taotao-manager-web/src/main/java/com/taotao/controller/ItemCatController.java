package com.taotao.controller;

import com.taotao.common.bean.EasyUITreeNode;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

    @Autowired
    private ItemCatService service;

    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITreeNode> getCatList(@RequestParam(value="id",defaultValue = "0") Long parentId){
        return service.getCatList(parentId);
    }
}
