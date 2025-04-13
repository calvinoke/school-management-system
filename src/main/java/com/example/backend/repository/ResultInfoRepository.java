package com.example.backend.repository;

import java.util.List;  // Add this import
import com.example.backend.entity.ResultInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultInfoRepository extends JpaRepository<ResultInfo, Integer> {

    // Custom query methods
    List<ResultInfo> findByStudentId(int studentId);
    
    // Other custom queries
    List<ResultInfo> findBySomeCriteria(ResultInfo resultInfo);  // Customize based on your requirements
}
