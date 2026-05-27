package org.example.spring.HomeWork;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/coffees")
public class CoffeeRestController {
    private final CoffeeRepository coffeeRepository;
    public CoffeeRestController(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }
    @GetMapping("")
    public Map<String, Object> getAllCoffees() {
        Map<String, Object> coffees = new HashMap<>();
        coffees.put("message", "Get all coffees Successfully");
        coffees.put("status", HttpStatus.OK.value());
        coffees.put("payload",coffeeRepository.coffees());
        return coffees;
    }
}
