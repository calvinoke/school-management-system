package com.example.backend.repository;

import com.example.backend.entity.PaymentRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//import com.example.backend.entity.PaymentRecords;

@Repository
public interface PaymentRecordsRepository extends JpaRepository<PaymentRecords, Integer> {
    // Custom method to find PaymentRecords by studentId
    PaymentRecords findByStudentId(int studentId);
}
