package com.example.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AttendanceInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attendanceId;

    private int studentId;
    private String studentName;
    private String class1;
    private String section;
    private String attendanceDate;
    private String attendanceStatus;

    // Default constructor
    public AttendanceInfo() {
    }

    // Constructor with all fields
    public AttendanceInfo(int studentId, String studentName, String class1, String section, String attendanceDate, String attendanceStatus) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.class1 = class1;
        this.section = section;
        this.attendanceDate = attendanceDate;
        this.attendanceStatus = attendanceStatus;
    }

    // Getters and Setters
    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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

    public String getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(String attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public String getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    @Override
    public String toString() {
        return "AttendanceInfo{" +
                "attendanceId=" + attendanceId +
                ", studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", class1='" + class1 + '\'' +
                ", section='" + section + '\'' +
                ", attendanceDate='" + attendanceDate + '\'' +
                ", attendanceStatus='" + attendanceStatus + '\'' +
                '}';
    }
}
