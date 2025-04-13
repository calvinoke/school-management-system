package com.example.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

@Entity
@Table(name = "teachers")
public class Addteacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    @NotBlank(message = "Qualification is required")
    private String qualification;

    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
    private String mob;

    @NotBlank(message = "Role is required")
    private String role;

    @NotBlank(message = "Status is required")
    private String status;

    @NotNull(message = "Joining date is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate joining_date;

    public Addteacher() {}

    public Addteacher(int id, String name, String email, String password, String qualification,
                      String mob, String role, String status, LocalDate joining_date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.qualification = qualification;
        this.mob = mob;
        this.role = role;
        this.status = status;
        this.joining_date = joining_date;
    }

    public Addteacher(String name, String email, String password, String qualification,
                      String mob, String role, String status, LocalDate joining_date) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.qualification = qualification;
        this.mob = mob;
        this.role = role;
        this.status = status;
        this.joining_date = joining_date;
    }

    // Getters and setters...

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getJoining_date() {
        return joining_date;
    }

    public void setJoining_date(LocalDate joining_date) {
        this.joining_date = joining_date;
    }

    @Override
    public String toString() {
        return "Addteacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", qualification='" + qualification + '\'' +
                ", mob='" + mob + '\'' +
                ", role='" + role + '\'' +
                ", status='" + status + '\'' +
                ", joining_date=" + joining_date +
                '}';
    }
}
