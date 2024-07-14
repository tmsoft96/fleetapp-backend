package com.tmsoft.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmsoft.fleetapp.models.JobTitle;
import com.tmsoft.fleetapp.repositories.JobTitleRepository;

@Service
public class JobTitleService {

	@Autowired
	private JobTitleRepository jobTitleRepository;
	
	//Return list of states
	public List<JobTitle> getJobTitles() {
		return jobTitleRepository.findAll();
	}
	
	//Save new state
	public void saveJobTitle(JobTitle state) {
		jobTitleRepository.save(state);
	}
	
	// get state by id
	public Optional<JobTitle> findById(int id) {
		return jobTitleRepository.findById(id);
	}
	
	// delete state
	public void deleteJobTitle(int id) {
		jobTitleRepository.deleteById(id);
	}
}
