package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Profile("jdbc")
public class JdbcProductRepository implements com.javaguru.shoppinglist.repository.Repository {

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> findProductByName(String name) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {
    }

    @Override
    public boolean existByName(String name) {
        return false;
    }
}
