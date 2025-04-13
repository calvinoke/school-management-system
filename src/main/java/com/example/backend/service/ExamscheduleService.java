package com.example.backend.service;
import com.example.backend.repository.ExamscheduleRepository;
import com.example.backend.entity.Examschedule;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamscheduleService {

    @Autowired
    private ExamscheduleRepository repository;

    public List<Examschedule> getAllExamSchedules() {
        return repository.findAll();
    }

    public Optional<Examschedule> getExamScheduleById(int id) {
        return repository.findById(id);
    }

    public Examschedule addExamSchedule(Examschedule examSchedule) {
        return repository.save(examSchedule);
    }

    public Examschedule updateExamSchedule(int id, Examschedule updatedExam) {
        return repository.findById(id).map(exam -> {
            exam.setExamTitle(updatedExam.getExamTitle());
            exam.setClass1(updatedExam.getClass1());
            exam.setSubject(updatedExam.getSubject());
            exam.setExamType(updatedExam.getExamType());
            exam.setExamHall(updatedExam.getExamHall());
            exam.setExamStart(updatedExam.getExamStart());
            exam.setExamEnd(updatedExam.getExamEnd());
            exam.setExamInvigilator(updatedExam.getExamInvigilator());
            exam.setExamDate(updatedExam.getExamDate());
            return repository.save(exam);
        }).orElseGet(() -> {
            updatedExam.setExamID(id);
            return repository.save(updatedExam);
        });
    }

    public void deleteExamSchedule(int id) {
        repository.deleteById(id);
    }
}
