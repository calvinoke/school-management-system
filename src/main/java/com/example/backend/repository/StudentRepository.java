package com.example.backend.repository;

import com.example.backend.Entity.Addstudent;  // Make sure to import Addstudent
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Addstudent, Integer> {

    // Find student by email, using Optional for better null safety
    Optional<Addstudent> findByEmail(String email);

    // Find students by class name
    List<Addstudent> findByClass1In(List<String> classNames);
}
