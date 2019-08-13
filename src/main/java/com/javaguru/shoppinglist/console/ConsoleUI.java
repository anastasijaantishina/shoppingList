package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.console.Action.ConsoleAction;
import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.enums.ProductCategory;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleUI {

    private final List<ConsoleAction> actions;

    public ConsoleUI(List<ConsoleAction> actions) {
        this.actions = actions;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        int response = 0;

        while (response >= 0) {
            printMenu();
            try {
                response = scanner.nextInt();
                actions.get(response).execute();
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
                e.printStackTrace();
            }
        }
    }

    private void printMenu() {
        for (int i = 0; i < actions.size(); i++) {
            System.out.println(i + ". " + actions.get(i));
        }
    }
}