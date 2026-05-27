package org.example.spring.Test;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping("/id/{id}")
    public Map<String, Object> getStudentById(@PathVariable int id) { // pathVaraible jab nv value that ke pdol oy tam url
        var result = studentRepository.findStudentById(id);
        Map<String, Object> response = new HashMap<>();
        if (result.isPresent()) {
            response.put("message", "Get Student Successfully");
            response.put("status", HttpStatus.OK.value());
            response.put("payload",result.get());
        }
        else {
            response.put("message", "Failed to find student with id " + id);
            response.put("status", HttpStatus.NOT_FOUND.value());
            response.put("payload",studentRepository.findStudentById(id));
        }
        return response;
    }
    @GetMapping("/name/{name}")
    public Map<String, Object> getStudentByName(@PathVariable String name) { // pathVaraible jab nv value that ke pdol oy tam url
        var results = studentRepository.findStudentByName(name);
        Map<String, Object> response = new HashMap<>();
        if (results.isPresent()) {
            response.put("message", "Get Student Successfully");
            response.put("status", HttpStatus.OK.value());
            response.put("payload",results.get());
        }
        else {
            response.put("message", "Failed to find student name " + name);
            response.put("status", HttpStatus.NOT_FOUND.value());
            response.put("payload",studentRepository.findStudentByName(name));
        }
        return response;
    }

}
