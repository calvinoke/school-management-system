package com.example.backend.repository;

import com.example.backend.entity.OnlineAdmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.example.backend.entity.OnlineAdmission;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//import com.example.backend.entity.OnlineAdmission;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OnlineAdmissionRepository extends JpaRepository<OnlineAdmission, Integer> {
    // Custom query method to search by name or id (partial match)
    List<OnlineAdmission> findByNameContainingOrIdContaining(String name, String id);
    
    // Custom query method to find OnlineAdmissions by status
    List<OnlineAdmission> findByStatus(String status);  // Assuming `status` field exists in the entity
}

