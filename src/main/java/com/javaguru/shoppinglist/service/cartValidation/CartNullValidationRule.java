package com.javaguru.shoppinglist.service.cartValidation;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.dto.CartDTO;
import org.springframework.stereotype.Component;

@Component
public class CartNullValidationRule implements CartValidationRule {

    @Override
    public void validate(CartDTO cart) {
        checkNotNull(cart);
    }

    @Override
    public void checkNotNull(CartDTO cart) {
        if (cart == null) {
            throw new CartValidationException("Cart must not be null");
        }
    }
}

