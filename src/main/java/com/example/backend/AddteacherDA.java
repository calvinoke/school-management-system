package com.example.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AddteacherDA {

	public Addteacher save2(Addteacher s) {

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "%d..,DD2022");
			PreparedStatement pst = con.prepareStatement("INSERT INTO teachertable VALUES(?,?,?,?,?,?,?,?,?)");
			pst.setInt(1, s.getId());
			pst.setString(2, s.getName());
			pst.setString(3, s.getEmail());
			pst.setString(4, s.getPassword());
			pst.setString(5, s.getQualification());
			pst.setString(6, s.getMob());
			pst.setString(7, s.getRole());
			pst.setString(8, s.getStatus());
			pst.setString(9, s.getJoining_date());
			pst.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}

		return s;
	}
	
//	..........get all teacher by admin.......
	
	public List<Addteacher> viewteacher(){
		List<Addteacher> slist=new ArrayList<>();
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb","root","%d..,DD2022");
			PreparedStatement pst=con.prepareStatement("select * from teachertable");
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				slist.add(new Addteacher(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return slist;
	}
	
	
	
	
}
