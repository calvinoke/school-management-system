package com.example.backend;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins="http://localhost:4200")
@CrossOrigin(origins = "*")   //----for Flutter
@RestController
public class AdminController {

//.............	insert data into alluser table.........
	
	@PostMapping("/save" )
	public Alluser dosave(@RequestBody Alluser s) {
		AlluseraddDA da = new AlluseraddDA();
		Alluser st=  da.save(s);

		return st;
	}
	

	

	//------------------------ admin/teacher/student login // Flutter --------------------------- 

	@PostMapping(value="/loginadmin")
	public Alluser signInAll(@RequestBody Alluser s) {
		AllusergetDA da = new AllusergetDA();
		Alluser st = da.usersignin(s.email,s.password);
		return st;
	}

	

	
//	...............log in with email/password from Alluser table..........

	@GetMapping("/{email}/{password}")
	public Alluser m3(@PathVariable String email,@PathVariable String password) {
		AllusergetDA da= new AllusergetDA();
		Alluser data = da.login(email,password);
		return data;
	}
	
	
	

	
	
		
		//.............	insert teacher data into teachertable.........
		
		@PostMapping("/allteacher" )
		public Addteacher dosave(@RequestBody Addteacher s) {
			AddteacherDA da = new AddteacherDA();
			Addteacher st=  da.save2(s);
			
			return st;
		}
		
		
//		.........get All Teacher data by admin from teachertable......
		List<Addteacher> teacher=new ArrayList<>();
		
		@GetMapping("/getteacher")
		public List<Addteacher> getdata() {
			AddteacherDA da = new AddteacherDA();
			teacher = da.viewteacher();

			return teacher;
		}
		
		

		
		
		
		
		
		//.............	Add Student by admin into database.........
		
		@PostMapping("/allstudent" )
		public Addstudent addstudent(@RequestBody Addstudent s) {
			AddstudentDA da = new AddstudentDA();
			Addstudent st=  da.addall(s);
			
			return st;
		}
		
		
		
		
//		.........get All student data by admin from sql......
		List<Addstudent> student=new ArrayList<>();
		
		@GetMapping("/getall")
		public List<Addstudent> m3() {
			AddstudentDA da = new AddstudentDA();
			student = da.viewstudent();

			return student;
		}
		
		
		
		
		

		
		//search student for Update
	
		
		@GetMapping("/search/{student_id}")
		public Addstudent searchbyid(@PathVariable int student_id) {
			SearchDAofupdatestudent da = new SearchDAofupdatestudent();
			Addstudent	data = da.searchbyid(student_id);

			return data;
		}
		
	//.................update addstudent Table............
		
		@PutMapping("/update")
		public Addstudent Update(@RequestBody Addstudent s) {

			UpdateDAofaddstudent da = new UpdateDAofaddstudent();
			Addstudent data = da.update(s);

			return data;
		}
		
		
		//...............delete row from add student table..........
		
		
		@DeleteMapping("/delete/{id}")
		public void dodelete(@PathVariable int id) {

			AddstudentDA da = new AddstudentDA();
				da.deletefinally(id);

		
		}
	
		//.............	insert data of online_ Admission Form.........
		
		@PostMapping("/form" )
		public OnlineAdmission dosave(@RequestBody OnlineAdmission s) {
			OnlineAdmissionDA da = new OnlineAdmissionDA();
			OnlineAdmission st=  da.savestudent(s);

			return st;
		}
		
//		.........get All new apllicants who filup admission form.....
		List<OnlineAdmission> applicant=new ArrayList<>();
		
		@GetMapping("/newapplicant")
		public List<OnlineAdmission> getapplicant() {
			OnlineAdmissionDA da = new OnlineAdmissionDA();
			applicant = da.getapplicant();

			return applicant;
		}
		
		
		
		//.......search student for approve...........
	
		
		@GetMapping("/searchapproval/{email}")
		public OnlineAdmission searchforapproval(@PathVariable String email) {
			OnlineAdmissionDA da = new OnlineAdmissionDA();
			OnlineAdmission	data = da.searchbyregid(email);

			return data;
		}
		
	//...............delete row from add admissionform table..........
		
		
		@DeleteMapping("/reject/{email}")
		public void dodelete(@PathVariable String email) {

			OnlineAdmissionDA da = new OnlineAdmissionDA();
				da.rejectfinally(email);

		}
		
		
	//.............	for insert data of approval student page.........
		
		@PostMapping("/senddata" )
		public OnlineAdmission m6(@RequestBody OnlineAdmission s) {
			OnlineAdmissionDA da = new OnlineAdmissionDA();
			OnlineAdmission st=  da.savedata(s);

			return st;
		}
		
		
	//.............	insert class routine data into classroutine.........
		
		@PostMapping("/classroutine" )
		public Classroutine saveroutine(@RequestBody Classroutine s) {
			OnlineAdmissionDA da = new OnlineAdmissionDA();
			Classroutine st=  da.saveClassRoutine(s);
			
			return st;
		}
		
		
		
//		.........get Class Routine data from classroutine table......
		List<Classroutine> routine=new ArrayList<>();
		
		@GetMapping("/getroutine")
		public List<Classroutine> getroutine() {
			OnlineAdmissionDA da = new OnlineAdmissionDA();
			routine = da.getClassRoutine();

			return routine;
		}
		
			
		
		// Search by class in Flutter
		@GetMapping(value="/searchstudentroutine/{className}")
		public List<Classroutine> searchRoutine(@PathVariable("className") String className) {
		    OnlineAdmissionDA d = new OnlineAdmissionDA();
		    return d.searchRoutine(className);
		}

		
		
		
		//.............	insert data into Exam Schedule table.........
		
		@PostMapping("/examschedule" )
		public Examschedule dosave(@RequestBody Examschedule s) {
			OnlineAdmissionDA da = new OnlineAdmissionDA();
			Examschedule st=  da.saveExamRoutine(s);
			return st;
		}
		
		
//		.........get Exam Schedule data by admin from Exam Schedule table......
	
		
		
			@GetMapping("/getexamschedule")
		public List<Examschedule> getExamdScheduleData() {
			OnlineAdmissionDA da = new OnlineAdmissionDA();
			List<Examschedule> examScheduleList=new ArrayList<>();
			examScheduleList = da.getExamSchedule();

			return examScheduleList;
		}
			
		//.............	insert data into Exam Schedule table.........
		
		@PostMapping("/takeattendance" )
		public AttendanceInfo saveAttendance(@RequestBody AttendanceInfo s) {
			AttendanceDA da = new AttendanceDA();
			AttendanceInfo st=  da.saveAttendance(s);
			return st;
		}
		
//		.........get Attendance data by admin from Attendance table......
	
		
		
		@GetMapping("/getattendance")
		public List<AttendanceInfo> getAttendanceData() {
				AttendanceDA da = new AttendanceDA();
			List<AttendanceInfo> attendanceList=new ArrayList<>();
			attendanceList = da.getAttendancedata();

			return attendanceList;
		}
		
		   //serchbyid in flutter----------------------------
			List<AttendanceInfo> stlist1=new ArrayList<>();
			@GetMapping(value="/searchstudentid/{studentId}")
			
			public List<AttendanceInfo> serach(@PathVariable("studentId") int student_id){
				AttendanceDA d = new AttendanceDA();
				stlist1=d.searchstudent(student_id);
				return stlist1;
			}
		
		
		//.............	insert multiple data into Result Info table......... 
		@PostMapping("/saveresultinfo" )
		public List<ResultInfo> saveResultInfo(@RequestBody List<ResultInfo> results) {
			ResultInfoDAO da = new ResultInfoDAO();
			List<ResultInfo> st=  da.saveResultInfoList(results);
			return st;
		}
		
		
		//.............	get Result Info table data.........
		@PostMapping("/getresultinfolist")
		public List<StudentResultInfoDTO> getResultInfoList(@RequestBody ResultInfo s) {
			ResultInfoDAO da = new ResultInfoDAO();
			List<StudentResultInfoDTO> resultInfoList = new ArrayList<>();
			resultInfoList = da.getResultInfoList(s);

			return resultInfoList;
		}
		
		//.............	get Result Info table data by Student Id.........
		@PostMapping("/getresultinfolistbystudentid")
		public List<StudentResultInfoDTO> getResultInfoListByStudentId(@RequestBody ResultInfo s) {
			ResultInfoDAO da = new ResultInfoDAO();
			List<StudentResultInfoDTO> resultInfoList = new ArrayList<>();
			resultInfoList = da.getResultInfoListByStuentId(s);

			return resultInfoList;
		}
		
		
		//.............	insert data into Fee Management table.........
		@PostMapping("/savefeemanagementdetail" )
		public void saveFeeManagementDetail(@RequestBody FeeManagementRequestDTO s) {
			FeeManagementDAO da = new FeeManagementDAO();
			da.saveFeeManagementDetail(s);
		}
		
		//.............	get Student Fee Payment data.........
		@PostMapping("/getfeepaymentdetail")
		public List<FeePaymentDTO> getFeePaymentList(@RequestBody FeeManagementRequestDTO s) {
			FeeManagementDAO da = new FeeManagementDAO();
			List<FeePaymentDTO> response = new ArrayList<>();
			response = da.getFeePaymentList(s);

			return response;
		}
		
		// Update the Payment Status....
		@PostMapping("/updatePaymentStatus" )
		public void updatePaymentStatus(@RequestBody List<FeePaymentDTO> s) {
			FeeManagementDAO da = new FeeManagementDAO();
			da.updatePaymentStatus(s);
		}
		
		//Student submit payment info....
		@PostMapping("/submitPayment" )
		public void submitPayment(@RequestBody FeePaymentDTO s) {
			FeeManagementDAO da = new FeeManagementDAO();
			da.submitPayment(s);
		}
		
		// get student by email
		@PostMapping("/getStudentByEmail" )
		public Addstudent getStudentByEmail(@RequestBody Addstudent s) {
			AddstudentDA da = new AddstudentDA();
			Addstudent stu = da.getStudentByEmail(s.getEmail());
			return stu;
		}
		
}
