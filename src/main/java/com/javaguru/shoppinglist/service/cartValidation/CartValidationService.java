package com.javaguru.shoppinglist.service.cartValidation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartValidationService {

    private final List<CartValidationRule> validationRules;

    public CartValidationService(List<CartValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    public void validate(ShoppingCart cart) {
        validationRules.forEach(s -> s.validate(cart));
    }
}
