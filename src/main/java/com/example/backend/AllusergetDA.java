package com.example.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AllusergetDA{

//	------------------------------ log in -------------------------------------
	
	public Alluser login(String email, String password) {
		Alluser e =null;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "%d..,DD2022");
			PreparedStatement pst1 = con.prepareStatement("select * from alluser where email=? AND password=?");
			pst1.setString(1, email);
			pst1.setString(2, password);
			ResultSet rs = pst1.executeQuery();
			while (rs.next()) {
				e=new Alluser(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			}

		} catch (Exception ex) {
			// TODO: handle exception
		}

		return e;
	}
	
	
//	-------------------- Admin login/teacher/student login // Flutter part---------------------- 
	public Alluser usersignin(String email, String password) {
		Alluser s = new Alluser();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "%d..,DD2022");
			PreparedStatement pstmt = con.prepareStatement("select * from alluser where email='" + email+"' AND password ='"+password+"'");

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				s =new Alluser(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
			}
			
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return s;
	}


	}

