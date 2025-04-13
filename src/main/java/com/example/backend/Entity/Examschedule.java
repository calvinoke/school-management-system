package com.example.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Examschedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int examID;

    private String examTitle;
    private String class1;
    private String subject;
    private String examType;
    private String examHall;
    private String examStart;
    private String examEnd;
    private String examInvigilator;
    private String examDate;

    public Examschedule() {}

    public Examschedule(int examID, String examTitle, String class1, String subject, String examType,
                        String examHall, String examStart, String examEnd,
                        String examInvigilator, String examDate) {
        this.examID = examID;
        this.examTitle = examTitle;
        this.class1 = class1;
        this.subject = subject;
        this.examType = examType;
        this.examHall = examHall;
        this.examStart = examStart;
        this.examEnd = examEnd;
        this.examInvigilator = examInvigilator;
        this.examDate = examDate;
    }

    public int getExamID() {
        return examID;
    }

    public void setExamID(int examID) {
        this.examID = examID;
    }

    public String getExamTitle() {
        return examTitle;
    }

    public void setExamTitle(String examTitle) {
        this.examTitle = examTitle;
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

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public String getExamHall() {
        return examHall;
    }

    public void setExamHall(String examHall) {
        this.examHall = examHall;
    }

    public String getExamStart() {
        return examStart;
    }

    public void setExamStart(String examStart) {
        this.examStart = examStart;
    }

    public String getExamEnd() {
        return examEnd;
    }

    public void setExamEnd(String examEnd) {
        this.examEnd = examEnd;
    }

    public String getExamInvigilator() {
        return examInvigilator;
    }

    public void setExamInvigilator(String examInvigilator) {
        this.examInvigilator = examInvigilator;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    @Override
    public String toString() {
        return "Examschedule{" +
                "examID=" + examID +
                ", examTitle='" + examTitle + '\'' +
                ", class1='" + class1 + '\'' +
                ", subject='" + subject + '\'' +
                ", examType='" + examType + '\'' +
                ", examHall='" + examHall + '\'' +
                ", examStart='" + examStart + '\'' +
                ", examEnd='" + examEnd + '\'' +
                ", examInvigilator='" + examInvigilator + '\'' +
                ", examDate='" + examDate + '\'' +
                '}';
    }
}
