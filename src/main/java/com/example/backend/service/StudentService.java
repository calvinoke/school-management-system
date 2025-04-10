package com.example.backend.service;

import com.example.backend.repository.StudentRepository;
import com.example.backend.Entity.Addstudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Save a student (add or update)
    public Addstudent saveStudent(Addstudent student) {
        return studentRepository.save(student);
    }

    // Get all students
    public List<Addstudent> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get student by email
    public Addstudent getStudentByEmail(String email) {
        return studentRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    // Get students by class
    public List<Addstudent> getStudentsByClass(List<String> classNames) {
        return studentRepository.findByClass1In(classNames);
    }

    // Delete a student by id
    public void deleteStudent(int studentId) {
        studentRepository.deleteById(studentId);
    }

      // Update student
public Addstudent updateStudent(int id, Addstudent student) {
    Optional<Addstudent> existingStudent = studentRepository.findById(id);
    if (existingStudent.isPresent()) {
        Addstudent studentToUpdate = existingStudent.get();
        studentToUpdate.setFull_name(student.getFull_name());  // Use getFull_name() instead of getName()
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

        return studentRepository.save(studentToUpdate);
    }
    return null;  // Return null if student is not found
}

}
