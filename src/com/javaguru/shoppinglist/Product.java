package com.javaguru.shoppinglist;

import java.math.BigDecimal;

public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
    private ProductCategory category;
    private BigDecimal discount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal priceWithDiscount() {
        return price.subtract(getPrice().multiply(getDiscount()).divide(BigDecimal.valueOf(100)));
    }

    public void printInformation() {
        System.out.println("Product id - " + id);
        System.out.println("Name of product - " + name);
        System.out.println("Product category - " + category);
        System.out.println("Regular price of product = " + price + " EUR");
        if ((discount.compareTo(BigDecimal.valueOf(1)) > 0)) {
            System.out.println("Discount on product = " + discount + " %");
            System.out.println("Price with discount = " + priceWithDiscount() + " EUR");
        }
    }
}