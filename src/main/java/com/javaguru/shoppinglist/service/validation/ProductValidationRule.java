package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.Product;

public interface ProductValidationRule {

    void validate(Product product);

    void checkNotNull(Product product);
}
