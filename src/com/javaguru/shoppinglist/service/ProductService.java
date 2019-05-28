package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

import java.math.BigDecimal;

public class ProductService {

    ProductInMemoryRepository repository = new ProductInMemoryRepository();
    ProductValidationService validationService = new ProductValidationService();

    public Long createProduct(Product product) {
        validationService.validate(product);
        Product createdProduct = repository.put(product);
        return createdProduct.getId();
    }

    public Product findById(Long id) {
        return repository.findById(id);
    }

    public Product delete(Long id) {
        return repository.delete(id);
    }

    public Product changeProductName(Long id, String name) {
        return repository.changeProductName(id, name);
    }

    public Product changeProductPrice(Long id, BigDecimal price) {
        return repository.changeProductPrice(id, price);
    }
}
