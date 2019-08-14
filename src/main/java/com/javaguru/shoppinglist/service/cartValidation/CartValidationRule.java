package com.javaguru.shoppinglist.service.cartValidation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;

public interface CartValidationRule {

    void validate(ShoppingCart cart);

    void checkNotNull(ShoppingCart cart);
}
