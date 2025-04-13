package com.example.backend.controller;

import com.example.backend.entity.AttendanceInfo;
import com.example.backend.service.AttendanceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceInfoController {

    @Autowired
    private AttendanceInfoService attendanceInfoService;

    // Save attendance info
    @PostMapping("/save")
    public AttendanceInfo saveAttendance(@RequestBody AttendanceInfo attendanceInfo) {
        return attendanceInfoService.saveAttendance(attendanceInfo);
    }

    // Get all attendance records
    @GetMapping("/all")
    public List<AttendanceInfo> getAllAttendance() {
        return attendanceInfoService.getAllAttendance();
    }

    // Get attendance records by student ID
    @GetMapping("/student/{studentId}")
    public List<AttendanceInfo> getAttendanceByStudentId(@PathVariable int studentId) {
        return attendanceInfoService.getAttendanceByStudentId(studentId);
    }

    // Update attendance info
    @PutMapping("/update")
    public AttendanceInfo updateAttendance(@RequestBody AttendanceInfo attendanceInfo) {
        return attendanceInfoService.updateAttendance(attendanceInfo);
    }

    // Delete attendance info by ID
    @DeleteMapping("/delete/{attendanceId}")
    public void deleteAttendance(@PathVariable int attendanceId) {
        attendanceInfoService.deleteAttendance(attendanceId);
    }

    // Get attendance by ID
    @GetMapping("/id/{attendanceId}")
    public Optional<AttendanceInfo> getAttendanceById(@PathVariable int attendanceId) {
        return attendanceInfoService.getAttendanceById(attendanceId);
    }
}
