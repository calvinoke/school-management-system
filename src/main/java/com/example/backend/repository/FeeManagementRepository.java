package com.example.backend.repository;

import com.example.backend.entity.FeeManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface FeeManagementRepository extends JpaRepository<FeeManagement, Integer> {
    
    // Custom method to find the latest FeeManagement by studentId
    FeeManagement findLatestByStudentId(int studentId);

    // ✅ Add this method
  
    List<FeeManagement> findByStudentIdAndStatus(int studentId, String status);

}
