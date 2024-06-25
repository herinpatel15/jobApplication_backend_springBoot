package com.helloHerin.jobApplication.job;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {
    private List<Job> jobs = new ArrayList<>();

    @GetMapping("/jobs")
    public List<Job> allJobs() {
        return jobs;
    }

    @PostMapping("/jobs")
    public String addJobs(@RequestBody Job job) {
        jobs.add(job);
        return "Job add successful...";
    }
}