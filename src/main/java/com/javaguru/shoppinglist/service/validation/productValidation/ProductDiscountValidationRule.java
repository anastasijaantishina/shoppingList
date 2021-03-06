package com.javaguru.shoppinglist.service.validation.productValidation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductDiscountValidationRule implements ProductValidationRule {

    private final BigDecimal MAX_DISCOUNT = new BigDecimal(80).setScale(0, BigDecimal.ROUND_DOWN);
    private final BigDecimal MIN_DISCOUNT = new BigDecimal(0).setScale(0, BigDecimal.ROUND_DOWN);

    @Override
    public void validate(ProductDTO product) {
        checkNotNull(product);
        discountAmountValidation(product);
        checkMinPriceForDiscount(product);
    }

    @Override
    public void checkNotNull(ProductDTO product) {
        if (product.getDiscount() == null) {
            throw new ProductValidationException("Product discount must not be null!");
        }
    }

    public void discountAmountValidation(ProductDTO product) {
        if (product.getDiscount().compareTo(MAX_DISCOUNT) > 0) {
            throw new ProductValidationException("Error! The discount can not be more than 80%");
        }
        if (product.getDiscount().compareTo(MIN_DISCOUNT) < 0) {
            throw new ProductValidationException("Error! The discount can not be negative");
        }
    }
    public void checkMinPriceForDiscount(ProductDTO product) {
        if ((product.getPrice().compareTo(BigDecimal.valueOf(20)) < 0) && (product.getDiscount().compareTo(MIN_DISCOUNT) > 0)) {
            throw new ProductValidationException("Error! Insufficient price for discount");
        }
    }
}
