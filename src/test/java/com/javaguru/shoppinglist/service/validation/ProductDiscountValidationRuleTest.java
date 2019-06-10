package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

public class ProductDiscountValidationRuleTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    private Product input;
    private ProductDiscountValidationRule victim = new ProductDiscountValidationRule();

    @Test
    public void shouldThrowDiscountValidationException() {
        input = productWithMaxDiscount(BigDecimal.valueOf(90));

        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Error! The discount can not be more than 80%");

        victim.validate(input);
    }

    @Test
    public void negativeDiscountValidationTest() {
        input = productWithMinDiscount(BigDecimal.valueOf(-1));

        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Error! The discount can not be negative");

        victim.validate(input);
    }

    private Product productWithMinDiscount(BigDecimal discount) {
        Product product = new Product();
        product.setDiscount(BigDecimal.valueOf(-1));
        return product;
    }

    private Product productWithMaxDiscount(BigDecimal discount) {
        Product product = new Product();
        product.setDiscount(BigDecimal.valueOf(90));
        return product;
    }


}