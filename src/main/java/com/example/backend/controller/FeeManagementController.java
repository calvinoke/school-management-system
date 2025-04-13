package com.example.backend.controller;
import com.example.backend.service.FeeManagementService;
import com.example.backend.entity.FeeManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fees")
@CrossOrigin(origins = "*")
public class FeeManagementController {

    @Autowired
    private FeeManagementService service;

    @GetMapping
    public List<FeeManagement> getAllFees() {
        return service.getAllFees();
    }

    @GetMapping("/{id}")
    public Optional<FeeManagement> getFeeById(@PathVariable int id) {
        return service.getFeeById(id);
    }

    @PostMapping
    public FeeManagement createFee(@RequestBody FeeManagement fee) {
        return service.addFee(fee);
    }

    @PutMapping("/{id}")
    public FeeManagement updateFee(@PathVariable int id, @RequestBody FeeManagement feeDetails) {
        return service.updateFee(id, feeDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteFee(@PathVariable int id) {
        service.deleteFee(id);
    }
}
