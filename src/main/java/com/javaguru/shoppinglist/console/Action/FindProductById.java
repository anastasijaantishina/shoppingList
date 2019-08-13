package com.javaguru.shoppinglist.console.Action;

import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class FindProductById implements ConsoleAction {

    public static final String actionName = "Find product by ID";

    public final ProductService productService;

    public FindProductById(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        Long id = Long.valueOf(scanner.nextLine());
        productService.findProductById(id);
    }

    @Override
    public String toString() {
        return actionName;
    }
}
