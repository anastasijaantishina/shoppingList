package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.Product;

public class ProductNameValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        nullNameValidation(product.getName());
        nameLengthValidation(product.getName());
        beginningAndEndOfNameValidation(product.getName());
        spacesCountValidation(product.getName());
        correctUseOfSpacesValidation(product.getName());
        useOfInvalidCharactersValidation(product.getName());
    }

    private void nullNameValidation(String name) {
        if (name.isEmpty()) {
            throw new ProductValidationException("Error! There is no name.");
        }
    }

    private void nameLengthValidation(String name) {
        if (name.length() < 3) {
            throw new ProductValidationException("Error! Name is too short.");
        }
        if (name.length() > 30) {
            throw new ProductValidationException("Error! Name is too long.");
        }
    }

    private void beginningAndEndOfNameValidation(String name) {
        if (name.startsWith(" ")) {
            throw new ProductValidationException("Error! Name starts with a space.");
        }
        if (name.endsWith(" ")) {
            throw new ProductValidationException("Error! Name ends with a space.");
        }
    }

    private void spacesCountValidation(String name) {
        char[] charArray = name.toCharArray();
        int spacesCount = 0;

        for (char character : charArray) {
            if (character == ' ') {
                spacesCount++;
            }
            if (spacesCount > 3) {
                throw new ProductValidationException("Error! Name contains too much spaces.");
            }
        }
    }

    private void correctUseOfSpacesValidation(String name) {
        char[] charArray = name.toCharArray();
        boolean previousSpace = false;

        for (char character : charArray) {
            if ((character == ' ') && (previousSpace)) {
                throw new ProductValidationException("Error! Spaces in the name go one by one");
            } else {
                previousSpace = character == ' ';
            }
        }
    }

    private void useOfInvalidCharactersValidation(String name) {
        char[] charArray = name.toCharArray();

        for (char character : charArray) {
            if (character > 32 && character < 48) {
                throw new ProductValidationException("Error! Name contains invalid characters");
            }
            if (character > 57 && character < 65) {
                throw new ProductValidationException("Error! Name contains invalid characters");
            }
            if (character > 90 && character < 97) {
                throw new ProductValidationException("Error! Name contains invalid characters");
            }
            if (character > 122) {
                throw new ProductValidationException("Error! Name contains invalid characters");
            }
        }
    }
}


