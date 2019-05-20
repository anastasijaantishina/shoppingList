package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class shoppingListService implements Repository<Product> {

    private Map<Long, Product> products = new HashMap<>();
    private Long counter = Long.valueOf(0);

    @Override
    public void add(Product product) {
        products.put(counter, product);
        product.setId(counter);
        counter++;
    }

    @Override
    public void delete(Long id) {
        products.remove(id);
    }

    public void setProductName(Long id, String name) {
        for (Product product : products.values()) {
            if (product.getId().equals(id)) {
                product.setName(name);
            }
        }
    }

    public void setProductPrice(Long id, BigDecimal price) {
        for (Product product : products.values()) {
            if (product.getId().equals(id)) {
                product.setPrice(price);
            }
        }
    }
}
