package com.example.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class SearchDAofupdatestudent {
	
	public Addstudent searchbyid(int student_id){
		Addstudent e=null;
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb","root","%d..,DD2022");
			PreparedStatement pst=con.prepareStatement("select * from addstudent WHERE student_id=?");
			pst.setInt(1, student_id);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				e=new Addstudent(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13));
			}
			
		} catch (Exception ex) {
			
		}
		
		return e;
	}
	
	
	
}
