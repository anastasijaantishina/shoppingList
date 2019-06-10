package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Map;

public class ProductInMemoryRepositoryTest {

    @Mock
    Map<Long, Product> products;

    @Mock
    Long productIdSequence = 0L;

    @Test
    public void put() {

    }
}