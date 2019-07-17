package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductService {

    private final ProductInMemoryRepository repository;
    private final ProductValidationService validationService;

    @Autowired
    public ProductService(ProductInMemoryRepository repository, ProductValidationService validationService) {
        this.repository = repository;
        this.validationService = validationService;
    }

    public Long createProduct(Product product) {
        validationService.validate(product);
        Product createdProduct = repository.save(product);
        return createdProduct.getId();
    }

    public void delete(Long id) {
        repository.deleteById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found by id" + id));
    }

    public Product findById(Long id) {
        return repository.findProductById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found by id" + id));
    }

    public Product findByname(String name) {
        return repository.findProductByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Product not found by name" + name));
    }

    public void changeProductName(Long id, String name) {
       repository.changeProductName(id, name);
    }

    public void changeProductPrice(Long id, BigDecimal price) {
        repository.changeProductPrice(id, price);
    }
}
