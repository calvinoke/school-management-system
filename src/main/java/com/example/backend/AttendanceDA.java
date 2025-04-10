package com.example.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDA {

	

	//	......................Insert Attendance data.............. 
	public AttendanceInfo saveAttendance(AttendanceInfo s) {

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "%d..,DD2022");
			PreparedStatement pst2 = con.prepareStatement("INSERT INTO attendanceinfo VALUES(?,?,?,?,?,?,?)");
			pst2.setInt(1, s.getAttendanceId());
			pst2.setInt(2, s.getStudentId());
			pst2.setString(3, s.getStudentName());
			pst2.setString(4, s.getClass1());
			pst2.setString(5, s.getSection());
			pst2.setString(6, s.getAttendanceDate());												
			pst2.setString(7, s.getAttendanceStatus());
		
	
			pst2.executeUpdate();

		
			pst2.close();
			

		} catch (Exception e) {
			// TODO: handle exception
		}

		return s;
	
	
	}
	
	

//	..........get All data from Attendanceinfo table......
	
	public List<AttendanceInfo> getAttendancedata(){
		List<AttendanceInfo> slist=new ArrayList<>();
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb","root","%d..,DD2022");
			PreparedStatement pst=con.prepareStatement("select * from attendanceinfo");
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				slist.add(new AttendanceInfo(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return slist;
	}
	
//	------------------------Searchbyid in flutter----------------------
	
	public List<AttendanceInfo> searchstudent(int student_id) {
		List<AttendanceInfo> slist = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb","root","%d..,DD2022");
			PreparedStatement pst = con.prepareStatement("select * from attendanceinfo where student_id="+ student_id );
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				slist.add(new AttendanceInfo(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
			};
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return slist;
	}
	
}
