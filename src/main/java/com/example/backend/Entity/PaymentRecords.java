package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "payment_records")
public class PaymentRecords {

    // ================================
    // Fields
    // ================================

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int payment_record_id;

    private int student_id;
    private int payment_amount;
    private String payment_date;
    private String payment_method;
    private String payment_status;
    private String transaction_id;
    private int fee_management_id;
    private String bankName;
    private String accountNumber;
    private String accountName;
    private String payment_remarks;

    // ================================
    // Constructors
    // ================================

    // No-argument constructor required by JPA
    public PaymentRecords() {
    }

    // Constructor for creating a new payment record
    public PaymentRecords(
            int student_id,
            int payment_amount,
            String payment_date,
            String payment_method,
            String payment_status,
            String transaction_id,
            int fee_management_id,
            String bankName,
            String accountNumber,
            String accountName,
            String payment_remarks
    ) {
        this.student_id = student_id;
        this.payment_amount = payment_amount;
        this.payment_date = payment_date;
        this.payment_method = payment_method;
        this.payment_status = payment_status;
        this.transaction_id = transaction_id;
        this.fee_management_id = fee_management_id;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.payment_remarks = payment_remarks;
    }

    // Constructor for updating an existing payment record
    public PaymentRecords(
            int payment_record_id,
            int student_id,
            int payment_amount,
            String payment_date,
            String payment_method,
            String payment_status,
            String transaction_id,
            int fee_management_id,
            String bankName,
            String accountNumber,
            String accountName,
            String payment_remarks
    ) {
        this.payment_record_id = payment_record_id;
        this.student_id = student_id;
        this.payment_amount = payment_amount;
        this.payment_date = payment_date;
        this.payment_method = payment_method;
        this.payment_status = payment_status;
        this.transaction_id = transaction_id;
        this.fee_management_id = fee_management_id;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.payment_remarks = payment_remarks;
    }

    // ================================
    // Getters and Setters
    // ================================

    public int getPayment_record_id() {
        return payment_record_id;
    }

    public void setPayment_record_id(int payment_record_id) {
        this.payment_record_id = payment_record_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getPayment_amount() {
        return payment_amount;
    }

    public void setPayment_amount(int payment_amount) {
        this.payment_amount = payment_amount;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getFee_management_id() {
        return fee_management_id;
    }

    public void setFee_management_id(int fee_management_id) {
        this.fee_management_id = fee_management_id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPayment_remarks() {
        return payment_remarks;
    }

    public void setPayment_remarks(String payment_remarks) {
        this.payment_remarks = payment_remarks;
    }

    // ================================
    // toString()
    // ================================

    @Override
    public String toString() {
        return "PaymentRecords{" +
                "payment_record_id=" + payment_record_id +
                ", student_id=" + student_id +
                ", payment_amount=" + payment_amount +
                ", payment_date='" + payment_date + '\'' +
                ", payment_method='" + payment_method + '\'' +
                ", payment_status='" + payment_status + '\'' +
                ", transaction_id='" + transaction_id + '\'' +
                ", fee_management_id=" + fee_management_id +
                ", bankName='" + bankName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountName='" + accountName + '\'' +
                ", payment_remarks='" + payment_remarks + '\'' +
                '}';
    }
}
