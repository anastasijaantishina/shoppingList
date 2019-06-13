package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.console.ConsoleUI;
import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.validation.ProductDiscountValidationRule;
import com.javaguru.shoppinglist.service.validation.ProductNameValidationRule;
import com.javaguru.shoppinglist.service.validation.ProductNullValidationRule;
import com.javaguru.shoppinglist.service.validation.ProductPriceValidationRule;
import com.javaguru.shoppinglist.service.validation.ProductValidationRule;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class ShoppingListApplication {

    public static void main(String[] args) {
        ProductInMemoryRepository repository = new ProductInMemoryRepository();

        List<ProductValidationRule> validationRules = new LinkedList<>();
        validationRules.add(new ProductNullValidationRule());
        validationRules.add(new ProductNameValidationRule(repository));
        validationRules.add(new ProductDiscountValidationRule());
        validationRules.add(new ProductPriceValidationRule());

        ProductValidationService validationService = new ProductValidationService(validationRules);

        ProductService productService = new ProductService(repository, validationService);

        ConsoleUI consoleUI = new ConsoleUI(productService);
        consoleUI.execute();
    }
}
