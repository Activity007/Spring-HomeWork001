package org.example.spring.HomeWork;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CoffeeRepository {
    private final ArrayList<Coffee> coffeeList = new ArrayList<>(){{
        add(new CoffeeConfig().coffee1());
        add(new CoffeeConfig().coffee2());
        add(new CoffeeConfig().coffee3());
    }};

    public List<Coffee> getCaffeeList() {
        return coffeeList;
    }
}