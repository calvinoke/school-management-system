// Package declaration
package com.example.backend.entity;

// Importing required JPA and validation annotations
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;

// Defines this class as a JPA entity and maps it to the "addstudent" table in the database
@Table(name = "addstudent")
@Entity
public class Addstudent {

    // Primary key field, auto-generated by the database using the IDENTITY strategy
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int student_id;

    // Student full name: required, must be between 2 and 100 characters
    @NotNull
    @Size(min = 2, max = 100)
    @Column(name = "full_name")
    private String full_name;

    // Date of birth: required field
    @NotNull
    @Column(name = "dob")
    private String dob;

    // Email address: required and must follow valid email format
    @NotNull
    @Email
    @Column(name = "email")
    private String email;

    // Mobile number: required, must be between 10 and 15 characters
    @NotNull
    @Size(min = 10, max = 15)
    @Column(name = "mob")
    private String mob;

    // Gender: required
    @NotNull
    @Column(name = "gender")
    private String gender;

    // Class: required (named 'class1' to avoid using Java reserved word 'class')
    @NotNull
    @Column(name = "class1")
    private String class1;

    // Subject: required
    @NotNull
    @Column(name = "subject")
    private String subject;

    // Present address: required
    @NotNull
    @Column(name = "present_address")
    private String present_address;

    // Permanent address: required
    @NotNull
    @Column(name = "permanent_address")
    private String permanent_address;

    // Academic session: required
    @NotNull
    @Column(name = "session")
    private String session;

    // Status (e.g., active/inactive): required
    @NotNull
    @Column(name = "status")
    private String status;

    // Section (e.g., A, B, etc.): required
    @NotNull
    @Column(name = "section")
    private String section;

    // Default constructor required by JPA
    public Addstudent() {
        super();
    }

    // Constructor without ID for creating new records (ID is auto-generated)
    public Addstudent(String full_name, String dob, String email, String mob, String gender,
                      String class1, String subject, String present_address, String permanent_address,
                      String session, String status, String section) {
        super();
        this.full_name = full_name;
        this.dob = dob;
        this.email = email;
        this.mob = mob;
        this.gender = gender;
        this.class1 = class1;
        this.subject = subject;
        this.present_address = present_address;
        this.permanent_address = permanent_address;
        this.session = session;
        this.status = status;
        this.section = section;
    }

    // Constructor with ID for updating or retrieving existing records
    public Addstudent(int student_id, String full_name, String dob, String email, String mob, String gender,
                      String class1, String subject, String present_address, String permanent_address, String session,
                      String status, String section) {
        super();
        this.student_id = student_id;
        this.full_name = full_name;
        this.dob = dob;
        this.email = email;
        this.mob = mob;
        this.gender = gender;
        this.class1 = class1;
        this.subject = subject;
        this.present_address = present_address;
        this.permanent_address = permanent_address;
        this.session = session;
        this.status = status;
        this.section = section;
    }

    // Getters and setters for all fields (used for accessing and modifying field values)
    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPresent_address() {
        return present_address;
    }

    public void setPresent_address(String present_address) {
        this.present_address = present_address;
    }

    public String getPermanent_address() {
        return permanent_address;
    }

    public void setPermanent_address(String permanent_address) {
        this.permanent_address = permanent_address;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    // toString method for debugging/logging - prints out object details
    @Override
    public String toString() {
        return "Addstudent [student_id=" + student_id + ", full_name=" + full_name + ", dob=" + dob + ", email=" + email
                + ", mob=" + mob + ", gender=" + gender + ", class1=" + class1 + ", subject=" + subject
                + ", present_address=" + present_address + ", permanent_address=" + permanent_address + ", session="
                + session + ", status=" + status + ", section=" + section + "]";
    }
}
