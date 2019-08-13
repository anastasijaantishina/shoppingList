package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.dto.CartDTO;
import com.javaguru.shoppinglist.mapper.CartConverter;
import com.javaguru.shoppinglist.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartService {

    private final ShoppingCartRepository repository;
    private final CartConverter converter;


    @Autowired
    public ShoppingCartService(ShoppingCartRepository repository, CartConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    public Long createCart(ShoppingCart cart) {
        ShoppingCart createdCart = repository.save(cart);
        return createdCart.getId();
    }

    public void update(ShoppingCart cart) {
        repository.update(cart);
    }

    public ShoppingCart findByName(String name) {
        return repository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Cart not found by name" + name));
    }

    public List<CartDTO> findAll() {
        return repository.findAll().stream()
                .map(shoppingCart -> converter.convert(shoppingCart))
                .collect(Collectors.toList());
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }


}
