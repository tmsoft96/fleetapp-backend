package com.tmsoft.fleetapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tmsoft.fleetapp.models.JobTitle;
import com.tmsoft.fleetapp.services.JobTitleService;

@Controller
public class JobTitleController {

	@Autowired
	JobTitleService jobTitleService;

	@GetMapping("/jobtitles")
	public String getJobTitles(Model model) {
		List<JobTitle> jobTitleList = jobTitleService.getJobTitles();

		// passing data to the web page
		model.addAttribute("jobTitles", jobTitleList);

		return "pages-job-title";
	}

	@PostMapping("/jobtitles/addNew")
	public String addNew(JobTitle jobTitle) {
		jobTitleService.saveJobTitle(jobTitle);
		return "redirect:/jobtitles";
	}

	@GetMapping("/jobtitles/findById")
	@ResponseBody
	public Optional<JobTitle> findById(int id) {
		return jobTitleService.findById(id);
	}

	@RequestMapping(value = "/jobtitles/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(JobTitle jobTitle) {
		jobTitleService.saveJobTitle(jobTitle);
		return "redirect:/jobtitles";
	}

	@RequestMapping(value = "/jobtitles/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		jobTitleService.deleteJobTitle(id);
		return "redirect:/jobtitles";
	}
}
