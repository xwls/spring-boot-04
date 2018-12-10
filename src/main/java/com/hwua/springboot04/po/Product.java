package com.hwua.springboot04.po;

import org.hibernate.validator.constraints.Length;

public class Product {
    private Integer id;
    @Length(min = 10,message = "名字不能小于10个长度")
    private String name;
    private String imgUrl;
    private Double price;
    private Integer inventory;

    public Product() {
    }

    public Product(Integer id, String name, String imgUrl, Double price, Integer inventory) {
        this.id = id;
        this.name = name;
        this.imgUrl = imgUrl;
        this.price = price;
        this.inventory = inventory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }
}
