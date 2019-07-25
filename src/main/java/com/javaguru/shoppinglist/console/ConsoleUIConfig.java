package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.console.Action.ConsoleAction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class ConsoleUIConfig {

    private final ConsoleAction changeProductDiscount;
    private final ConsoleAction createProduct;
    private final ConsoleAction deleteProductById;
    private final ConsoleAction exit;
    private final ConsoleAction findAllProducts;
    private final ConsoleAction findProductById;

    public ConsoleUIConfig(ConsoleAction changeProductDiscount,
                           ConsoleAction createProduct,
                           ConsoleAction deleteProductById,
                           ConsoleAction exit,
                           ConsoleAction findAllProducts,
                           ConsoleAction findProductById) {
        this.changeProductDiscount = changeProductDiscount;
        this.createProduct = createProduct;
        this.deleteProductById = deleteProductById;
        this.exit = exit;
        this.findAllProducts = findAllProducts;
        this.findProductById = findProductById;
    }

    @Bean
    ConsoleUI consoleUI(){
        List<ConsoleAction> actions = new ArrayList<>();
        actions.add(createProduct);
        actions.add(findProductById);
        actions.add(deleteProductById);
        actions.add(findAllProducts);
        actions.add(changeProductDiscount);
        actions.add(exit);
        return new ConsoleUI(actions);
    }
}
