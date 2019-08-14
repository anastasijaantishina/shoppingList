package com.javaguru.shoppinglist.service.validation.productValidation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductNullValidationRule implements ProductValidationRule {
    @Override
    public void validate(ProductDTO product) {
        checkNotNull(product);
    }

    @Override
    public void checkNotNull(ProductDTO product) {
        if (product == null) {
            throw new ProductValidationException("Product must not be null");
        }
    }
}
