package com.example.backend.controller;

import com.example.backend.entity.Classroutine;
import com.example.backend.service.ClassroutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/classroutines")
public class ClassroutineController {

    @Autowired
    private ClassroutineService classroutineService;

    // Save a class routine
    @PostMapping("/save")
    public Classroutine saveClassroutine(@RequestBody Classroutine classroutine) {
        return classroutineService.saveClassroutine(classroutine);
    }

    // Get all class routines
    @GetMapping("/all")
    public List<Classroutine> getAllClassroutines() {
        return classroutineService.getAllClassroutines();
    }

    // Get class routine by ID
    @GetMapping("/{id}")
    public Optional<Classroutine> getClassroutineById(@PathVariable Long id) {
        return classroutineService.getClassroutineById(id);
    }

    // Update class routine
    @PutMapping("/update")
    public Classroutine updateClassroutine(@RequestBody Classroutine classroutine) {
        return classroutineService.updateClassroutine(classroutine);
    }

    // Delete class routine by ID
    @DeleteMapping("/delete/{id}")
    public void deleteClassroutine(@PathVariable Long id) {
        classroutineService.deleteClassroutine(id);
    }
}
