package org.example.controller;

import org.example.model.Grade;
import org.example.model.Student;
import org.example.model.Subject;
import org.example.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    // Add a new student
    // Test: POST http://localhost:8080/api/students
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        return catalogService.addStudent(student);
    }

    // View all students
    // Test: GET http://localhost:8080/api/students
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return catalogService.getAllStudents();
    }

    // Add a new subject
    // Test: POST http://localhost:8080/api/subjects?name=Mathematics
    @PostMapping("/subjects")
    public Subject addSubject(@RequestParam String name) {
        return catalogService.addSubject(name);
    }

    // Add a grade to a student
    // Test: POST http://localhost:8080/api/grades?studentId=1&subjectId=1&value=10
    @PostMapping("/grades")
    public Grade addGrade(@RequestParam Long studentId, 
                         @RequestParam Long subjectId, 
                         @RequestParam int value) {
        return catalogService.addGrade(studentId, subjectId, value);
    }

    // View grades of a student
    // Test: GET http://localhost:8080/api/students/1/grades
    @GetMapping("/students/{id}/grades")
    public List<Grade> getStudentGrades(@PathVariable Long id) {
        return catalogService.getStudentGrades(id);
    }
}
