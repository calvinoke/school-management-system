package com.example.backend.service;

import com.example.backend.entity.Classroutine;
import com.example.backend.repository.ClassroutineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassroutineService {

    @Autowired
    private ClassroutineRepository classroutineRepository;

    // Save class routine
    public Classroutine saveClassroutine(Classroutine classroutine) {
        return classroutineRepository.save(classroutine);
    }

    // Get all class routines
    public List<Classroutine> getAllClassroutines() {
        return classroutineRepository.findAll();
    }

    // Get class routine by ID
    public Optional<Classroutine> getClassroutineById(Long id) {
        return classroutineRepository.findById(id);
    }

    // Update class routine
    public Classroutine updateClassroutine(Classroutine classroutine) {
        return classroutineRepository.save(classroutine);
    }

    // Delete class routine by ID
    public void deleteClassroutine(Long id) {
        classroutineRepository.deleteById(id);
    }
}
