package com.example.backend.dto;

public class FeePaymentDTO {
    private int fee_management_id;
    private String fee_name;
    private int fee_amount;
    private String monthName;
    private String start_date;
    private String end_date;

    private int student_id;
    private String stu_full_name;
    private String class1;
    private String section;

    private int payment_record_id;
    private int payment_amount;
    private String payment_date;
    private String payment_method;
    private String payment_status;
    private String transaction_id;
    private String bankName;
    private String accountNumber;
    private String accountName;
    private String paymentRemarks;

    public FeePaymentDTO() {
        // Default constructor
    }

    public FeePaymentDTO(int fee_management_id, String fee_name, int fee_amount, String monthName, String start_date,
                         String end_date, int student_id, String stu_full_name, String class1, String section,
                         int payment_record_id, int payment_amount, String payment_date, String payment_method,
                         String payment_status, String transaction_id, String bankName, String accountNumber,
                         String accountName, String paymentRemarks) {
        this.fee_management_id = fee_management_id;
        this.fee_name = fee_name;
        this.fee_amount = fee_amount;
        this.monthName = monthName;
        this.start_date = start_date;
        this.end_date = end_date;
        this.student_id = student_id;
        this.stu_full_name = stu_full_name;
        this.class1 = class1;
        this.section = section;
        this.payment_record_id = payment_record_id;
        this.payment_amount = payment_amount;
        this.payment_date = payment_date;
        this.payment_method = payment_method;
        this.payment_status = payment_status;
        this.transaction_id = transaction_id;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.paymentRemarks = paymentRemarks;
    }

    // Getters and Setters

    public int getFee_management_id() {
        return fee_management_id;
    }

    public void setFee_management_id(int fee_management_id) {
        this.fee_management_id = fee_management_id;
    }

    public String getFee_name() {
        return fee_name;
    }

    public void setFee_name(String fee_name) {
        this.fee_name = fee_name;
    }

    public int getFee_amount() {
        return fee_amount;
    }

    public void setFee_amount(int fee_amount) {
        this.fee_amount = fee_amount;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getStu_full_name() {
        return stu_full_name;
    }

    public void setStu_full_name(String stu_full_name) {
        this.stu_full_name = stu_full_name;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getPayment_record_id() {
        return payment_record_id;
    }

    public void setPayment_record_id(int payment_record_id) {
        this.payment_record_id = payment_record_id;
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

    public String getPaymentRemarks() {
        return paymentRemarks;
    }

    public void setPaymentRemarks(String paymentRemarks) {
        this.paymentRemarks = paymentRemarks;
    }

    @Override
    public String toString() {
        return "FeePaymentDTO{" +
                "fee_management_id=" + fee_management_id +
                ", fee_name='" + fee_name + '\'' +
                ", fee_amount=" + fee_amount +
                ", monthName='" + monthName + '\'' +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", student_id=" + student_id +
                ", stu_full_name='" + stu_full_name + '\'' +
                ", class1='" + class1 + '\'' +
                ", section='" + section + '\'' +
                ", payment_record_id=" + payment_record_id +
                ", payment_amount=" + payment_amount +
                ", payment_date='" + payment_date + '\'' +
                ", payment_method='" + payment_method + '\'' +
                ", payment_status='" + payment_status + '\'' +
                ", transaction_id='" + transaction_id + '\'' +
                ", bankName='" + bankName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountName='" + accountName + '\'' +
                ", paymentRemarks='" + paymentRemarks + '\'' +
                '}';
    }
}
