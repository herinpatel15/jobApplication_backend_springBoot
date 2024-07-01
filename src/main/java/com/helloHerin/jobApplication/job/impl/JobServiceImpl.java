package com.helloHerin.jobApplication.job.impl;

import com.helloHerin.jobApplication.job.Job;
import com.helloHerin.jobApplication.job.JobRepository;
import com.helloHerin.jobApplication.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
//    private List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;
    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public String deleteJobById(Long id) {
        try{
            jobRepository.deleteById(id);
            return "delete job successfully";
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean updateJobById(Long id, Job upjob) {
        Optional<Job> jobOptinal = jobRepository.findById(id);
        if(jobOptinal.isPresent()) {
            Job job = jobOptinal.get();
            job.setId(upjob.getId());
            job.setTitle(upjob.getTitle());
            job.setDescription(upjob.getDescription());
            job.setMinSalary(upjob.getMinSalary());
            job.setMaxSalary(upjob.getMaxSalary());
            job.setLocation(upjob.getLocation());

            jobRepository.save(job);

            return true;
        }
        return false;
    }
}
