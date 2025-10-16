package com.xyzgaming.JobApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.xyzgaming.JobApp.model.JobPost;
import com.xyzgaming.JobApp.service.JobService;

@Controller
public class JobController {

	JobService service;

	@GetMapping({ "/", "home" })
	public String home() {
		System.out.println("home called ..");
		return "home";
	}

	@GetMapping("addjob")
	public String addJob() {
		System.out.println("addjob page called");
		return "addjob";
	}

	@GetMapping("viewalljobs")
	public String viewAllJobs(Model m) {
		System.out.println("view jobs called...");
		List<JobPost> jobs = service.getJobs();
		m.addAttribute("jobPosts", jobs);
		return "viewalljobs";
	}

	@PostMapping("handleForm")
	public String handleform(JobPost jobPost) {
		service.addJob(jobPost);
		return "success";
	}

	public JobService getService() {
		return service;
	}

	@Autowired
	public void setService(JobService service) {
		this.service = service;
	}

}
