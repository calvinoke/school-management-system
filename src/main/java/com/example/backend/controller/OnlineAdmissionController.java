package com.example.backend.controller;

import com.example.backend.entity.OnlineAdmission;
import com.example.backend.service.OnlineAdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admissions")
public class OnlineAdmissionController {

    @Autowired
    private OnlineAdmissionService service;

    @PostMapping
    public OnlineAdmission createAdmission(@RequestBody OnlineAdmission admission) {
        return service.save(admission);
    }

    @GetMapping
    public List<OnlineAdmission> getAllAdmissions() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public OnlineAdmission getAdmissionById(@PathVariable int id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAdmission(@PathVariable int id) {
        service.delete(id);
    }
}
