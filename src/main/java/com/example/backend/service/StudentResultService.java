package com.example.backend.service;

import com.example.backend.dto.StudentResultInfoDTO;
import com.example.backend.entity.ResultInfo;
import com.example.backend.entity.Addstudent;
import com.example.backend.repository.ResultInfoRepository;
import com.example.backend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentResultService {

    @Autowired
    private ResultInfoRepository resultRepository;

    @Autowired
    private StudentRepository studentRepository;

    public List<StudentResultInfoDTO> getAllStudentResults() {
        List<ResultInfo> results = resultRepository.findAll();
        List<StudentResultInfoDTO> dtoList = new ArrayList<>();

        for (ResultInfo result : results) {
            Addstudent student = studentRepository.findById(result.getStudent_id()).orElse(null);
            if (student != null) {
                dtoList.add(new StudentResultInfoDTO(
                    student.getStudent_id(),
                    student.getFull_name(),
                    student.getClass1(),
                    student.getSection(),
                    result.getResult_id(),
                    result.getSubjectwise_result(),
                    result.getPass_fail(),
                    result.getTotal_marks(),
                    result.getGrade(),
                    result.getExam_title()
                ));
            }
        }
        return dtoList;
    }
}
