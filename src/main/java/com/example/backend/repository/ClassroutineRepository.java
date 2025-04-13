package com.example.backend.repository;

import com.example.backend.entity.Classroutine;
import org.springframework.data.jpa.repository.JpaRepository;

//import org.springframework.data.jpa.repository.JpaRepository;
//import com.example.backend.entity.Classroutine;
import java.util.List;

public interface ClassroutineRepository extends JpaRepository<Classroutine, Long> {

    // Define custom query method based on the field in the entity
    List<Classroutine> findByClassName(String className);
}

