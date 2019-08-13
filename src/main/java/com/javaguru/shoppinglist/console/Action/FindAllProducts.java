package com.javaguru.shoppinglist.console.Action;

import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.stereotype.Component;

@Component
public class FindAllProducts implements ConsoleAction {

    public static final String actionName = "Find all products";

    public final ProductService productService;

    public FindAllProducts(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        System.out.println(productService.findAll());
    }

    @Override
    public String toString() {
        return actionName;
    }
}
