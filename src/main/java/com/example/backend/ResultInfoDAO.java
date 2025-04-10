package com.example.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ResultInfoDAO {

	
	

	public ResultInfo saveResult (ResultInfo s) {

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "%d..,DD2022");
			PreparedStatement pst = con.prepareStatement("INSERT INTO resultinfo VALUES(?,?,?,?,?,?,?,?,?)");
			pst.setInt(1, s.getResult_id());
			pst.setInt(2, s.getStudent_id());
			pst.setString(3, s.getClass1());
			pst.setString(4, s.getSection());
			pst.setString(5, s.getSubjectwise_result());												
			pst.setString(6, s.getPass_fail());
			pst.setString(7, s.getTotal_marks());
			pst.setDouble(8, s.getGrade());
			pst.setString(9, s.getExam_title());


		
			pst.executeUpdate();
		
			
			pst.close();
			

		} catch (Exception e) {
			// TODO: handle exception
		}

		return s;
	}
	
	
	// save multiple result info ....
	public List<ResultInfo> saveResultInfoList(List<ResultInfo> slist) {
		try {
			for (int i = 0; i < slist.size(); i++) {
				if (slist.get(i).getResult_id() > 0) {
					updateResult(slist.get(i));
				} else {
					saveResult(slist.get(i));
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return slist;
	}
	
	
	
	// update result info
	public ResultInfo updateResult (ResultInfo s) {

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "%d..,DD2022");
			PreparedStatement pst = con.prepareStatement("UPDATE resultinfo SET subjectwise_result=?, pass_fail=?, total_marks=?, grade=?"
					+ " WHERE result_id=?");
			
			pst.setString(1, s.getSubjectwise_result());
			pst.setString(2, s.getPass_fail());
			pst.setString(3, s.getTotal_marks());
			pst.setDouble(4, s.getGrade());
			pst.setInt(5, s.getResult_id());
					
			pst.executeUpdate();	
			pst.close();

		} catch (Exception e) {
			// TODO: handle exception
		}

		return s;
	}
	
	
	public List<StudentResultInfoDTO> getResultInfoList (ResultInfo s) {
		List<StudentResultInfoDTO> resultList=new ArrayList<>();
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb","root","%d..,DD2022");
			PreparedStatement pst=con.prepareStatement("select addstudent.student_id, addstudent.full_name, addstudent.class, addstudent.section,"
					+ " resultinfo.result_id, resultinfo.subjectwise_result, resultinfo.pass_fail, resultinfo.total_marks,"
					+ " resultinfo.grade, resultinfo.exam_title "
					+ " from addstudent "
					+ " left join resultinfo on addstudent.student_id = resultinfo.student_id and addstudent.class = resultinfo.class"
					+ " and addstudent.section = resultinfo.section and resultinfo.exam_title=?"
					+ " where addstudent.class=? and addstudent.section=?");
			
			pst.setString(1, s.getExam_title());
			pst.setString(2, s.getClass1());
			pst.setString(3, s.getSection());
			
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				StudentResultInfoDTO dto = new StudentResultInfoDTO(rs.getInt(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7), 
						rs.getString(8), rs.getDouble(9), rs.getString(10));
				resultList.add(dto);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		}
		
		return resultList;
	}
	
	public List<StudentResultInfoDTO> getResultInfoListByStuentId (ResultInfo s) {
		List<StudentResultInfoDTO> resultList=new ArrayList<>();
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb","root","%d..,DD2022");
			PreparedStatement pst=con.prepareStatement("select addstudent.student_id, addstudent.full_name, addstudent.class, addstudent.section,"
					+ " resultinfo.result_id, resultinfo.subjectwise_result, resultinfo.pass_fail, resultinfo.total_marks,"
					+ " resultinfo.grade, resultinfo.exam_title "
					+ " from addstudent "
					+ " left join resultinfo on addstudent.student_id = resultinfo.student_id and addstudent.class = resultinfo.class"
					+ " and addstudent.section = resultinfo.section and resultinfo.exam_title=?"
					+ " where addstudent.student_id=?");
			
			pst.setString(1, s.getExam_title());
			pst.setInt(2, s.getStudent_id());
			
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				StudentResultInfoDTO dto = new StudentResultInfoDTO(rs.getInt(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7), 
						rs.getString(8), rs.getDouble(9), rs.getString(10));
				resultList.add(dto);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		}
		
		return resultList;
	}
	
	
	
}
