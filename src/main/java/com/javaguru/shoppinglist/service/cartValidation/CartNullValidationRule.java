package com.javaguru.shoppinglist.service.cartValidation;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import org.springframework.stereotype.Component;

@Component
public class CartNullValidationRule implements CartValidationRule {

    @Override
    public void validate(ShoppingCart cart) {
        checkNotNull(cart);
    }

    @Override
    public void checkNotNull(ShoppingCart cart) {
        if (cart == null) {
            throw new CartValidationException("Cart must not be null");
        }
    }
}

