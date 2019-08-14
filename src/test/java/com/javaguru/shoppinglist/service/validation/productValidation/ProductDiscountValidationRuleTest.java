package com.javaguru.shoppinglist.service.validation.productValidation;

import com.javaguru.shoppinglist.dto.ProductDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductDiscountValidationRuleTest {

    @Spy
    ProductDiscountValidationRule victim;

    private ProductDTO input;

    @Test
    public void shouldThrowNullException() {
        input = productDTO();
        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(ProductValidationException.class)
                .hasMessage("Product discount must not be null!");
        verify(victim).checkNotNull(input);
    }

    @Test
    public void shouldValidateSuccess(){
        input = productDTO2();
        victim.validate(input);

        verify(victim).checkNotNull(input);
    }

    @Test
    public void shouldThrowDiscountAmountException(){
        input = productDTO3();
        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(ProductValidationException.class)
                .hasMessage("Error! The discount can not be more than 80%");
        verify(victim).discountAmountValidation(input);

    }

    @Test
    public void shouldThrowMinPriceException(){
        input = productDTO4();
        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(ProductValidationException.class)
                .hasMessage("Error! Insufficient price for discount");
        verify(victim).checkMinPriceForDiscount(input);

    }

    private ProductDTO productDTO() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setDiscount(null);
        productDTO.setPrice(BigDecimal.valueOf(100));
        return productDTO;
    }

    private ProductDTO productDTO2() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setDiscount(BigDecimal.valueOf(23));
        productDTO.setPrice(BigDecimal.valueOf(100));
        return productDTO;
    }

    private ProductDTO productDTO3() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setDiscount(BigDecimal.valueOf(88));
        productDTO.setPrice(BigDecimal.valueOf(100));
        return productDTO;
    }

    private ProductDTO productDTO4() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setDiscount(BigDecimal.valueOf(38));
        productDTO.setPrice(BigDecimal.valueOf(18));
        return productDTO;
    }


}