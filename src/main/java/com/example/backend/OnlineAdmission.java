package com.example.backend;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class OnlineAdmission {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
   
	int reg_no;
	String full_name;
	String dob;
	String email;
	String mob;
	String gender;
	String fathername;
	String mothername;
	String class1;
	String section;
	String present_address;
	String permanent_address;
	String session;
	String username;
	String password;
	String image;
	String responseMessage;
	
	
	
	
	public OnlineAdmission(int reg_no, String full_name, String dob, String email, String mob, String gender,
			String fathername, String mothername, String class1, String section, String present_address,
			String permanent_address, String session, String username, String password, String image) {
		super();
		this.reg_no = reg_no;
		this.full_name = full_name;
		this.dob = dob;
		this.email = email;
		this.mob = mob;
		this.gender = gender;
		this.fathername = fathername;
		this.mothername = mothername;
		this.class1 = class1;
		this.section = section;
		this.present_address = present_address;
		this.permanent_address = permanent_address;
		this.session = session;
		this.username = username;
		this.password = password;
		this.image = image;
	}
	
	
	public int getReg_no() {
		return reg_no;
	}


	public void setReg_no(int reg_no) {
		this.reg_no = reg_no;
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
	public String getFathername() {
		return fathername;
	}
	public void setFathername(String fathername) {
		this.fathername = fathername;
	}
	public String getMothername() {
		return mothername;
	}
	public void setMothername(String mothername) {
		this.mothername = mothername;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	

	public String getResponseMessage() {
		return responseMessage;
	}


	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}


	@Override
	public String toString() {
		return "OnlineAdmission [reg_no=" + reg_no + ", full_name=" + full_name + ", dob=" + dob + ", email=" + email
				+ ", mob=" + mob + ", gender=" + gender + ", fathername=" + fathername + ", mothername=" + mothername
				+ ", class1=" + class1 + ", section=" + section + ", present_address=" + present_address
				+ ", permanent_address=" + permanent_address + ", session=" + session + ", username=" + username
				+ ", password=" + password + ", image=" + image + ", getReg_no()=" + getReg_no() + ", getFull_name()="
				+ getFull_name() + ", getDob()=" + getDob() + ", getEmail()=" + getEmail() + ", getMob()=" + getMob()
				+ ", getGender()=" + getGender() + ", getFathername()=" + getFathername() + ", getMothername()="
				+ getMothername() + ", getClass1()=" + getClass1() + ", getSection()=" + getSection()
				+ ", getPresent_address()=" + getPresent_address() + ", getPermanent_address()="
				+ getPermanent_address() + ", getSession()=" + getSession() + ", getUsername()=" + getUsername()
				+ ", getPassword()=" + getPassword() + ", getImage()=" + getImage() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
	
	
}
