package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.Product;

import java.math.BigDecimal;

public class ProductPriceValidationRule implements ProductValidationRule {

    private final BigDecimal MIN_PRICE = new BigDecimal(0.01).setScale(2, BigDecimal.ROUND_DOWN);

    @Override
    public void validate(Product product) {
        nullPriceValidation(product.getPrice());
        minPriceValidation(product.getPrice());
    }

    private void nullPriceValidation(BigDecimal price) {
        if (price == null) {
            throw new ProductValidationException("Error! Product price must not be null");
        }
    }

    private void minPriceValidation(BigDecimal price) {
        if ((price.compareTo(MIN_PRICE) < 0)) {
            throw new ProductValidationException("Error! The price can not be less than " + MIN_PRICE + "Eur");
        }
    }
}
