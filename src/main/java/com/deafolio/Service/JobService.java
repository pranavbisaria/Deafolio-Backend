package com.deafolio.Service;

import com.deafolio.Models.Jobs;
import org.springframework.http.ResponseEntity;

public interface JobService {
    ResponseEntity<?> createJob(Jobs jobs);

    ResponseEntity<?> getAllJobs();
}
