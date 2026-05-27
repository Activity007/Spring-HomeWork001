package org.example.spring.Test;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private final static ArrayList<Student> students = new ArrayList<>(){{
        add(new Student(1, "candy", "female"));
        add(new Student(2, "jimmy", "male"));
        add(new Student(3, "moly", "female"));
    }};

    // return all the student for rest controller

    public List<Student> getStudents() {
        return students;
    }
}
