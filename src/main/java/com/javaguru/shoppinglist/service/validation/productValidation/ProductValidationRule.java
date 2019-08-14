package com.javaguru.shoppinglist.service.validation.productValidation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;

public interface ProductValidationRule {

    void validate(ProductDTO product);

    void checkNotNull(ProductDTO product);
}
