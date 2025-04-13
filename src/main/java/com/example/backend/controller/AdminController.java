package com.example.backend.controller;

import com.example.backend.entity.Alluser;
import com.example.backend.entity.Addstudent;
import com.example.backend.entity.Addteacher;
import com.example.backend.service.AdminService;
import com.example.backend.entity.OnlineAdmission;
import com.example.backend.entity.Classroutine;
import com.example.backend.entity.ResultInfo;
import com.example.backend.entity.Examschedule;
import com.example.backend.entity.AttendanceInfo;
import com.example.backend.dto.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")  // Allow all origins for Flutter
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Secured admin dashboard endpoint
    @GetMapping("/dashboard")
    @PreAuthorize("hasAuthority('admin')")
    public ResponseEntity<String> getAdminDashboard() {
        return ResponseEntity.ok("Welcome to the admin dashboard");
    }

    // Save data into Alluser table
    @PostMapping("/save")
    public Alluser saveAlluser(@RequestBody Alluser s) {
        return adminService.saveAlluser(s);
    }

    // Admin/Teacher/Student login
    @PostMapping("/loginadmin")
    public Alluser signInAll(@RequestBody Alluser s) {
        return adminService.signIn(s.getEmail(), s.getPassword());
    }

    // Get All Teacher data
    @GetMapping("/getteacher")
    public List<Addteacher> getTeachers() {
        return adminService.getAllTeachers();
    }

    // Add Teacher data
    @PostMapping("/allteacher")
    public Addteacher addTeacher(@RequestBody Addteacher s) {
        return adminService.addTeacher(s);
    }

    // Add Student by admin into database
    @PostMapping("/allstudent")
    public Addstudent addStudent(@RequestBody Addstudent s) {
        return adminService.addStudent(s);
    }

    // Get All Student data
    @GetMapping("/getall")
    public List<Addstudent> getStudents() {
        return adminService.getAllStudents();
    }

    // Search student by ID for update
    @GetMapping("/search/{student_id}")
    public Addstudent searchById(@PathVariable int student_id) {
        return adminService.searchStudentById(student_id);
    }

    // Update student data
    @PutMapping("/update")
    public Addstudent updateStudent(@RequestBody Addstudent s) {
        return adminService.updateStudent(s);
    }

    // Delete student data
    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable int id) {
        adminService.deleteStudent(id);
    }

    // Save Online Admission form data
    @PostMapping("/form")
    public OnlineAdmission saveOnlineAdmission(@RequestBody OnlineAdmission s) {
        return adminService.saveOnlineAdmission(s);
    }

    // Get all new applicants who filled out admission form
    @GetMapping("/newapplicant")
    public List<OnlineAdmission> getApplicants() {
        return adminService.getApplicants();
    }

    // Search student for approval
    @GetMapping("/searchapproval/{email}")
    public List<OnlineAdmission> searchForApproval(@PathVariable String email) {
     return adminService.searchForApproval(email); // ✅ Pass 'email' not 'query'
   }


    // Reject applicant by email
    @DeleteMapping("/reject/{email}")
    public void rejectApplicant(@PathVariable String email) {
        adminService.rejectApplicant(email);
    }

    // Save class routine data
    @PostMapping("/classroutine")
    public Classroutine saveClassRoutine(@RequestBody Classroutine s) {
        return adminService.saveClassRoutine(s);
    }

    // Get class routine data
    @GetMapping("/getroutine")
    public Classroutine getClassRoutine(@RequestParam int routineId) {
        return adminService.getClassRoutine(routineId);
    }
    

    // Search routine by class
    @GetMapping("/searchstudentroutine/{className}")
    public List<Classroutine> searchRoutineByClass(@PathVariable("className") String className) {
        return adminService.searchByClassName(className);
    }
    

    // Save exam schedule
    @PostMapping("/examschedule")
    public Examschedule saveExamSchedule(@RequestBody Examschedule s) {
        return adminService.saveExamSchedule(s);
    }

    // Get exam schedule data
    @GetMapping("/getexamschedule")
    public List<Examschedule> getExamSchedule() {
        return adminService.getExamSchedule();
    }

    // Save attendance data
    @PostMapping("/takeattendance")
    public AttendanceInfo saveAttendance(@RequestBody AttendanceInfo s) {
        return adminService.addAttendanceInfo(s);  // Call addAttendanceInfo method instead
    }
    

    // Get attendance data
    @GetMapping("/getattendance")
    public List<AttendanceInfo> getAttendanceData() {
        return adminService.getAttendanceData();
    }

    // Search attendance by student ID
    @GetMapping("/searchstudentid/{studentId}")
    public List<AttendanceInfo> searchAttendanceByStudentId(@PathVariable("studentId") int studentId) {
        return adminService.searchAttendanceByStudentId(studentId);
    }

    // Save result info
    @PostMapping("/saveresultinfo")
    public List<ResultInfo> saveResultInfo(@RequestBody List<ResultInfo> results) {
        return adminService.saveResultInfo(results);
    }

    // Get result info list
    @PostMapping("/getresultinfolist")
    public List<StudentResultInfoDTO> getResultInfoList(@RequestBody ResultInfo s) {
        return adminService.getResultInfoList(s);
    }

    // Get result info by student ID
    @PostMapping("/getresultinfolistbystudentid")
    public List<StudentResultInfoDTO> getResultInfoByStudentId(@RequestBody ResultInfo s) {
        return adminService.getResultInfoByStudentId(s);
    }

    

    // Submit payment info
    @PostMapping("/submitPayment")
    public void submitPayment(@RequestBody FeePaymentDTO s) {
        adminService.submitPayment(s);
    }

    // Get student by email
    @PostMapping("/getStudentByEmail")
    public Addstudent getStudentByEmail(@RequestBody Addstudent s) {
        return adminService.getStudentByEmail(s.getEmail());
    }
}
