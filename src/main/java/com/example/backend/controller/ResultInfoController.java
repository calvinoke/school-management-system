package com.example.backend.controller;

import com.example.backend.entity.ResultInfo;
import com.example.backend.service.ResultInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/results")
public class ResultInfoController {

    @Autowired
    private ResultInfoService resultInfoService;

    // Create or Update ResultInfo
    @PostMapping
    public ResponseEntity<ResultInfo> createOrUpdateResultInfo(@RequestBody ResultInfo resultInfo) {
        ResultInfo savedResultInfo = resultInfoService.saveResultInfo(resultInfo);
        return new ResponseEntity<>(savedResultInfo, HttpStatus.CREATED);
    }

    // Get all ResultInfo records
    @GetMapping
    public ResponseEntity<List<ResultInfo>> getAllResultInfo() {
        List<ResultInfo> resultInfos = resultInfoService.getAllResultInfo();
        return new ResponseEntity<>(resultInfos, HttpStatus.OK);
    }

    // Get ResultInfo by ID
    @GetMapping("/{result_id}")
    public ResponseEntity<ResultInfo> getResultInfoById(@PathVariable int result_id) {
        ResultInfo resultInfo = resultInfoService.getResultInfoById(result_id);
        return new ResponseEntity<>(resultInfo, HttpStatus.OK);
    }

    // Delete ResultInfo by ID
    @DeleteMapping("/{result_id}")
    public ResponseEntity<Void> deleteResultInfo(@PathVariable int result_id) {
        resultInfoService.deleteResultInfo(result_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
