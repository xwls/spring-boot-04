package com.hwua.springboot04.controller;

import com.hwua.springboot04.dao.ProductDao;
import com.hwua.springboot04.po.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/product")
    public String toAddForm(){
        return "form";
    }

    @GetMapping("/product/{productId}")
    public String toEditForm(@PathVariable Integer productId, Model model){
        Product product = productDao.get(productId);
        model.addAttribute("product",product);
        return "form";
    }

}
