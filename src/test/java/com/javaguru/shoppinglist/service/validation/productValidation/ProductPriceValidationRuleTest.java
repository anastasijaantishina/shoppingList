package com.javaguru.shoppinglist.service.validation.productValidation;

import com.javaguru.shoppinglist.dto.ProductDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductPriceValidationRuleTest {


    @Spy
    private ProductPriceValidationRule victim;

    private ProductDTO input = productDTO();

    @Test
    public void shouldThrowMinPriceValidationException() {
        input = productDTO();

        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(ProductValidationException.class)
                .hasMessage("Error! The price can not be less than 1 eur");
    }


    private ProductDTO productDTO() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("name");
        productDTO.setPrice(BigDecimal.valueOf(-2));
        productDTO.setDiscount(BigDecimal.valueOf(0));
        return productDTO;
    }
}