package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.HibernateProductRepository;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.repository.Repository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import static org.hibernate.hql.internal.antlr.HqlSqlTokenTypes.SELECT;

@Service
public class ProductService {

    private final Repository repository;
    private final ProductValidationService validationService;


    @Autowired
    public ProductService(Repository repository, ProductValidationService validationService) {
        this.repository = repository;
        this.validationService = validationService;
    }

    public Long createProduct(Product product) {
        validationService.validate(product);
        Product createdProduct = repository.save(product);
        return createdProduct.getId();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Product findProductById(Long id) {
        return repository.findProductById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found by id" + id));
    }

    public Product findProductByName(String name) {
        return repository.findProductByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Product not found by name" + name));
    }

    public List<Product> findAll(){
        return repository.findAll();
    }

    public void changeProductDiscount(Long id, BigDecimal discount) {
       repository.changeProductDiscount(id, discount);
    }


}
