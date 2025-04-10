package com.example.backend;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Addstudent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  int student_id;
	  String full_name;
	  String dob;
	  String email;
	  String mob;
	  String gender;
	  String class1;
	  String subject;
	  String present_addres;
	  String permanent_address;
	  String session;
	  String status;
	  String section;
	
	  
	  
	 
	  
	  public Addstudent() {
		super();
	}

	public Addstudent(String full_name, String dob, String email, String mob, String gender,
			String class1, String subject, String present_addres, String permanent_address, String session,
			String status, String section) {
		super();
	
		this.full_name = full_name;
		this.dob = dob;
		this.email = email;
		this.mob = mob;
		this.gender = gender;
		this.class1 = class1;
		this.subject = subject;
		this.present_addres = present_addres;
		this.permanent_address = permanent_address;
		this.session = session;
		this.status = status;
		this.section = section;
	}

	  public Addstudent(int student_id,  String full_name, String dob, String email, String mob, String gender,
				String class1, String subject, String present_addres, String permanent_address, String session,
				String status, String section) {
			super();
			this.student_id=student_id;
			this.full_name = full_name;
			this.dob = dob;
			this.email = email;
			this.mob = mob;
			this.gender = gender;
			this.class1 = class1;
			this.subject = subject;
			this.present_addres = present_addres;
			this.permanent_address = permanent_address;
			this.session = session;
			this.status = status;
			this.section = section;
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


	public String getPresent_addres() {
		return present_addres;
	}


	public void setPresent_addres(String present_addres) {
		this.present_addres = present_addres;
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

	@Override
	public String toString() {
		return "Addstudent [student_id=" + student_id + ", full_name=" + full_name + ", dob=" + dob + ", email=" + email
				+ ", mob=" + mob + ", gender=" + gender + ", class1=" + class1 + ", subject=" + subject
				+ ", present_addres=" + present_addres + ", permanent_address=" + permanent_address + ", session="
				+ session + ", status=" + status + ", section=" + section + ", getStudent_id()=" + getStudent_id()
				+ ", getFull_name()=" + getFull_name() + ", getDob()=" + getDob() + ", getEmail()=" + getEmail()
				+ ", getMob()=" + getMob() + ", getGender()=" + getGender() + ", getClass1()=" + getClass1()
				+ ", getSubject()=" + getSubject() + ", getPresent_addres()=" + getPresent_addres()
				+ ", getPermanent_address()=" + getPermanent_address() + ", getSession()=" + getSession()
				+ ", getStatus()=" + getStatus() + ", getSection()=" + getSection() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
	  


	
	  
	
}
