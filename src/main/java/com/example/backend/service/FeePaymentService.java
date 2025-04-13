package com.example.backend.service;

import com.example.backend.repository.FeeManagementRepository;
import com.example.backend.repository.StudentRepository;
import com.example.backend.repository.PaymentRecordsRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.backend.dto.FeePaymentDTO;
import com.example.backend.entity.FeeManagement;
import com.example.backend.entity.PaymentRecords;
import com.example.backend.entity.Addstudent;



@Service
public class FeePaymentService {

    @Autowired
    private FeeManagementRepository feeRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PaymentRecordsRepository paymentRepository;

    public FeePaymentDTO getFeePaymentDetails(int studentId) {
        // Entities
        FeeManagement fee = feeRepository.findLatestByStudentId(studentId);
        Addstudent student = studentRepository.findById(studentId).orElseThrow();
        PaymentRecords payment = paymentRepository.findByStudentId(studentId);

        FeePaymentDTO dto = new FeePaymentDTO(
            fee.getFee_management_id(),
            fee.getFee_name(),
            fee.getFee_amount(),
            fee.getMonthName(),
            fee.getStart_date(),
            fee.getEnd_date(),
            student.getStudent_id(),
            student.getFull_name(),
            student.getClass1(),
            student.getSection(),
            payment.getPayment_record_id(),
            payment.getPayment_amount(),
            payment.getPayment_date(),
            payment.getPayment_method(),
            payment.getPayment_status(),
            payment.getTransaction_id(),
            payment.getBankName(),
            payment.getAccountNumber(),
            payment.getAccountName(),
            payment.getPayment_remarks()
        );

        return dto;
    }
}
