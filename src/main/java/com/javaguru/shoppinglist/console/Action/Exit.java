package com.javaguru.shoppinglist.console.Action;

import org.springframework.stereotype.Component;

@Component
public class Exit implements ConsoleAction {

    public static final String actionName = "Exit";

    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public String toString() {
        return actionName;
    }
}
