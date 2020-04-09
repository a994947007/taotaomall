package com.taotao.rest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taotao.rest.bean.CatResult;
import com.taotao.rest.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ItemCatController {

    @Autowired
    private ItemCatService  service;

/*    @RequestMapping(value = "/itemcat/all",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String getItemCatList(String callback){
        CatResult result = service.getItemCatList();
        List newData = new ArrayList<>(14);
        for(int i = 0;i<14;i++){
            newData.add(result.getData().get(i));
        }
        result.setData(newData);
        String json = "{}";
        try {
            json = new ObjectMapper().writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return callback + "(" + json +")";
    }*/

    @RequestMapping("/itemcat/all")
    @ResponseBody
    public Object getItemCatList(String callback){
        CatResult catResult = service.getItemCatList();
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(catResult);
        mappingJacksonValue.setJsonpFunction(callback);
        return mappingJacksonValue;
    }
}
