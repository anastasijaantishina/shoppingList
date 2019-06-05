package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

import java.math.BigDecimal;

public class ProductService {

    private ProductInMemoryRepository repository = new ProductInMemoryRepository();
    private ProductValidationService validationService = new ProductValidationService(repository);

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
