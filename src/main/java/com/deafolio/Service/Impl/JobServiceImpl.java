package com.deafolio.Service.Impl;

import com.deafolio.Models.Jobs;
import com.deafolio.Payloads.ApiResponse;
import com.deafolio.Repository.JobRepo;
import com.deafolio.Service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpStatus.OK;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {
    private final JobRepo jobRepo;
    @Override
    public ResponseEntity<?> createJob(Jobs jobs){
        this.jobRepo.save(jobs);
        return ResponseEntity.status(OK).body(new ApiResponse("Jobs created successfully", true));
    }

    @Override
    public ResponseEntity<?> getAllJobs(){
        return ResponseEntity.status(OK).body(this.jobRepo.findAll());
    }

}
