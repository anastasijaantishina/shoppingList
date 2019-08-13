package com.javaguru.shoppinglist.console.Action;

import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class ChangeProductDiscount implements ConsoleAction {

    public static final String actionName = "Change product discount";

    public final ProductService productService;

    public ChangeProductDiscount(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        Long id = Long.valueOf(scanner.nextLine());
        System.out.println("Enter product new discount: ");
        BigDecimal discount = new BigDecimal(scanner.nextLine());
        productService.changeProductDiscount(id, discount);
        System.out.println("New discount is: " + discount);
    }

    @Override
    public String toString() {
        return actionName;
    }
}
