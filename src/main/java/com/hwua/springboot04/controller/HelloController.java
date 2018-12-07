package com.hwua.springboot04.controller;

import com.hwua.springboot04.po.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("name","张三");
        model.addAttribute("src","https://www.baidu.com/img/bd_logo1.png");
        model.addAttribute("names", Arrays.asList("张三","李四","王五"));
        return "hello";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

}
