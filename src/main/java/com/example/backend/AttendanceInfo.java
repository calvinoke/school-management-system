package com.example.backend;

//import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class AttendanceInfo {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int attendanceId;
	private int studentId;
	private String studentName;
	private String class1;
	private String section;
	private String attendanceDate;
	private String attendanceStatus;
	
	
	public AttendanceInfo(int attendanceId, int studentId, String studentName, String class1, String section,
			String attendanceDate, String attendanceStatus) {
		super();
		this.attendanceId = attendanceId;
		this.studentId = studentId;
		this.studentName = studentName;
		this.class1 = class1;
		this.section = section;
		this.attendanceDate = attendanceDate;
		this.attendanceStatus = attendanceStatus;
	}
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
		return "AttendanceInfo [attendanceId=" + attendanceId + ", studentId=" + studentId + ", studentName="
				+ studentName + ", class1=" + class1 + ", section=" + section + ", attendanceDate=" + attendanceDate
				+ ", attendanceStatus=" + attendanceStatus + ", getAttendanceId()=" + getAttendanceId()
				+ ", getStudentId()=" + getStudentId() + ", getStudentName()=" + getStudentName() + ", getClass1()="
				+ getClass1() + ", getSection()=" + getSection() + ", getAttendanceDate()=" + getAttendanceDate()
				+ ", getAttendanceStatus()=" + getAttendanceStatus() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
 