package com.example.backend.repository;

import com.example.backend.entity.AttendanceInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceInfoRepository extends JpaRepository<AttendanceInfo, Integer> {

    // Custom query method to find AttendanceInfo by studentId
    List<AttendanceInfo> findByStudentId(int studentId);
}
