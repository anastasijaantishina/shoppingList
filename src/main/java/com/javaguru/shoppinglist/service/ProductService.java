package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.mapper.ProductConverter;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.repository.Repository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final Repository repository;
    private final ProductValidationService validationService;
    private final ProductConverter converter;

    @Autowired
    public ProductService(Repository repository, ProductValidationService validationService, ProductConverter converter) {
        this.repository = repository;
        this.validationService = validationService;
        this.converter = converter;
    }

    public Long createProduct(Product product) {
        validationService.validate(product);
        Product createdProduct = repository.save(product);
        return createdProduct.getId();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Product findById(Long id) {
        return repository.findProductById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found by id" + id));
    }

    public Product findByName(String name) {
        return repository.findProductByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Product not found by name" + name));
    }

    public List<ProductDTO> findAll() {
        return repository.findAll().stream()
                .map(product -> converter.convert(product))
                .collect(Collectors.toList());
    }

    public void update(Product product){
        repository.update(product);
    }

}
