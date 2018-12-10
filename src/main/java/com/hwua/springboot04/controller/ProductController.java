package com.hwua.springboot04.controller;

import com.hwua.springboot04.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    @Autowired
    private ProductDao productDao;

//    @RequestMapping(method = RequestMethod.GET)
    @GetMapping("/products")
    public String list(Model model){
        model.addAttribute("products",productDao.getAll());
        return "list";
    }

}
