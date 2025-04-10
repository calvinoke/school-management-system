package com.example.backend;

public class Classroutine {

	String day;
	String class1;
	String section;
	String subject;
	String start_time;
	
	String end_time;

	String teacher;
	
	String room_no;

	public Classroutine() {
		super();
	}

	public Classroutine(String day, String class1, String section, String subject, String start_time, String end_time,
			String teacher, String room_no) {
		super();
		this.day = day;
		this.class1 = class1;
		this.section = section;
		this.subject = subject;
		this.start_time = start_time;
		this.end_time = end_time;
		this.teacher = teacher;
		this.room_no = room_no;
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
		return "Classroutine [day=" + day + ", class1=" + class1 + ", section=" + section + ", subject=" + subject
				+ ", start_time=" + start_time + ", end_time=" + end_time + ", teacher=" + teacher + ", room_no="
				+ room_no + ", getDay()=" + getDay() + ", getClass1()=" + getClass1() + ", getSection()=" + getSection()
				+ ", getSubject()=" + getSubject() + ", getStart_time()=" + getStart_time() + ", getEnd_time()="
				+ getEnd_time() + ", getTeacher()=" + getTeacher() + ", getRoom_no()=" + getRoom_no() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
