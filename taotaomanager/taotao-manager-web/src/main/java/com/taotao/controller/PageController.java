package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/")
    public  String showIndex(){
        return "index"; //配了视图解析器之后，会自动追加.jsp
    }

    @RequestMapping("{page}")
    public String showPage(@PathVariable String page){
        return page;
    }
}
