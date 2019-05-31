package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.Product;

import java.math.BigDecimal;

public class ProductDiscountValidationRule implements ProductValidationRule{

    private final BigDecimal MAX_DISCOUNT = new BigDecimal(80).setScale(0, BigDecimal.ROUND_DOWN);
    private final BigDecimal MIN_DISCOUNT = new BigDecimal(0).setScale(0, BigDecimal.ROUND_DOWN);

    @Override
    public void validate(Product product) {
        checkNotNull(product.getDiscount());
        discountAmountValidation(product.getDiscount());
    }

    private void checkNotNull(BigDecimal discount) {
        if (discount == null) {
            throw new ProductValidationException("Product discount must not be null");
        }
    }

    private void discountAmountValidation(BigDecimal discount) {
        if (discount.compareTo(MAX_DISCOUNT) > 0) {
            throw new ProductValidationException("Error! The discount can not be more than " + MAX_DISCOUNT + '%');
        }
        if (discount.compareTo(MIN_DISCOUNT) < 0) {
            throw new ProductValidationException("Error! The discount can not be negative");
        }
    }
}
