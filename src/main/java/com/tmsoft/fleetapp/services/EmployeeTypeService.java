package com.tmsoft.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmsoft.fleetapp.models.EmployeeType;
import com.tmsoft.fleetapp.repositories.EmployeeTypeRepository;

@Service
public class EmployeeTypeService {

	@Autowired
	private EmployeeTypeRepository employeeTypeRepository;
	
	//Return list of states
	public List<EmployeeType> getEmployeeTypes() {
		return employeeTypeRepository.findAll();
	}
	
	//Save new state
	public void saveEmployeeType(EmployeeType state) {
		employeeTypeRepository.save(state);
	}
	
	// get state by id
	public Optional<EmployeeType> findById(int id) {
		return employeeTypeRepository.findById(id);
	}
	
	// delete state
	public void deleteEmployeeType(int id) {
		employeeTypeRepository.deleteById(id);
	}
}
