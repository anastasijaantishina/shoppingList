package com.javaguru.shoppinglist.service.cartValidation;

public class CartValidationException extends RuntimeException {

    CartValidationException(String message){
        super(message);
    }
}
