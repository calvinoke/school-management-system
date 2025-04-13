package com.example.backend.repository;

import com.example.backend.Entity.Addteacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddteacherRepository extends JpaRepository<Addteacher, Integer> {
    // Add custom query methods if needed
}
