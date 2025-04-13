package com.example.backend.controller;

import com.example.backend.entity.Addteacher;
import com.example.backend.service.AddteacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class AddteacherController {

    @Autowired
    private AddteacherService teacherService;

    @PostMapping
    public ResponseEntity<Addteacher> createTeacher(@Valid @RequestBody Addteacher teacher) {
        return ResponseEntity.ok(teacherService.createTeacher(teacher));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Addteacher> updateTeacher(@PathVariable int id, @Valid @RequestBody Addteacher teacher) {
        return ResponseEntity.ok(teacherService.updateTeacher(id, teacher));
    }

    @GetMapping
    public ResponseEntity<List<Addteacher>> getAllTeachers() {
        return ResponseEntity.ok(teacherService.getAllTeachers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Addteacher> getTeacherById(@PathVariable int id) {
        return teacherService.getTeacherById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable int id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.noContent().build();
    }
}
