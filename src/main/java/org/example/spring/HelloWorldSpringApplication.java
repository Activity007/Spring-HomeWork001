package org.example.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class HelloWorldSpringApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(HelloWorldSpringApplication.class, args);
        System.out.println("------ All beans in the application ------");
        String[] beanName = context.getBeanDefinitionNames();

        Arrays.sort(beanName);
        for(var bean : beanName){
            System.out.println(bean);
        }

    }

}