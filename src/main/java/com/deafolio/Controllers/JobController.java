package com.deafolio.Controllers;

import com.deafolio.Models.Jobs;
import com.deafolio.Service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/jobs")
public class JobController {
    private final JobService jobService;

    @PostMapping("/create")
    public ResponseEntity<?> createJob(@RequestBody Jobs jobs){
        return this.jobService.createJob(jobs);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllJobs(){
        return this.jobService.getAllJobs();
    }
}
