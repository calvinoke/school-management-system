package com.example.backend.dto;

import com.example.backend.entity.ResultInfo;

public class StudentResultInfoDTO {

    private int student_id;
    private String full_name;
    private String studentClass;
    private String section;
    private int result_id;
    private String subjectwise_result;
    private String pass_fail;
    private String total_marks;
    private Double grade;
    private String exam_title;

    public StudentResultInfoDTO() {
    }

    public StudentResultInfoDTO(int student_id, String full_name, String studentClass, String section, int result_id,
                                 String subjectwise_result, String pass_fail, String total_marks,
                                 Double grade, String exam_title) {
        this.student_id = student_id;
        this.full_name = full_name;
        this.studentClass = studentClass;
        this.section = section;
        this.result_id = result_id;
        this.subjectwise_result = subjectwise_result;
        this.pass_fail = pass_fail;
        this.total_marks = total_marks;
        this.grade = grade;
        this.exam_title = exam_title;
    }

	 
    // Constructor accepting ResultInfo
    public StudentResultInfoDTO(ResultInfo resultInfo) {
        this.student_id = resultInfo.getStudent_id(); // Mapping student_id
        // Assuming you have full_name in ResultInfo, update if necessary
        this.studentClass = resultInfo.getClass1(); // Mapping class1 to studentClass
        this.section = resultInfo.getSection(); // Mapping section
        this.result_id = resultInfo.getResult_id(); // Mapping result_id
        this.subjectwise_result = resultInfo.getSubjectwise_result(); // Mapping subjectwise_result
        this.pass_fail = resultInfo.getPass_fail(); // Mapping pass_fail
        this.total_marks = resultInfo.getTotal_marks(); // Mapping total_marks
        this.grade = resultInfo.getGrade(); // Mapping grade
        this.exam_title = resultInfo.getExam_title(); // Mapping exam_title
    }

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

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getResult_id() {
        return result_id;
    }

    public void setResult_id(int result_id) {
        this.result_id = result_id;
    }

    public String getSubjectwise_result() {
        return subjectwise_result;
    }

    public void setSubjectwise_result(String subjectwise_result) {
        this.subjectwise_result = subjectwise_result;
    }

    public String getPass_fail() {
        return pass_fail;
    }

    public void setPass_fail(String pass_fail) {
        this.pass_fail = pass_fail;
    }

    public String getTotal_marks() {
        return total_marks;
    }

    public void setTotal_marks(String total_marks) {
        this.total_marks = total_marks;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public String getExam_title() {
        return exam_title;
    }

    public void setExam_title(String exam_title) {
        this.exam_title = exam_title;
    }

    @Override
    public String toString() {
        return "StudentResultInfoDTO{" +
                "student_id=" + student_id +
                ", full_name='" + full_name + '\'' +
                ", studentClass='" + studentClass + '\'' +
                ", section='" + section + '\'' +
                ", result_id=" + result_id +
                ", subjectwise_result='" + subjectwise_result + '\'' +
                ", pass_fail='" + pass_fail + '\'' +
                ", total_marks='" + total_marks + '\'' +
                ", grade=" + grade +
                ", exam_title='" + exam_title + '\'' +
                '}';
    }
}
