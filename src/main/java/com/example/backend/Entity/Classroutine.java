package com.example.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Classroutine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String day;
    private String class1;
    private String section;
    private String subject;
    private String start_time;
    private String end_time;
    private String teacher;
    private String room_no;

    // Default constructor
    public Classroutine() {
    }

    // Constructor with fields
    public Classroutine(String day, String class1, String section, String subject, String start_time, String end_time,
            String teacher, String room_no) {
        this.day = day;
        this.class1 = class1;
        this.section = section;
        this.subject = subject;
        this.start_time = start_time;
        this.end_time = end_time;
        this.teacher = teacher;
        this.room_no = room_no;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getRoom_no() {
        return room_no;
    }

    public void setRoom_no(String room_no) {
        this.room_no = room_no;
    }

    @Override
    public String toString() {
        return "Classroutine [id=" + id + ", day=" + day + ", class1=" + class1 + ", section=" + section + ", subject=" + subject
                + ", start_time=" + start_time + ", end_time=" + end_time + ", teacher=" + teacher + ", room_no=" + room_no + "]";
    }
}
