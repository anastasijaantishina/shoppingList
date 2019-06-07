package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import java.util.LinkedList;
import java.util.List;

public class ProductValidationService {

    private List<ProductValidationRule> validationRules = new LinkedList<>();

    public ProductValidationService(ProductInMemoryRepository repository) {
        validationRules.add(new ProductNameValidationRule(repository));
        validationRules.add(new ProductPriceValidationRule());
        validationRules.add(new ProductDiscountValidationRule());
    }

    public void validate(Product product) {
        validationRules.forEach(s -> s.validate(product));
    }
}
