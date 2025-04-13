package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "online_admissions")
public class OnlineAdmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reg_no;

    private String full_name;
	private String status; // Assuming the status field exists
    private String dob;
    private String email;
    private String mob;
    private String gender;
    private String fathername;
    private String mothername;

    private String class1;
    private String section;
    private String present_address;
    private String permanent_address;
    private String session;
    private String username;
    private String password;
    private String image;

    @Transient
    private String responseMessage;

    public OnlineAdmission() {
    }

    // Constructor for creation (without reg_no - auto generated)
    public OnlineAdmission(String full_name, String dob, String email, String mob, String gender,
                           String fathername, String mothername, String class1, String section,
                           String present_address, String permanent_address, String session,
                           String username, String password, String image) {
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

    // Constructor for update (with reg_no)
    public OnlineAdmission(int reg_no, String full_name, String dob, String email, String mob, String gender,
                           String fathername, String mothername, String class1, String section,
                           String present_address, String permanent_address, String session,
                           String username, String password, String image) {
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

    // Getters and Setters
	 
    // Getter and Setter for Status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;  // Add this setter to resolve the undefined error
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
        return "OnlineAdmission{" +
                "reg_no=" + reg_no +
                ", full_name='" + full_name + '\'' +
                ", dob='" + dob + '\'' +
                ", email='" + email + '\'' +
                ", mob='" + mob + '\'' +
                ", gender='" + gender + '\'' +
                ", fathername='" + fathername + '\'' +
                ", mothername='" + mothername + '\'' +
                ", class1='" + class1 + '\'' +
                ", section='" + section + '\'' +
                ", present_address='" + present_address + '\'' +
                ", permanent_address='" + permanent_address + '\'' +
                ", session='" + session + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", image='" + image + '\'' +
                ", responseMessage='" + responseMessage + '\'' +
                '}';
    }
}
