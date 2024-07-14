package com.tmsoft.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmsoft.fleetapp.models.Employee;
import com.tmsoft.fleetapp.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	//Return list of states
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}
	
	//Save new state
	public void saveEmployee(Employee state) {
		employeeRepository.save(state);
	}
	
	// get state by id
	public Optional<Employee> findById(int id) {
		return employeeRepository.findById(id);
	}
	
	// delete state
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}
}
