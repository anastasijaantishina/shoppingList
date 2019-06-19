package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
public class ProductValidationService {

    private final LinkedList<ProductValidationRule> validationRules;

    @Autowired
    public ProductValidationService(LinkedList<ProductValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    public void validate(Product product) {
        validationRules.forEach(s -> s.validate(product));
    }
}
