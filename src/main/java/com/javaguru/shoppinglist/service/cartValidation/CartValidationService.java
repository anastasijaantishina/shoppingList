package com.javaguru.shoppinglist.service.cartValidation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.dto.CartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartValidationService {

    private final List<CartValidationRule> validationRules;

    @Autowired
    public CartValidationService(List<CartValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    public void validate(CartDTO cartdto) {
        validationRules.forEach(s -> s.validate(cartdto));
    }
}
