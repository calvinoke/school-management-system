package com.example.backend.controller;
import com.example.backend.service.ExamscheduleService;
import com.example.backend.entity.Examschedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/examschedules")
public class ExamscheduleController {

    @Autowired
    private ExamscheduleService service;

    @GetMapping
    public List<Examschedule> getAllExamSchedules() {
        return service.getAllExamSchedules();
    }

    @GetMapping("/{id}")
    public Optional<Examschedule> getExamScheduleById(@PathVariable int id) {
        return service.getExamScheduleById(id);
    }

    @PostMapping
    public Examschedule addExamSchedule(@RequestBody Examschedule examSchedule) {
        return service.addExamSchedule(examSchedule);
    }

    @PutMapping("/{id}")
    public Examschedule updateExamSchedule(@PathVariable int id, @RequestBody Examschedule updatedExam) {
        return service.updateExamSchedule(id, updatedExam);
    }

    @DeleteMapping("/{id}")
    public void deleteExamSchedule(@PathVariable int id) {
        service.deleteExamSchedule(id);
    }
}
