package com.javaguru.shoppinglist.service.validation.productValidation;

import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductNameValidationRuleTest {

    @Mock
    private ProductRepository repository;

    @Spy
    @InjectMocks
    ProductNameValidationRule victim;

    private ProductDTO input;
    private ProductDTO productDTO = productDTO5();


    @Test
    public void shouldThrowNullException() {
        input = productDTO();
        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(ProductValidationException.class)
                .hasMessage("Product name must not be null!");
        verify(victim).checkNotNull(input);
    }

    @Test
    public void shouldThrowNameLengthException(){
        input = productDTO2();
        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(ProductValidationException.class)
                .hasMessage("Error! Name is too short.");
    }


    @Test
    public void shouldThrowStartsAndEndsWithException(){
        input = productDTO3();
        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(ProductValidationException.class)
                .hasMessage("Error! Name starts with a space.");
    }

    @Test
    public void shouldThrowInvalidCharactersException(){
        input = productDTO4();
        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(ProductValidationException.class)
                .hasMessage("Error! Name contains invalid characters");
    }

    @Test
    public void shouldThrowUniqueResultException() {
            when(repository.existByName(productDTO.getName()))
                    .thenReturn(true);

            assertThatThrownBy(() -> victim.validate(productDTO))
                    .isInstanceOf(ProductValidationException.class)
                    .hasMessage("Error! Product name should be unique");

            verify(victim).checkNotNull(productDTO);
    }

    private ProductDTO productDTO() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(null);
        productDTO.setPrice(BigDecimal.valueOf(18));
        return productDTO;
    }

    private ProductDTO productDTO2() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("tt");
        productDTO.setPrice(BigDecimal.valueOf(18));
        return productDTO;
    }

    private ProductDTO productDTO3() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("    ttkk");
        productDTO.setPrice(BigDecimal.valueOf(18));
        return productDTO;
    }

    private ProductDTO productDTO4() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("ttkk&$");
        productDTO.setPrice(BigDecimal.valueOf(18));
        return productDTO;
    }

    private ProductDTO productDTO5() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("banan");
        productDTO.setPrice(BigDecimal.valueOf(18));
        return productDTO;
    }
}