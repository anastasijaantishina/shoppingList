package com.javaguru.shoppinglist.service.cartValidation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.repository.ShoppingCartRepository;
import org.springframework.stereotype.Component;

@Component
public class CartNameValidationRule implements CartValidationRule {

    private final ShoppingCartRepository repository;

    public CartNameValidationRule(ShoppingCartRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(ShoppingCart cart) {
        checkNotNull(cart);
        nameLengthValidation(cart.getName());
        uniqueNameValidation(cart);
    }

    @Override
    public void checkNotNull(ShoppingCart cart) {

        if (cart.getName() == null) {
            throw new CartValidationException("Cart name must not be null!");
        }
    }

    private void nameLengthValidation(String name) {
        if (name.length() < 2) {
            throw new CartValidationException("Error! Name is too short.");
        }
        if (name.length() > 30) {
            throw new CartValidationException("Error! Name is too long.");
        }
    }

    private void uniqueNameValidation(ShoppingCart cart) {
        if (repository.existByName(cart.getName())) {
            throw new CartValidationException("Error! Product name should be unique");
        }
    }


}
