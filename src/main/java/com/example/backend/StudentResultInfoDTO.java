package com.example.backend;

public class StudentResultInfoDTO {
	int student_id;
	String full_name;
	String class1;
	String section;
	int result_id;
	String subjectwise_result;
	String pass_fail;
	String total_marks;
	Double grade;
	String exam_title;
	
	public StudentResultInfoDTO(int student_id, String full_name, String class1, String section, int result_id,
			String subjectwise_result, String pass_fail, String total_marks, Double grade, String exam_title) {
		this.student_id = student_id;
		this.full_name = full_name;
		this.class1 = class1;
		this.section = section;
		this.result_id = result_id;
		this.subjectwise_result = subjectwise_result;
		this.pass_fail = pass_fail;
		this.total_marks = total_marks;
		this.grade = grade;
		this.exam_title = exam_title;
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
		return "ResultInfoResponseDTO [student_id=" + student_id + ", full_name=" + full_name + ", class1=" + class1
				+ ", section=" + section + ", result_id=" + result_id + ", subjectwise_result=" + subjectwise_result
				+ ", pass_fail=" + pass_fail + ", total_marks=" + total_marks + ", grade=" + grade + ", exam_title="
				+ exam_title + ", getStudent_id()=" + getStudent_id() + ", getFull_name()=" + getFull_name()
				+ ", getClass1()=" + getClass1() + ", getSection()=" + getSection() + ", getResult_id()="
				+ getResult_id() + ", getSubjectwise_result()=" + getSubjectwise_result() + ", getPass_fail()="
				+ getPass_fail() + ", getTotal_marks()=" + getTotal_marks() + ", getGrade()=" + getGrade()
				+ ", getExam_title()=" + getExam_title() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}
