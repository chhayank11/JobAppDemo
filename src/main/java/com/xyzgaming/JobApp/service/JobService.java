package com.xyzgaming.JobApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyzgaming.JobApp.dao.JobRepo;
import com.xyzgaming.JobApp.model.JobPost;

@Service
public class JobService {

	JobRepo jobRepo;

	public void addJob(JobPost jobPost) {
		jobRepo.addJob(jobPost);

	}

	public List<JobPost> getJobs() {
		return jobRepo.getJobs();

	}

	public JobRepo getJobRepo() {
		return jobRepo;
	}

	@Autowired
	public void setJobRepo(JobRepo jobRepo) {
		this.jobRepo = jobRepo;
	}

}
