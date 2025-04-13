package com.example.backend.service;

import com.example.backend.entity.ResultInfo;
import com.example.backend.repository.ResultInfoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//import java.util.Optional;

@Service
public class ResultInfoService {

    @Autowired
    private ResultInfoRepository resultInfoRepository;

    // Save ResultInfo record
    public ResultInfo saveResultInfo(ResultInfo resultInfo) {
        return resultInfoRepository.save(resultInfo);
    }

    // Get all ResultInfo records
    public List<ResultInfo> getAllResultInfo() {
        return resultInfoRepository.findAll();
    }

    // Get ResultInfo by ID
    public ResultInfo getResultInfoById(int result_id) {
        return resultInfoRepository.findById(result_id)
                .orElseThrow(() -> new EntityNotFoundException("Result not found with ID: " + result_id));
    }

    // Update ResultInfo record
    public ResultInfo updateResultInfo(ResultInfo resultInfo) {
        if (!resultInfoRepository.existsById(resultInfo.getResult_id())) {
            throw new EntityNotFoundException("Result not found with ID: " + resultInfo.getResult_id());
        }
        return resultInfoRepository.save(resultInfo);
    }

    // Delete ResultInfo record
    public void deleteResultInfo(int result_id) {
        if (!resultInfoRepository.existsById(result_id)) {
            throw new EntityNotFoundException("Result not found with ID: " + result_id);
        }
        resultInfoRepository.deleteById(result_id);
    }
}
