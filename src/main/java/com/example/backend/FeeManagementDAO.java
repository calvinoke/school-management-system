package com.example.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FeeManagementDAO {
	
	public void saveFeeManagementDetail(FeeManagementRequestDTO requestDTO) {
		
		List<FeeManagement> feeManagementList = this.prepareFeeDetailToSaveInDB(requestDTO);
		for (FeeManagement feeManagement: feeManagementList) {
			this.saveFeeManagementInDB(feeManagement);
		}
	}
	
	
	
	public List<FeeManagement> prepareFeeDetailToSaveInDB(FeeManagementRequestDTO requestDTO) {
		AddstudentDA addStudentDA = new AddstudentDA();
		List<Addstudent> allStudent = addStudentDA.getStudentByClass(requestDTO.getClassNames());
		List<FeeManagement> feeManagementList = new ArrayList<>();
		for (Addstudent student : allStudent) {
			FeeManagement feeManagement = new FeeManagement(requestDTO.getFee_name(), requestDTO.getFee_amount(), student.getStudent_id(), student.getClass1(),
					requestDTO.getStart_date(), requestDTO.getEnd_date(), 0, requestDTO.getMonthName());
			feeManagementList.add(feeManagement);
		}
		return feeManagementList;
		
	}

	
	
	public void saveFeeManagementInDB(FeeManagement s) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "%d..,DD2022");
			PreparedStatement pst2 = con.prepareStatement("INSERT INTO fee_management VALUES(?,?,?,?,?,?,?,?,?)");
			pst2.setInt(1, s.getFee_management_id());
			pst2.setString(2, s.getFee_name());
			pst2.setInt(3, s.getFee_amount());
			pst2.setInt(4, s.getStudent_id());
			pst2.setString(5, s.getClass1());
			pst2.setString(6, s.getStart_date());
			pst2.setString(7, s.getEnd_date());												
			pst2.setInt(8, s.getPayment_record_id());
			pst2.setString(9, s.getMonthName());
		
	
			pst2.executeUpdate();

		
			pst2.close();
			

		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("GOT ERROR " + e);
		}
		
	}
	
	public List<FeePaymentDTO> getFeePaymentList(FeeManagementRequestDTO s) {
		List<FeePaymentDTO> feePaymentList = new ArrayList<>();
		
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb","root","%d..,DD2022");
			
			
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT \n");
			sql.append(" fee_management.fee_management_id, \n");
			sql.append(" fee_management.fee_name, \n");
			sql.append(" fee_management.fee_amount, \n"); 
			sql.append(" fee_management.month_name, \n"); 
			sql.append(" fee_management.start_date, \n");
			sql.append(" fee_management.end_date, \n");
			sql.append(" addstudent.student_id, \n"); 
			sql.append(" addstudent.full_name, \n");
			sql.append(" addstudent.class, \n");
			sql.append(" addstudent.section, \n");
			sql.append(" payment_records.payment_record_id, \n"); 
			sql.append(" payment_records.payment_amount, \n"); 
			sql.append(" payment_records.payment_date, \n");
			sql.append(" payment_records.payment_method, \n");
			sql.append(" payment_records.payment_status, \n");
			sql.append(" payment_records.transaction_id, \n");
			sql.append(" payment_records.bank_name, \n");
			sql.append(" payment_records.account_number, \n");
			sql.append(" payment_records.account_name, \n");
			sql.append(" payment_records.payment_remarks \n");
			sql.append(" FROM fee_management \n");
			sql.append(" LEFT JOIN addstudent  \n");
			sql.append(" ON fee_management.student_id = addstudent.student_id \n");
			sql.append(" LEFT JOIN payment_records \n");
			sql.append(" ON fee_management.fee_management_id = payment_records.fee_management_id \n");
			sql.append(" WHERE 1=1 \n");
			
			if (s.getFee_name() != null) { sql.append(" AND fee_management.fee_name=? \n"); }
			if (s.getMonthName() != null) { sql.append(" AND fee_management.month_name=? \n"); }
			if (s.getStart_date() != null) { sql.append(" AND fee_management.start_date>=? \n"); }
			if (s.getEnd_date() != null) { sql.append(" AND fee_management.end_date<=? \n"); }
			if (s.getStudentId() != 0) { sql.append(" AND addstudent.student_id=? \n"); }
			if (s.getClassName() != null) { sql.append(" AND addstudent.class=? \n"); }
			if (s.getPaymentMethod() != null) { sql.append(" AND payment_records.payment_method=? \n"); }
			if (s.getPaymentDate() != null) { sql.append(" AND payment_records.payment_date=? \n"); }
			if (s.getPaymentStatus() != null) { sql.append(" AND payment_records.payment_status=? \n"); }
			
			// Prepare the PreparedStatement
			int i = 1;
			PreparedStatement pst = con.prepareStatement(sql.toString());
			if (s.getFee_name() != null) { pst.setString(i, s.getFee_name()); i++; }
			if (s.getMonthName() != null) { pst.setString(i, s.getMonthName()); i++; }
			if (s.getStart_date() != null) { pst.setString(i, s.getStart_date()); i++; }
			if (s.getEnd_date() != null) { pst.setString(i, s.getEnd_date()); i++; }
			if (s.getStudentId() != 0) { pst.setInt(i, s.getStudentId()); i++; }
			if (s.getClassName() != null) { pst.setString(i, s.getClassName()); i++; }
			if (s.getPaymentMethod() != null) { pst.setString(i, s.getPaymentMethod()); i++; }
			if (s.getPaymentDate() != null) { pst.setString(i, s.getPaymentDate()); i++; }
			if (s.getPaymentStatus() != null) { pst.setString(i, s.getPaymentStatus()); i++; }
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				FeePaymentDTO feePay = new FeePaymentDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11),
						rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), 
						rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20));
				
				feePaymentList.add(feePay);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("Error: " + e);
		}
		
		
		return feePaymentList;
		
	}
	
	
	// Update the Payment Status....
	public void updatePaymentStatus(List<FeePaymentDTO> feePayList) {
		for (FeePaymentDTO feePay : feePayList) {
			this.updatePaymentStatusInDB(feePay.getPayment_record_id(), feePay.getPayment_status(), feePay.getPaymentRemarks());
		}
	}
	
	public void updatePaymentStatusInDB(int payment_record_id, String payment_status, String paymentRemarks) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "%d..,DD2022");
			PreparedStatement pst = con.prepareStatement("UPDATE payment_records set payment_status=?, payment_remarks=? WHERE payment_record_id=?");
			pst.setString(1, payment_status);
			pst.setString(2, paymentRemarks);
			pst.setInt(3, payment_record_id);
			
			
			pst.executeUpdate();
			pst.close();		

		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("ERROR: " + e);
		}
	}
	
	
	
	// Payment Submitted by Student.....
	public void submitPayment(FeePaymentDTO feePayment) {
		if (feePayment.getPayment_record_id() > 0) {
			this.deletePaymentRecord(feePayment.getPayment_record_id());
		}

		// 1. insert into payment record table	
		PaymentRecords paymentRecords = new PaymentRecords(feePayment.getStudent_id(), feePayment.getPayment_amount(), feePayment.getPayment_date(), 
				feePayment.getPayment_method(), feePayment.getPayment_status(), feePayment.getTransaction_id(), feePayment.getFee_management_id(), 
				feePayment.getBankName(), feePayment.getAccountNumber(), feePayment.getAccountName(), feePayment.getPaymentRemarks());
		this.savePaymentRecordInDB(paymentRecords);
		
		// 2. get the saved payment record
		paymentRecords = this.getPaymentRecordsByFeeRecordIdAndStudentId(feePayment.getFee_management_id(), feePayment.getStudent_id());
		
		// 3. update fee management record
		this.updateFeeManagementRecordWithPaymentId(paymentRecords.getPayment_record_id(), paymentRecords.getFee_management_id());
		
	}
	
	public void deletePaymentRecord(int paymentRecordId) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "%d..,DD2022");
			PreparedStatement ps = con.prepareStatement("DELETE from payment_records WHERE payment_record_id=?");
			ps.setInt(1, paymentRecordId);
			ps.executeUpdate();
			ps.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("Error" + e);
		}
	}
	
	
	public void savePaymentRecordInDB(PaymentRecords s) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "%d..,DD2022");
			PreparedStatement pst2 = con.prepareStatement("INSERT INTO payment_records VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
			pst2.setInt(1, s.getPayment_record_id());
			pst2.setInt(2, s.getStudent_id());
			pst2.setInt(3, s.getPayment_amount());
			pst2.setString(4, s.getPayment_date());
			pst2.setString(5, s.getPayment_method());
			pst2.setString(6, s.getPayment_status());
			pst2.setString(7, s.getTransaction_id());												
			pst2.setInt(8, s.getFee_management_id());
			pst2.setString(9, s.getBankName());
			pst2.setString(10, s.getAccountNumber());
			pst2.setString(11, s.getAccountName());
			pst2.setString(12, s.getPayment_remarks());
		
			pst2.executeUpdate();
			pst2.close();
			

		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("GOT ERROR " + e);
		}
		
	}
	
	public PaymentRecords getPaymentRecordsByFeeRecordIdAndStudentId(int feeRecordId, int studentId) {
		PaymentRecords paymentRecords = null;
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb","root","%d..,DD2022");
			
			PreparedStatement pst=con.prepareStatement("select * from payment_records where fee_management_id=? and student_id=?");
			pst.setInt(1, feeRecordId);
			pst.setInt(2, studentId);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				paymentRecords = new PaymentRecords(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), 
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), 
						rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("Error: " + e);
		}
		return paymentRecords;
	}
	
	public void updateFeeManagementRecordWithPaymentId(int paymentRecordId, int feeManagementRecordId) {
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb","root","%d..,DD2022");
			
			PreparedStatement pst = con.prepareStatement("UPDATE fee_management set payment_record_id=? WHERE fee_management_id=?");
			pst.setInt(1, paymentRecordId);
			pst.setInt(2, feeManagementRecordId);
			
			pst.executeUpdate();
			pst.close();		

			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("Error: " + e);
		}
	}

	

}
