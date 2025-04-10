package com.example.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OnlineAdmissionDA {

	public OnlineAdmission savestudent(OnlineAdmission s) {
		if (this.hasDuplicateEmail(s.getEmail())) {
			s.setResponseMessage("Duplicate Email Address! System has other student with this email address. Please change the email address.");
			return s;
		}
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "%d..,DD2022");
			PreparedStatement pst = con.prepareStatement("INSERT INTO admissionform VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setInt(1, s.getReg_no());
			pst.setString(2, s.getFull_name());
			pst.setString(3, s.getDob());
			pst.setString(4, s.getEmail());
			pst.setString(5, s.getMob());												
			pst.setString(6, s.getGender());
			pst.setString(7, s.getFathername());
			pst.setString(8, s.getMothername());
			pst.setString(9, s.getClass1());
			pst.setString(10, s.getSection());
			pst.setString(11, s.getPresent_address());
			pst.setString(12, s.getPermanent_address());
			pst.setString(13, s.getSession());
			pst.setString(14, s.getUsername());
			pst.setString(15, s.getPassword());
			pst.setString(16, s.getImage());
			

			
			
			pst.executeUpdate();
		
			
			pst.close();
			

		} catch (Exception e) {
			// TODO: handle exception
			s.setResponseMessage("Duplicate Email Address! System has other student with this email address. Please change the email address.");
		}

		return s;
	
	
}
	
	public Boolean hasDuplicateEmail(String email) {
		Boolean result = false;
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb","root","%d..,DD2022");
			PreparedStatement pst1=con.prepareStatement("select count(*) from admissionform where email=?");
			PreparedStatement pst2=con.prepareStatement("select count(*) from addstudent where email=?");
			pst1.setString(1, email);
			pst2.setString(1, email);
			ResultSet rs1=pst1.executeQuery();
			ResultSet rs2=pst2.executeQuery();
			
			while(rs1.next()) {
				result = (result | rs1.getInt(1) > 0);
			}
			while(rs2.next()) {
				result = (result | rs2.getInt(1) > 0);
			}
			
			pst1.close();
			pst2.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	
//	..........Show all new Applicant......
	
	public List<OnlineAdmission> getapplicant(){
		List<OnlineAdmission> slist=new ArrayList<>();
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb","root","%d..,DD2022");
			PreparedStatement pst=con.prepareStatement("select * from admissionform");
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				slist.add(new OnlineAdmission(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16)));
			}
			pst.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return slist;
	}
	
	
//	...........Search for Approval...........
	
	public OnlineAdmission searchbyregid(String email){
		OnlineAdmission e=null;
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb","root","%d..,DD2022");
			PreparedStatement pst=con.prepareStatement("select * from admissionform WHERE email=?");
			pst.setString(1, email);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				e=new OnlineAdmission(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16));
			}
			
		} catch (Exception ex) {
			// TODO: handle exception
		}
		
		return e;
	}
	
	public void rejectfinally(String s) {

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "%d..,DD2022");
			PreparedStatement ps = con.prepareStatement("DELETE from admissionform WHERE email=?");

			ps.setString(1,s);
			
			ps.executeUpdate();
			
			ps.close();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
//	.........for send approvalstudent data to another table..................
//	
	public OnlineAdmission savedata(OnlineAdmission s) {
		OnlineAdmission e = null;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "%d..,DD2022");
			PreparedStatement ps1 = con.prepareStatement("insert into alluser(username,name,email,password,image,role) VALUES(?,?,?,?,?,?)");

			ps1.setString(1, s.getUsername());
			ps1.setString(2,s.getFull_name());
			ps1.setString(3, s.getEmail());
			ps1.setString(4, s.getPassword());
			ps1.setString(5, s.getImage());
			ps1.setString(6,"student");
			
			ps1.executeUpdate();		
			
			
			ps1.close();
			
			//start:insert data into addstudent table from by clicking approval button
			
			AddstudentDA addStudentDa = new AddstudentDA();
			
			Addstudent addStudent= new Addstudent(s.getFull_name(),s.getDob(),s.getEmail(),s.getMob(),s.getGender(),
					s.getClass1(),s.getSection(),s.getPresent_address(),s.getPermanent_address(),s.getSession(),"regular",s.getSection());
			

			
			addStudentDa.addall(addStudent);
			
			//end
			
			// after approval data will be deleted..
			rejectfinally(s.getEmail());
				
		
			


		

		} catch (Exception ex) {
			// TODO: handle exception
		}

		return e;
	}
	
	
//	......................Insert ClassRoutine data.............. 
	public Classroutine saveClassRoutine(Classroutine s) {

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "%d..,DD2022");
			PreparedStatement pst2 = con.prepareStatement("INSERT INTO classroutine VALUES(?,?,?,?,?,?,?,?)");
			pst2.setString(1, s.getDay());
			pst2.setString(2, s.getClass1());
			pst2.setString(3, s.getSection());
			pst2.setString(4, s.getSubject());
			pst2.setString(5, s.getStart_time());												
			pst2.setString(6, s.getEnd_time());
			pst2.setString(7, s.getTeacher());
			pst2.setString(8, s.getRoom_no());
		

			
			
			pst2.executeUpdate();

			
			pst2.close();
			

		} catch (Exception e) {
			// TODO: handle exception
		}

		return s;
	
	
}
//	..........Show Classroutine......
	
	public List<Classroutine> getClassRoutine(){
		List<Classroutine> slist=new ArrayList<>();
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb","root","%d..,DD2022");
			PreparedStatement pst=con.prepareStatement("select * from classroutine");
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				slist.add(new Classroutine(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return slist;
	}
	
//	..........Show Classroutine in flutter......
	
	
//	public List<Classroutine> searchRoutine(String className) {
//		List<Classroutine> slist = new ArrayList<>();
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/idb_project","root","Mysql/@/704");
//			PreparedStatement pst = con.prepareStatement("select * from classroutine where class="+ className );
//			ResultSet rs = pst.executeQuery();
//			while(rs.next()) {
//				slist.add(new Classroutine(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
//			};
//			con.close();
//		} catch (SQLException | ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		return slist;
//	}
//	
	
	public List<Classroutine> searchRoutine(String className) {
	    List<Classroutine> slist = new ArrayList<>();
	    
	    String query = "SELECT * FROM classroutine WHERE class = ?";
	    
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "%d..,DD2022");
	             PreparedStatement pst = con.prepareStatement(query)) {
	            
	            pst.setString(1, className);
	            
	            try (ResultSet rs = pst.executeQuery()) {
	                while (rs.next()) {
	                    slist.add(new Classroutine(
	                        rs.getString(1),
	                        rs.getString(2),
	                        rs.getString(3),
	                        rs.getString(4),
	                        rs.getString(5),
	                        rs.getString(6),
	                        rs.getString(7),
	                        rs.getString(8)
	                    ));
	                }
	            }
	        }
	    } catch (SQLException | ClassNotFoundException e) {
	        // Consider using a logging framework or returning a custom error response
	        e.printStackTrace();
	    }
	    
	    return slist;
	}

	
	
//	......................Insert Exam Schedule data.............. 
	public Examschedule saveExamRoutine(Examschedule s) {

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "%d..,DD2022");
			PreparedStatement pst2 = con.prepareStatement("INSERT INTO exam_schedule VALUES(?,?,?,?,?,?,?,?,?,?)");
			pst2.setInt(1, s.getExamID());
			pst2.setString(2, s.getExamTitle());
			pst2.setString(3, s.getClass1());
			pst2.setString(4, s.getSubject());
			pst2.setString(5, s.getExamType());												
			pst2.setString(6, s.getExamHall());
			pst2.setString(7, s.getExamStart());
			pst2.setString(8, s.getExamEnd());
			pst2.setString(9, s.getExamInvigilator());
			pst2.setString(10, s.getExamDate());
	
			pst2.executeUpdate();

		
			pst2.close();
			

		} catch (Exception e) {
			// TODO: handle exception
		}

		return s;
	
	
}
	
//	..........get All data from Exam Schedule table......
	
	public List<Examschedule> getExamSchedule(){
		List<Examschedule> slist=new ArrayList<>();
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb","root","%d..,DD2022");
			PreparedStatement pst=con.prepareStatement("select * from exam_schedule");
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				slist.add(new Examschedule(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return slist;
	}
	
	
}
