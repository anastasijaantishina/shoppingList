package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.Product;

import java.math.BigDecimal;

public class ProductDiscountValidationRule implements ProductValidationRule {

    private final BigDecimal MAX_DISCOUNT = new BigDecimal(80).setScale(0, BigDecimal.ROUND_DOWN);
    private final BigDecimal MIN_DISCOUNT = new BigDecimal(0).setScale(0, BigDecimal.ROUND_DOWN);

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        discountAmountValidation(product);
        PriceForDiscountValidation(product);
    }

    @Override
    public void checkNotNull(Product product) {
        if (product.getDiscount() == null) {
            throw new ProductValidationException("Product discount must not be null");
        }
    }

    private void discountAmountValidation(Product product) {
        if (product.getDiscount().compareTo(MAX_DISCOUNT) > 0) {
            throw new ProductValidationException("Error! The discount can not be more than " + MAX_DISCOUNT + '%');
        }
        if (product.getDiscount().compareTo(MIN_DISCOUNT) < 0) {
            throw new ProductValidationException("Error! The discount can not be negative");
        }
    }
    public void PriceForDiscountValidation(Product product) {
        if ((product.getPrice().compareTo(BigDecimal.valueOf(20)) < 0) && (product.getDiscount().compareTo(MIN_DISCOUNT) > 0)) {
            throw new ProductValidationException("Error! Insufficient price for discount");
        }
    }
}
