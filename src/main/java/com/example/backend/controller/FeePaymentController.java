package com.example.backend.controller; // change this to your actual package

import com.example.backend.dto.FeePaymentDTO;
import com.example.backend.service.FeePaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fee-payment")
public class FeePaymentController {

    @Autowired
    private FeePaymentService feePaymentService;

    @GetMapping("/{studentId}")
    public ResponseEntity<FeePaymentDTO> getFeePaymentInfo(@PathVariable int studentId) {
        FeePaymentDTO dto = feePaymentService.getFeePaymentDetails(studentId);
        return ResponseEntity.ok(dto);
    }
}
