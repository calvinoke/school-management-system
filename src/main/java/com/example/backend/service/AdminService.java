package com.example.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.repository.AddteacherRepository;
import com.example.backend.repository.AlluserRepository;
import com.example.backend.repository.AttendanceInfoRepository;
import com.example.backend.repository.FeeManagementRepository;
import com.example.backend.repository.OnlineAdmissionRepository;
import com.example.backend.repository.StudentRepository;
import com.example.backend.repository.ResultInfoRepository;
import com.example.backend.repository.ClassroutineRepository;
import com.example.backend.repository.ExamscheduleRepository;

import jakarta.persistence.EntityNotFoundException;

import com.example.backend.dto.FeePaymentDTO;
import com.example.backend.dto.StudentResultInfoDTO;
import com.example.backend.entity.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminService {

    @Autowired
    private AlluserRepository alluser;    // Data access object for Alluser
    
    @Autowired
    private AddteacherRepository teacher;    // Data access object for Teacher operations
    @Autowired
    private StudentRepository student;    // Data access object for Student operations
    @Autowired
    private OnlineAdmissionRepository onlineAdmission;  // Data access object for Online Admissions
    @Autowired
    private AttendanceInfoRepository attendance;  // Data access object for Attendance
    @Autowired
    private ResultInfoRepository resultInfo; // Data access object for Result Information
    @Autowired
    private FeeManagementRepository feeManagement;  // Data access object for Fee Management

  

    // Business logic for saving Alluser
    public Alluser saveAlluser(Alluser s) {
        return alluser.save(s);
    }

    // Business logic for signing in
    public Alluser signIn(String email, String password) {
        return alluser.findByEmailAndPassword(email, password)
                      .orElse(null); // Or throw exception for invalid login
    }

    // Get all teachers
    public List<Addteacher> getAllTeachers() {
        return teacher.findAll();  // ✅ Correct built-in method
    }

    // Add new student
    public Addstudent addStudent(Addstudent s) {
        return student.save(s);  // ✅ save() is provided by JpaRepository
    }

    // Get all students
    public List<Addstudent> getAllStudents() {
        return student.findAll();  // ✅ This is a valid JpaRepository method
    }

    // Search student by ID
    public Addstudent searchStudentById(int student_id) {
        return student.findById(student_id).orElse(null);  // ✅ Works as intended
    }

    // Business logic for updating student data
    public Addstudent updateStudent(Addstudent updatedStudent) {
        return student.save(updatedStudent);  // Save method will handle both insert and update
    }

    // Business logic for deleting student data
    public void deleteStudent(int studentId) {
        Optional<Addstudent> existingStudent = student.findById(studentId);
        if (existingStudent.isPresent()) {
            student.deleteById(studentId);
        } else {
            throw new EntityNotFoundException("Student with ID " + studentId + " not found.");
        }
    }

    // --------------------------------------------
    // Business Logic for Online Admission
    // --------------------------------------------
    public OnlineAdmission addOnlineAdmission(OnlineAdmission admission) {
        return onlineAdmission.save(admission);  // Save new online admission
    }

    public List<OnlineAdmission> getAllOnlineAdmissions() {
        return onlineAdmission.findAll();  // Get all online admissions
    }

    public OnlineAdmission getOnlineAdmissionById(int admissionId) {
        return onlineAdmission.findById(admissionId)
                .orElseThrow(() -> new EntityNotFoundException("Online admission with ID " + admissionId + " not found"));
    }

    public void deleteOnlineAdmission(int admissionId) {
        Optional<OnlineAdmission> admission = onlineAdmission.findById(admissionId);
        if (admission.isPresent()) {
            onlineAdmission.deleteById(admissionId);
        } else {
            throw new EntityNotFoundException("Online admission with ID " + admissionId + " not found.");
        }
    }

    // --------------------------------------------
    // Business Logic for Attendance
    // --------------------------------------------
    public AttendanceInfo addAttendanceInfo(AttendanceInfo attendanceInfo) {
        return attendance.save(attendanceInfo);  // Save attendance record
    }

    public List<AttendanceInfo> getAllAttendanceInfo() {
        return attendance.findAll();  // Get all attendance records
    }

    public AttendanceInfo getAttendanceInfoById(int attendanceId) {
        return attendance.findById(attendanceId)
                .orElseThrow(() -> new EntityNotFoundException("Attendance info with ID " + attendanceId + " not found"));
    }

    public void deleteAttendanceInfo(int attendanceId) {
        Optional<AttendanceInfo> attendanceInfo = attendance.findById(attendanceId);
        if (attendanceInfo.isPresent()) {
            attendance.deleteById(attendanceId);
        } else {
            throw new EntityNotFoundException("Attendance info with ID " + attendanceId + " not found.");
        }
    }

    // --------------------------------------------
    // Business Logic for Result Information
    // --------------------------------------------
    public ResultInfo addResultInfo(ResultInfo resultInfoRecord) {
        return resultInfo.save(resultInfoRecord);  // Save result info record
    }

    public List<ResultInfo> getAllResultInfo() {
        return resultInfo.findAll();  // Get all result records
    }

    public ResultInfo getResultInfoById(int resultId) {
        return resultInfo.findById(resultId)
                .orElseThrow(() -> new EntityNotFoundException("Result info with ID " + resultId + " not found"));
    }

    public void deleteResultInfo(int resultId) {
        Optional<ResultInfo> result = resultInfo.findById(resultId);
        if (result.isPresent()) {
            resultInfo.deleteById(resultId);
        } else {
            throw new EntityNotFoundException("Result info with ID " + resultId + " not found.");
        }
    }

    public List<ResultInfo> saveResultInfo(List<ResultInfo> results) {
        return resultInfo.saveAll(results);  // Save a list of result info records
    }
    

    public List<StudentResultInfoDTO> getResultInfoList(ResultInfo s) {
    List<ResultInfo> resultInfoList = resultInfo.findBySomeCriteria(s);  // Replace `findBySomeCriteria` with your actual query method
    // You may need to transform `ResultInfo` into `StudentResultInfoDTO` here
    return resultInfoList.stream()
            .map(resultInfo -> new StudentResultInfoDTO(resultInfo))  // Transform ResultInfo into StudentResultInfoDTO
            .collect(Collectors.toList());
}


public List<StudentResultInfoDTO> getResultInfoByStudentId(ResultInfo s) {
    List<ResultInfo> resultInfoList = resultInfo.findByStudentId(s.getStudent_id());  // You may need to create this method in your repository
    return resultInfoList.stream()
            .map(resultInfo -> new StudentResultInfoDTO(resultInfo))  // Transform ResultInfo into StudentResultInfoDTO
            .collect(Collectors.toList());
}


    // --------------------------------------------
    // Business Logic for Fee Management
    // --------------------------------------------
    public FeeManagement addFeeManagement(FeeManagement fee) {
        return feeManagement.save(fee);  // Save fee management record
    }

    public List<FeeManagement> getAllFeeManagement() {
        return feeManagement.findAll();  // Get all fee management records
    }

    public FeeManagement getFeeManagementById(int feeId) {
        return feeManagement.findById(feeId)
                .orElseThrow(() -> new EntityNotFoundException("Fee management with ID " + feeId + " not found"));
    }

    public void deleteFeeManagement(int feeId) {
        Optional<FeeManagement> fee = feeManagement.findById(feeId);
        if (fee.isPresent()) {
            feeManagement.deleteById(feeId);
        } else {
            throw new EntityNotFoundException("Fee management with ID " + feeId + " not found.");
        }
    }


    // Add new teacher
public Addteacher addTeacher(Addteacher t) {
    return teacher.save(t);
}

// Save online admission (possibly a duplicate of addOnlineAdmission)
public OnlineAdmission saveOnlineAdmission(OnlineAdmission admission) {
    return onlineAdmission.save(admission);
}

// Get all applicants (assume they are stored as OnlineAdmissions with a certain status)
public List<OnlineAdmission> getApplicants() {
    return onlineAdmission.findByStatus("Pending");
}

// Search applicant for approval by name or ID
public List<OnlineAdmission> searchForApproval(String query) {
    return onlineAdmission.findByNameContainingOrIdContaining(query, query);
}

// Reject an applicant
public void rejectApplicant(String applicantId) {
    Optional<OnlineAdmission> applicant = onlineAdmission.findById(Integer.parseInt(applicantId));
    if (applicant.isPresent()) {
        OnlineAdmission rejected = applicant.get();
        rejected.setStatus("Rejected");
        onlineAdmission.save(rejected);
    } else {
        throw new EntityNotFoundException("Applicant not found");
    }
}

@Autowired
private ClassroutineRepository classroutineRepository;  // Inject repository as a bean

public Classroutine saveClassRoutine(Classroutine classRoutine) {
    return classroutineRepository.save(classRoutine);  // Call save on the injected instance
}

public List<Classroutine> getAllClassRoutines() {
    return classroutineRepository.findAll();  // Call findAll on the injected instance
}

public Classroutine getClassRoutine(int routineId) {
    return classroutineRepository.findById((long) routineId)
        .orElseThrow(() -> new EntityNotFoundException("Class routine with ID " + routineId + " not found."));
}



public List<Classroutine> searchByClassName(String className) {
    return classroutineRepository.findByClassName(className);  // Call custom query method
}

@Autowired
private ExamscheduleRepository examSchedulRepository;  // Inject repository as a bean
// Get exam schedule
public List<Examschedule> getExamSchedule() {
    return examSchedulRepository.findAll();
}



// Method to save exam schedule
public Examschedule saveExamSchedule(Examschedule examSchedule) {
    return examSchedulRepository.save(examSchedule);  // Save exam schedule using the repository
}


// Get attendance data
public List<AttendanceInfo> getAttendanceData() {
    return attendance.findAll();
}

// Search attendance by student ID
public List<AttendanceInfo> searchAttendanceByStudentId(int studentId) {
    return attendance.findByStudentId(studentId);
}



// Submit new payment
public FeeManagement submitPayment(FeePaymentDTO paymentDTO) {
    FeeManagement newPayment = new FeeManagement();
    newPayment.setFee_amount(paymentDTO.getFee_amount());
    newPayment.setStudent_id(paymentDTO.getStudent_id());
    newPayment.setStatus("Paid");
    return feeManagement.save(newPayment);
}

public Addstudent getStudentByEmail(String email) {
    return student.findByEmail(email)
        .orElseThrow(() -> new RuntimeException("Student not found with email: " + email));
}




    // More business logic for other operations...
}
