package org.example.spring;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component("koko")
@Data
public class Student {
    private Integer id;
    private String name;
}
