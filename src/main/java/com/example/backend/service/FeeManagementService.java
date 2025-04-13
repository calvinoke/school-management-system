package com.example.backend.service;
import com.example.backend.repository.FeeManagementRepository;
import com.example.backend.entity.FeeManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeeManagementService {

    @Autowired
    private FeeManagementRepository repository;

    public List<FeeManagement> getAllFees() {
        return repository.findAll();
    }

    public Optional<FeeManagement> getFeeById(int id) {
        return repository.findById(id);
    }

    public FeeManagement addFee(FeeManagement fee) {
        return repository.save(fee);
    }

    public FeeManagement updateFee(int id, FeeManagement feeDetails) {
        return repository.findById(id).map(fee -> {
            fee.setFee_name(feeDetails.getFee_name());
            fee.setFee_amount(feeDetails.getFee_amount());
            fee.setStudent_id(feeDetails.getStudent_id());
            fee.setClass1(feeDetails.getClass1());
            fee.setStart_date(feeDetails.getStart_date());
            fee.setEnd_date(feeDetails.getEnd_date());
            fee.setPayment_record_id(feeDetails.getPayment_record_id());
            fee.setMonthName(feeDetails.getMonthName());
            return repository.save(fee);
        }).orElse(null);
    }

    public void deleteFee(int id) {
        repository.deleteById(id);
    }
}
