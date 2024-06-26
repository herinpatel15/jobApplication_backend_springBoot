package com.helloHerin.jobApplication.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();

    void createJob(Job job);

    Job getJobById(Long id);

    String deleteJobById(Long id);

    boolean updateJobById(Long id, Job upjob);
}
