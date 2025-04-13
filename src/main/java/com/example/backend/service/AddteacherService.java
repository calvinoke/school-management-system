package com.example.backend.service;

import com.example.backend.repository.AddteacherRepository;
import com.example.backend.entity.Addteacher;
import com.example.backend.exception.TeacherNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddteacherService {

    private static final Logger logger = LoggerFactory.getLogger(AddteacherService.class);

    private final AddteacherRepository teacherRepository;

    @Autowired
    public AddteacherService(AddteacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    // Create and save a new teacher
    public Addteacher createTeacher(Addteacher teacher) {
        logger.info("Creating teacher: {}", teacher.getEmail());
        return teacherRepository.save(teacher);
    }

    // Update an existing teacher by ID
    public Addteacher updateTeacher(int id, Addteacher updatedTeacher) {
        Optional<Addteacher> existingTeacher = teacherRepository.findById(id);
        if (existingTeacher.isPresent()) {
            Addteacher teacher = existingTeacher.get();
            teacher.setName(updatedTeacher.getName());
            teacher.setEmail(updatedTeacher.getEmail());
            teacher.setPassword(updatedTeacher.getPassword());
            teacher.setQualification(updatedTeacher.getQualification());
            teacher.setMob(updatedTeacher.getMob());
            teacher.setRole(updatedTeacher.getRole());
            teacher.setStatus(updatedTeacher.getStatus());
            teacher.setJoining_date(updatedTeacher.getJoining_date());

            logger.info("Updated teacher with ID: {}", id);
            return teacherRepository.save(teacher);
        } else {
            logger.error("Teacher not found with ID: {}", id);
            throw new TeacherNotFoundException("Teacher not found with id: " + id);
        }
    }

    // Get all teachers
    public List<Addteacher> getAllTeachers() {
        logger.info("Fetching all teachers");
        return teacherRepository.findAll();
    }

    // Get a teacher by ID
    public Optional<Addteacher> getTeacherById(int id) {
        logger.info("Fetching teacher by ID: {}", id);
        return teacherRepository.findById(id);
    }

    // Delete a teacher by ID
    public void deleteTeacher(int id) {
        logger.info("Deleting teacher with ID: {}", id);
        teacherRepository.deleteById(id);
    }
}
