package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static java.math.BigDecimal.ONE;
import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    private static final long ID = 1L;

    @Mock
    private ProductInMemoryRepository repository;

    @Mock
    ProductValidationService validationService;

    @InjectMocks
    private ProductService service;

    @Test
    public void createProduct() {
        Product product = new Product();
        product.setId(ID);

        when(repository.put(product)).thenReturn(product);

        Long id = service.createProduct(product);

        verify(validationService).validate(product);
        assertEquals(id, product.getId());
    }

    @Test
    public void delete() {
        service.delete(ID);

        verify(repository).delete(ID);
    }

    @Test
    public void changeProductName() {
        String name = "name";
        service.changeProductName(ID, name);

        verify(repository).changeProductName(ID, name);
    }

    @Test
    public void changeProductPrice() {
        service.changeProductPrice(ID, ONE);

        verify(repository).changeProductPrice(ID, ONE);
    }
}