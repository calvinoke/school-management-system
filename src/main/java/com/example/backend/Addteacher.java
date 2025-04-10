package com.example.backend;



public class Addteacher {
int id;
String name;
String email;
String password;
String qualification;
String mob;
String role;
String status;
String joining_date;


public Addteacher() {
	super();
}



public Addteacher(int id, String name, String email, String password, String qualification, String mob, String role,
		String status, String joining_date) {
	super();
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



public String getJoining_date() {
	return joining_date;
}



public void setJoining_date(String joining_date) {
	this.joining_date = joining_date;
}



@Override
public String toString() {
	return "Addteacher [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
			+ ", qualification=" + qualification + ", mob=" + mob + ", role=" + role + ", status=" + status
			+ ", joining_date=" + joining_date + ", getId()=" + getId() + ", getName()=" + getName() + ", getEmail()="
			+ getEmail() + ", getPassword()=" + getPassword() + ", getQualification()=" + getQualification()
			+ ", getMob()=" + getMob() + ", getRole()=" + getRole() + ", getStatus()=" + getStatus()
			+ ", getJoining_date()=" + getJoining_date() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
			+ ", toString()=" + super.toString() + "]";
}




	
	
	
}
