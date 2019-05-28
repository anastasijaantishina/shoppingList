package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ProductInMemoryRepository {

    private Map<Long, Product> products = new HashMap<>();
    private Long productIdSequence = Long.valueOf(0);

    public Product put(Product product) {
        products.put(productIdSequence, product);
        product.setId(productIdSequence);
        productIdSequence++;
        return product;
    }

    public void delete(Long id) {
        if(!products.containsKey(id)) {
            System.out.println("ID not found!");
        } else {
            products.remove(id);
        }
    }

    public void changeProductName(Long id, String name) {
        if (!products.containsKey(id)) {
            System.out.println("ID not found!");
        } else {
            products.get(id).setName(name);
        }
    }

    public void changeProductPrice(Long id, BigDecimal price) {
        if (!products.containsKey(id)) {
            System.out.println("ID not found!");
        } else {
            products.get(id).setPrice(price);
        }
    }
}
