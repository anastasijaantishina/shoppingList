package com.javaguru.shoppinglist;

import java.math.BigDecimal;

public class ValidationService {

    private final BigDecimal MIN_PRICE = new BigDecimal(0.01).setScale(2, BigDecimal.ROUND_DOWN);

    public void validateName(String name) {
        nullNameValidation(name);
        nameLengthValidation(name);
        beginningAndEndOfNameValidation(name);
        spacesCountValidation(name);
        correctUseOfSpacesValidation(name);
        useOfInvalidCharactersValidation(name);
    }

    public void validatePrice(BigDecimal price) {
        if ((price.compareTo(MIN_PRICE) < 0)) {
            throw new ValidationException("Error! The price can not be less than " + MIN_PRICE + '$');
        }
    }

    public void validateDiscount(int discount) {
        if (discount > 80 || discount <= 0) {
            throw new ValidationException("Error! Incorrect amount of discount.");
        }
    }

    private void nullNameValidation(String name) {
        if (name.isEmpty()) {
            throw new ValidationException("Error! There is no name.");
        }
    }

    private void nameLengthValidation(String name) {
        if (name.length() < 3) {
            throw new ValidationException("Error! Name is too short.");
        }
        if (name.length() > 30) {
            throw new ValidationException("Error! Name is too long.");
        }
    }

    private void beginningAndEndOfNameValidation(String name) {
        if (name.startsWith(" ")) {
            throw new ValidationException("Error! Name starts with a space.");
        }
        if (name.endsWith(" ")) {
            throw new ValidationException("Error! Name ends with a space.");
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
                throw new ValidationException("Error! Name contains too much spaces.");
            }
        }
    }

    private void correctUseOfSpacesValidation(String name) {
        char[] charArray = name.toCharArray();
        boolean previousSpace = false;

        for (char character : charArray) {
            if ((character == ' ') && (previousSpace)) {
                throw new ValidationException("Error! Spaces in the name go one by one");
            } else {
                previousSpace = character == ' ';
            }
        }
    }

    private void useOfInvalidCharactersValidation(String name) {
        char[] charArray = name.toCharArray();

        for (char character : charArray) {
            if (character > 32 && character < 48) {
                throw new ValidationException("Error! Name contains invalid characters");
            }
            if (character > 57 && character < 65) {
                throw new ValidationException("Error! Name contains invalid characters");
            }
            if (character > 90 && character < 97) {
                throw new ValidationException("Error! Name contains invalid characters");
            }
            if (character > 122) {
                throw new ValidationException("Error! Name contains invalid characters");
            }
        }
    }
}
