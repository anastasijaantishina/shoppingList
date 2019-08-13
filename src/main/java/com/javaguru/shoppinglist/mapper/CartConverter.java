package com.javaguru.shoppinglist.mapper;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.dto.CartDTO;
import org.springframework.stereotype.Component;

@Component
public class CartConverter {

    public ShoppingCart convert(CartDTO dto) {
        ShoppingCart cart = new ShoppingCart();
        cart.setName(dto.getName());
        cart.setProductCount(dto.getProductCount());
        cart.setTotalAmount(dto.getTotalAmount());
        return cart;
    }

    public CartDTO convert(ShoppingCart cart) {
        CartDTO dto = new CartDTO();
        dto.setName(cart.getName());
        dto.setProductCount(cart.getProductCount());
        dto.setTotalAmount(cart.getTotalAmount());
        return dto;
    }
}
