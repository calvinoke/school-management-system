package com.example.backend.controller;

import com.example.backend.entity.Addstudent;
import com.example.backend.service.StudentService; // Import the StudentService to interact with business logic
import org.springframework.beans.factory.annotation.Autowired; // Import for dependency injection
import org.springframework.http.ResponseEntity; // Import for creating HTTP responses
import org.springframework.web.bind.annotation.*; // Import for defining REST endpoints

import java.util.List; // Import List to handle collections of students

@RestController // Mark the class as a REST controller, handling HTTP requests and responses
@RequestMapping("/students") // Map the controller to handle requests starting with "/students"
public class StudentController {

    private final StudentService studentService; // Declare the StudentService to handle business logic

    // Constructor for dependency injection, injecting StudentService
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService; // Initialize the service
    }

    // Add or update student
    // This endpoint handles POST requests to save a new student or update an existing one
    @PostMapping
    public ResponseEntity<Addstudent> addStudent(@RequestBody Addstudent student) {
        Addstudent savedStudent = studentService.saveStudent(student); // Call service to save student
        return ResponseEntity.ok(savedStudent); // Return the saved student as the response with a 200 OK status
    }

    // Get all students
    // This endpoint handles GET requests to retrieve all students
    @GetMapping
    public ResponseEntity<List<Addstudent>> getAllStudents() {
        List<Addstudent> students = studentService.getAllStudents(); // Retrieve all students from the service
        return ResponseEntity.ok(students); // Return the list of students as the response with a 200 OK status
    }

    // Get student by email
    // This endpoint handles GET requests to retrieve a student based on email
    @GetMapping("/email/{email}")
    public ResponseEntity<Addstudent> getStudentByEmail(@PathVariable String email) {
        Addstudent student = studentService.getStudentByEmail(email); // Retrieve student by email
        return student != null ? ResponseEntity.ok(student) : ResponseEntity.notFound().build(); 
        // If student is found, return it with 200 OK status; otherwise, return a 404 Not Found
    }

    // Get students by class
    // This endpoint handles POST requests to retrieve students based on the class names provided in the body
    @PostMapping("/class")
    public ResponseEntity<List<Addstudent>> getStudentsByClass(@RequestBody List<String> classNames) {
        List<Addstudent> students = studentService.getStudentsByClass(classNames); // Retrieve students by class
        return ResponseEntity.ok(students); // Return the list of students as the response with a 200 OK status
    }

    // Delete student by ID
    // This endpoint handles DELETE requests to remove a student by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id); // Call service to delete student by ID
        return ResponseEntity.noContent().build(); // Return a 204 No Content response indicating successful deletion
    }

    // Update student
    // This endpoint handles PUT requests to update an existing student's details
    @PutMapping("/{id}")
    public ResponseEntity<Addstudent> updateStudent(@PathVariable int id, @RequestBody Addstudent student) {
        Addstudent updatedStudent = studentService.updateStudent(id, student); // Update the student using service
        return updatedStudent != null ? ResponseEntity.ok(updatedStudent) : ResponseEntity.notFound().build(); 
        // If student is updated, return it with 200 OK status; otherwise, return 404 Not Found
    }
}
