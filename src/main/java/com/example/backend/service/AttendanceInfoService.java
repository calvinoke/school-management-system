package com.example.backend.service;

import com.example.backend.entity.AttendanceInfo;
import com.example.backend.repository.AttendanceInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceInfoService {

    @Autowired
    private AttendanceInfoRepository attendanceInfoRepository;

    // Save attendance info
    public AttendanceInfo saveAttendance(AttendanceInfo attendanceInfo) {
        return attendanceInfoRepository.save(attendanceInfo);
    }

    // Get all attendance info
    public List<AttendanceInfo> getAllAttendance() {
        return attendanceInfoRepository.findAll();
    }

    // Get attendance by studentId
    public List<AttendanceInfo> getAttendanceByStudentId(int studentId) {
        return attendanceInfoRepository.findAll().stream()
                .filter(attendance -> attendance.getStudentId() == studentId)
                .toList();
    }

    // Update attendance info
    public AttendanceInfo updateAttendance(AttendanceInfo attendanceInfo) {
        return attendanceInfoRepository.save(attendanceInfo);
    }

    // Delete attendance info by ID
    public void deleteAttendance(int attendanceId) {
        attendanceInfoRepository.deleteById(attendanceId);
    }

    // Find attendance by ID
    public Optional<AttendanceInfo> getAttendanceById(int attendanceId) {
        return attendanceInfoRepository.findById(attendanceId);
    }
}
