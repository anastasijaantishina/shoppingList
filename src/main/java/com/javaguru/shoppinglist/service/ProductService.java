package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.mapper.ProductConverter;
import com.javaguru.shoppinglist.repository.Repository;
import com.javaguru.shoppinglist.service.validation.productValidation.ProductValidationService;
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

    public Long createProduct(ProductDTO productdto) {
        validationService.validate(productdto);
        Product product = converter.convert(productdto);
        Product createdProduct = repository.save(product);
        return createdProduct.getId();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public ProductDTO findById(Long id) {
        return repository.findProductById(id)
                .map(product -> converter.convert(product))
                .orElseThrow(() -> new IllegalArgumentException("Product not found by id" + id));
    }

    public ProductDTO findProductByName(String name) {
        return repository.findProductByName(name)
                .map(product -> converter.convert(product))
                .orElseThrow(() -> new IllegalArgumentException("Product not found by name" + name));
    }

    public List<ProductDTO> findAll() {
        return repository.findAll().stream()
                .map(product -> converter.convert(product))
                .collect(Collectors.toList());
    }

    public void update(ProductDTO dto){
        Product product = converter.convert(dto);
        repository.update(product);
    }

}
