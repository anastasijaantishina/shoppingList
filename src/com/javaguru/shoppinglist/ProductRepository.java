package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ProductRepository implements Repository<Product> {

    private Map<Long, Product> products = new HashMap<>();
    private Long productIdSequence = Long.valueOf(0);

    @Override
    public void add(Product product) {
        products.put(productIdSequence, product);
        product.setId(productIdSequence);
        productIdSequence++;
    }

    @Override
    public void delete(Long id) {
        products.remove(id);
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
