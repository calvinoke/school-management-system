package com.example.backend;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class UpdateDAofaddstudent {

	public Addstudent update(Addstudent s) {

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "%d..,DD2022");
			PreparedStatement ps = con.prepareStatement("UPDATE addstudent set full_name=?, dob=?, email=?,mob=?, gender=?, "
					+ "class=?,subject=?, present_address=?, permanent_address=?,session=?,status=?,section=? WHERE student_id=?");
			
			ps.setString(1, s.getFull_name());

			ps.setString(2, s.getDob());
			ps.setString(3, s.getEmail());
			ps.setString(4, s.getMob());
			ps.setString(5, s.getGender());
			ps.setString(6, s.getClass1());
			ps.setString(7, s.getSubject());
			ps.setString(8, s.getPresent_addres());
			ps.setString(9, s.getPermanent_address());
			ps.setString(10, s.getSession());
			ps.setString(11, s.getStatus());
			ps.setString(12, s.getSection());
			ps.setInt(13, s.getStudent_id());

			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}

		return s;
	}
}
