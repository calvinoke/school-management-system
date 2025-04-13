package com.example.backend.service;

import com.example.backend.entity.OnlineAdmission;
import com.example.backend.repository.OnlineAdmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OnlineAdmissionService {

    @Autowired
    private OnlineAdmissionRepository repository;

    public OnlineAdmission save(OnlineAdmission admission) {
        return repository.save(admission);
    }

    public List<OnlineAdmission> getAll() {
        return repository.findAll();
    }

    public OnlineAdmission getById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
