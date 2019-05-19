package com.javaguru.shoppinglist;

 class ValidationException extends RuntimeException {

    ValidationException() {
    }

    ValidationException(String message) {
        super(message);
    }

    ValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    ValidationException(Throwable cause) {
        super(cause);
    }

    ValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
