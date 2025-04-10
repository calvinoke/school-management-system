package com.example.backend.controller;

import com.example.backend.Entity.Addstudent;
import com.example.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Add or update student
    @PostMapping
    public ResponseEntity<Addstudent> addStudent(@RequestBody Addstudent student) {
        Addstudent savedStudent = studentService.saveStudent(student);
        return ResponseEntity.ok(savedStudent);
    }

    // Get all students
    @GetMapping
    public ResponseEntity<List<Addstudent>> getAllStudents() {
        List<Addstudent> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    // Get student by email
    @GetMapping("/email/{email}")
    public ResponseEntity<Addstudent> getStudentByEmail(@PathVariable String email) {
        Addstudent student = studentService.getStudentByEmail(email);
        return student != null ? ResponseEntity.ok(student) : ResponseEntity.notFound().build();
    }

    // Get students by class
    @PostMapping("/class")
    public ResponseEntity<List<Addstudent>> getStudentsByClass(@RequestBody List<String> classNames) {
        List<Addstudent> students = studentService.getStudentsByClass(classNames);
        return ResponseEntity.ok(students);
    }

    // Delete student by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    // Update student
    @PutMapping("/{id}")
    public ResponseEntity<Addstudent> updateStudent(@PathVariable int id, @RequestBody Addstudent student) {
        Addstudent updatedStudent = studentService.updateStudent(id, student);
        return updatedStudent != null ? ResponseEntity.ok(updatedStudent) : ResponseEntity.notFound().build();
    }
}
