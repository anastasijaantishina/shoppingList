package com.javaguru.shoppinglist.config;

import com.javaguru.shoppinglist.service.validation.ProductDiscountValidationRule;
import com.javaguru.shoppinglist.service.validation.ProductNameValidationRule;
import com.javaguru.shoppinglist.service.validation.ProductNullValidationRule;
import com.javaguru.shoppinglist.service.validation.ProductPriceValidationRule;
import com.javaguru.shoppinglist.service.validation.ProductValidationRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedList;

@Configuration
@ComponentScan(basePackages = "com.javaguru.shoppinglist")
public class AppConfig {

    @Bean
    LinkedList<ProductValidationRule> validationRules(ProductNullValidationRule rule1,
                                                ProductNameValidationRule rule2,
                                                ProductPriceValidationRule rule3,
                                                ProductDiscountValidationRule rule4) {
        LinkedList<ProductValidationRule> rules = new LinkedList<>();
        rules.add(rule1);
        rules.add(rule2);
        rules.add(rule3);
        rules.add(rule4);
        return rules;
    }
}
