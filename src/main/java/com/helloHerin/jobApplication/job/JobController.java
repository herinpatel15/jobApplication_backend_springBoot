package com.helloHerin.jobApplication.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    // get all jobs :- GET request: /jobs
    @GetMapping
    public ResponseEntity<List<Job>> allJobs() {
        return ResponseEntity.ok(jobService.findAll());
    }

    // create job and add :- POST request: /jobs
    @PostMapping
    public ResponseEntity<String> addJobs(@RequestBody Job job) {
        jobService.createJob(job);
        return ResponseEntity.ok("Job add successful...");
    }

    // for job find using id :- GET request: /job/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Job job = jobService.getJobById(id);
        if (job == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(job);
    }

    // delete any job :- DELETE request: job/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id) {
        String res = jobService.deleteJobById(id);
        if (res == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(res);
    }

    // update a job entity :- PUT request: job/{id}
    @PutMapping("/{id}")
    public ResponseEntity<String> updateJobById(@PathVariable Long id, @RequestBody Job upjob) {
        boolean update = jobService.updateJobById(id, upjob);
        if(update)
            return ResponseEntity.status(HttpStatus.OK).body("Job update successful...");

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
