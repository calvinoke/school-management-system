package com.example.backend.service;

import com.example.backend.repository.StudentRepository; // Import the StudentRepository for interacting with the database
import com.example.backend.Entity.Addstudent; // Import the Addstudent entity for handling student data
import org.springframework.beans.factory.annotation.Autowired; // Import to handle dependency injection
import org.springframework.stereotype.Service; // Mark this class as a service component in Spring

import java.util.List; // Import List to handle collections of students
import java.util.Optional; // Import Optional for better handling of null values

@Service // Mark the class as a Spring service, which contains business logic
public class StudentService {

    private final StudentRepository studentRepository; // Declare the studentRepository to interact with the database

    // Constructor to inject the StudentRepository via dependency injection
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository; // Initialize the repository
    }

    // Save a student (add or update)
    // The save method will either add a new student or update an existing one
    public Addstudent saveStudent(Addstudent student) {
        return studentRepository.save(student); // Call save method on the repository to persist the student object
    }

    // Get all students
    // This method fetches all student records from the database
    public List<Addstudent> getAllStudents() {
        return studentRepository.findAll(); // Retrieve all student records from the repository
    }

    // Get student by email
    // This method searches for a student using the email, throwing an exception if not found
    public Addstudent getStudentByEmail(String email) {
        return studentRepository.findByEmail(email) // Search for the student by email
                .orElseThrow(() -> new RuntimeException("Student not found")); // If not found, throw an exception
    }

    // Get students by class
    // This method retrieves students based on the class names passed in the list
    public List<Addstudent> getStudentsByClass(List<String> classNames) {
        return studentRepository.findByClass1In(classNames); // Fetch students by class names using the repository
    }

    // Delete a student by id
    // This method deletes the student record with the given id
    public void deleteStudent(int studentId) {
        studentRepository.deleteById(studentId); // Call deleteById method of the repository to remove the student
    }

    // Update student
    // This method checks if the student exists and updates their information
    public Addstudent updateStudent(int id, Addstudent student) {
        Optional<Addstudent> existingStudent = studentRepository.findById(id); // Find the student by ID
        if (existingStudent.isPresent()) { // If the student exists
            Addstudent studentToUpdate = existingStudent.get(); // Get the existing student
            // Set updated fields from the provided student object
            studentToUpdate.setFull_name(student.getFull_name());
            studentToUpdate.setEmail(student.getEmail());
            studentToUpdate.setClass1(student.getClass1());
            studentToUpdate.setSubject(student.getSubject());
            studentToUpdate.setPresent_address(student.getPresent_address());
            studentToUpdate.setPermanent_address(student.getPermanent_address());
            studentToUpdate.setSession(student.getSession());
            studentToUpdate.setStatus(student.getStatus());
            studentToUpdate.setSection(student.getSection());
            studentToUpdate.setDob(student.getDob());
            studentToUpdate.setMob(student.getMob());
            studentToUpdate.setGender(student.getGender());

            return studentRepository.save(studentToUpdate); // Save the updated student to the database
        }
        return null;  // Return null if student is not found, indicating the update was unsuccessful
    }

}
