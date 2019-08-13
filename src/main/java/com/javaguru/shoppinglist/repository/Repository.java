package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface Repository {

    Product save(Product product);

    Optional<Product> findProductById(Long id);

    Optional<Product> findProductByName(String name);

    void deleteById(Long id);

    boolean existByName(String name);

    List<Product> findAll();

    Product changeProductDiscount(Long id, BigDecimal discount);

}
