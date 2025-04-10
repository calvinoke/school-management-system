package com.example.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AddstudentDA {
	public Addstudent addall(Addstudent s) {

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "%d..,DD2022");
			PreparedStatement pst = con.prepareStatement("INSERT INTO addstudent VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setInt(1, s.getStudent_id());
			pst.setString(2, s.getFull_name());
	
			pst.setString(3, s.getDob());
			pst.setString(4, s.getEmail());
			pst.setString(5, s.getMob());												
			pst.setString(6, s.getGender());
			pst.setString(7, s.getClass1());
			pst.setString(8, s.getSubject());
			pst.setString(9, s.getPresent_addres());
			pst.setString(10, s.getPermanent_address());
			pst.setString(11, s.getSession());
			pst.setString(12, s.getStatus());
			pst.setString(13, s.getSection());
			
			
			
			pst.executeUpdate();
			System.out.println("shamim vai");
			
			pst.close();
			

		} catch (Exception e) {
			// TODO: handle exception
		}

		return s;
	
	}
	
	
	
//	..........get all student by admin.......
	
	public List<Addstudent> viewstudent(){
		List<Addstudent> slist=new ArrayList<>();
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb","root","%d..,DD2022");
			PreparedStatement pst=con.prepareStatement("select * from addstudent");
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Addstudent addStudent =new Addstudent(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13));
				addStudent.setStudent_id(rs.getInt(1));
				
				
				slist.add(addStudent);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return slist;
	}
	
	public void deletefinally(int s) {

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "%d..,DD2022");
			
			SearchDAofupdatestudent searchStudent = new SearchDAofupdatestudent();
		
			Addstudent studentToDelete =searchStudent.searchbyid(s);
			
			PreparedStatement ps = con.prepareStatement("DELETE from addstudent WHERE student_id=?");

			ps.setInt(1,s);
			
			ps.executeUpdate();
			
			
			
			
			PreparedStatement ps1 = con.prepareStatement("DELETE from alluser WHERE email=?");
			
			ps1.setString(1, studentToDelete.getEmail() );
		
			ps1.executeUpdate();


			
			

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	

//	..........get student class wise .......
	
	public List<Addstudent> getStudentByClass(List<String> classNames){
		List<Addstudent> slist=new ArrayList<>();
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb","root","%d..,DD2022");
			
			// Prepare the SQL statement with a WHERE clause using the IN clause to filter by multiple class names
			StringBuilder sql = new StringBuilder("SELECT * FROM addstudent WHERE class IN (");
			for (int i = 0; i < classNames.size(); i++) {
			    sql.append("?");
			    if (i < classNames.size() - 1) {
			        sql.append(",");
			    }
			}
			sql.append(")");

			
			// Prepare the PreparedStatement
			PreparedStatement pst = con.prepareStatement(sql.toString());

			// Set the class names as parameters in the prepared statement
			for (int i = 0; i < classNames.size(); i++) {
			    pst.setString(i + 1, classNames.get(i));
			}
			
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Addstudent addStudent =new Addstudent(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13));
				addStudent.setStudent_id(rs.getInt(1));
				
				
				slist.add(addStudent);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return slist;
	}
	
	
	public Addstudent getStudentByEmail(String email) {
		Addstudent addStudent = new Addstudent();
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb","root","%d..,DD2022");
			PreparedStatement pst=con.prepareStatement("select * from addstudent where email=?");
			pst.setString(1, email);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				addStudent =new Addstudent(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13));
				addStudent.setStudent_id(rs.getInt(1));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("Error" + e);
		}
		
		return addStudent;
	}
	
	
	
	
}
