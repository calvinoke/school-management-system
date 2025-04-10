package com.example.backend;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class FeeManagement {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int fee_management_id;
	String fee_name;
	int fee_amount;
	int student_id;
	String class1;
	String start_date;
	String end_date;
	int payment_record_id;
	String monthName;
	
	
	public FeeManagement() {
		super();
	}


	public FeeManagement(String fee_name, int fee_amount, int student_id, String class1, String start_date,
			String end_date, int payment_record_id, String monthName) {
		super();
		this.fee_name = fee_name;
		this.fee_amount = fee_amount;
		this.student_id = student_id;
		this.class1 = class1;
		this.start_date = start_date;
		this.end_date = end_date;
		this.payment_record_id = payment_record_id;
		this.monthName = monthName;
	}


	public int getFee_management_id() {
		return fee_management_id;
	}


	public void setFee_management_id(int fee_management_id) {
		this.fee_management_id = fee_management_id;
	}


	public String getFee_name() {
		return fee_name;
	}


	public void setFee_name(String fee_name) {
		this.fee_name = fee_name;
	}


	public int getFee_amount() {
		return fee_amount;
	}


	public void setFee_amount(int fee_amount) {
		this.fee_amount = fee_amount;
	}


	public int getStudent_id() {
		return student_id;
	}


	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}


	public String getClass1() {
		return class1;
	}


	public void setClass1(String class1) {
		this.class1 = class1;
	}


	public String getStart_date() {
		return start_date;
	}


	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}


	public String getEnd_date() {
		return end_date;
	}


	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}


	public int getPayment_record_id() {
		return payment_record_id;
	}


	public void setPayment_record_id(int payment_record_id) {
		this.payment_record_id = payment_record_id;
	}
	

	public String getMonthName() {
		return monthName;
	}


	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}


	@Override
	public String toString() {
		return "FeeManagement [fee_management_id=" + fee_management_id + ", fee_name=" + fee_name + ", fee_amount="
				+ fee_amount + ", student_id=" + student_id + ", class1=" + class1 + ", start_date=" + start_date
				+ ", end_date=" + end_date + ", payment_record_id=" + payment_record_id + ", monthName=" + monthName
				+ "]";
	}


}
