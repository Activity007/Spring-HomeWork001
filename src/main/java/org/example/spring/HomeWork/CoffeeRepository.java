package org.example.spring.HomeWork;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class CoffeeRepository {

    @Bean
    public Coffee coffee1() {
        return new Coffee("0001", "Ice Americano", 2.5, true);
    }

    @Bean
    public Coffee coffee2() {
        return new Coffee("0002", "Hot Coffee", 2.5, false);
    }

    @Bean
    public Coffee coffee3() {
        return new Coffee("0003", "Ice Latte", 2.5, true);
    }

    @Bean
    public ArrayList<Coffee> coffees() {

        ArrayList<Coffee> coffees = new ArrayList<>();

        coffees.add(coffee1());
        coffees.add(coffee2());
        coffees.add(coffee3());

        return coffees;
    }
}