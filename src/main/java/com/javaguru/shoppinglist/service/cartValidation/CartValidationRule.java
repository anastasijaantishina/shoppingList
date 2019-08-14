package com.javaguru.shoppinglist.service.cartValidation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.dto.CartDTO;

public interface CartValidationRule {

    void validate(CartDTO cart);

    void checkNotNull(CartDTO cart);
}
