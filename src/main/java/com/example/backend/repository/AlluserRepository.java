package com.example.backend.repository;

import com.example.backend.entity.Alluser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlluserRepository extends JpaRepository<Alluser, String> {
    Optional<Alluser> findByEmail(String email);
    Optional<Alluser> findByEmailAndPassword(String email, String password);
    Alluser findByUsername(String username);
}
