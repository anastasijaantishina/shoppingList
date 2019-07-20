package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.context.annotation.Profile;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@org.springframework.stereotype.Repository
@Profile("inMemoryDatabase")
public class ProductInMemoryRepository implements Repository {

    private Map<Long, Product> products = new HashMap<>();
    private Long productIdSequence = 0L;

    public Product save(Product product) {
        products.put(productIdSequence, product);
        product.setId(productIdSequence);
        productIdSequence++;
        return product;
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        return Optional.ofNullable(products.get(id));
    }

    @Override
    public Optional<Product> findProductByName(String name) {
        return Optional.ofNullable(products.get(name));
    }

    @Override
    public void deleteById(Long id) {
       products.remove(id);
    }

    @Override
    public boolean existByName(String name) {
        return products.values().stream()
                .anyMatch(product -> product.getName().equalsIgnoreCase(name));
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
