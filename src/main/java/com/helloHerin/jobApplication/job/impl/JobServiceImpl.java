package com.helloHerin.jobApplication.job.impl;

import com.helloHerin.jobApplication.job.Job;
import com.helloHerin.jobApplication.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public Job getJobById(Long id) {
        for (Job job : jobs) {
            if(job.getId().equals(id)) {
                return job;
            }
        }
        return null;
    }

    @Override
    public String deleteJobById(Long id) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                jobs.remove(job);
                return "delete job successful...";
            }
        }
        return null;
    }

    @Override
    public boolean updateJobById(Long id, Job upjob) {
        for (Job job : jobs) {
            if(job.getId().equals(id)) {
                job.setId(upjob.getId());
                job.setTitle(upjob.getTitle());
                job.setDescription(upjob.getDescription());
                job.setMinSalary(upjob.getMinSalary());
                job.setMaxSalary(upjob.getMaxSalary());
                job.setLocation(upjob.getLocation());

                return true;
            }
        }
        return false;
    }
}
