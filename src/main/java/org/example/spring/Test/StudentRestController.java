package org.example.spring.Test;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/students")
public class StudentRestController {
    private final StudentRepository studentRepository;
    private StudentRestController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @GetMapping("")
    public Map<String, Object> getAllStudents() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Get All students Successfully");
        response.put("status", HttpStatus.OK.value());
        response.put("payload",studentRepository.getStudents());
        return response ;
    }
}
