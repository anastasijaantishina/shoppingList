package com.javaguru.shoppinglist.console.Action;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class DeleteProductById implements ConsoleAction {

    public static final String actionName = "Delete product by ID";

    public final ProductService productService;

    public DeleteProductById(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter product id: ");
            Long id = scanner.nextLong();
            productService.delete(id);
    }

    @Override
    public String toString() {
        return actionName;
    }
}
