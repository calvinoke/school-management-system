package com.example.backend.controller;

import com.example.backend.dto.StudentResultInfoDTO;
import com.example.backend.service.StudentResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/results")
public class StudentResultController {

    @Autowired
    private StudentResultService studentResultService;

    @GetMapping("/all")
    public List<StudentResultInfoDTO> getAllStudentResults() {
        return studentResultService.getAllStudentResults();
    }
}
