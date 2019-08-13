package com.javaguru.shoppinglist.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class CartDTO {

    private Long id;
    private String name;
    private int productCount;
    private BigDecimal totalAmount;

    public CartDTO(Long id, String name, int productCount, BigDecimal totalAmount) {
        this.id = id;
        this.name = name;
        this.productCount = productCount;
        this.totalAmount = totalAmount;
    }

    public CartDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartDTO cartDTO = (CartDTO) o;
        return productCount == cartDTO.productCount &&
                Objects.equals(id, cartDTO.id) &&
                Objects.equals(name, cartDTO.name) &&
                Objects.equals(totalAmount, cartDTO.totalAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, productCount, totalAmount);
    }

    @Override
    public String toString() {
        return "CartDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productCount=" + productCount +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
