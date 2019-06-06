package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.Product;

import org.junit.Test;
import org.mockito.Mock;

import java.util.Map;

import static org.junit.Assert.*;

public class ProductInMemoryRepositoryTest {

    @Mock
    Map<Long, Product> products;

    @Mock
    Long productIdSequence = 0L;

    @Test
    public void put() {

    }
}