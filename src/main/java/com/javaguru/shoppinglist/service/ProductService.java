package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
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
        Product createdProduct = repository.put(product);
        return createdProduct.getId();
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public void changeProductName(Long id, String name) {
       repository.changeProductName(id, name);
    }

    public void changeProductPrice(Long id, BigDecimal price) {
        repository.changeProductPrice(id, price);
    }
}
