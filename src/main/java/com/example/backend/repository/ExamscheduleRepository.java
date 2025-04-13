package com.example.backend.repository;
import com.example.backend.entity.Examschedule;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamscheduleRepository extends JpaRepository<Examschedule, Integer> {
}
