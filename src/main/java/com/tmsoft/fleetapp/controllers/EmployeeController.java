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

import com.tmsoft.fleetapp.models.Country;
import com.tmsoft.fleetapp.models.Employee;
import com.tmsoft.fleetapp.models.EmployeeType;
import com.tmsoft.fleetapp.models.JobTitle;
import com.tmsoft.fleetapp.models.State;
import com.tmsoft.fleetapp.services.CountryService;
import com.tmsoft.fleetapp.services.EmployeeService;
import com.tmsoft.fleetapp.services.EmployeeTypeService;
import com.tmsoft.fleetapp.services.JobTitleService;
import com.tmsoft.fleetapp.services.StateService;

@Controller
public class EmployeeController {
	
	@Autowired EmployeeService employeeService;
	@Autowired EmployeeTypeService employeeTypeService;
	@Autowired JobTitleService jobTitleService;
	@Autowired CountryService countryService;
	@Autowired StateService stateService;

	@GetMapping("/employees")
	public String getEmployees(Model model) {
		List<Employee> employeeList = employeeService.getEmployees();
		List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeeTypes();
		List<JobTitle> jobTitleList = jobTitleService.getJobTitles();
		List<Country> countryList = countryService.getCountries();
		List<State> stateList = stateService.getStates();
		String[] titleList = {"Mr.", "Mrs.", "Dr.", "Miss"};
		String[] genderList = {"Male", "Female"};
		String[] maritalStatus = {"Single", "Engaged", "Married"};

		// passing data to the web page
		model.addAttribute("employees", employeeList);
		model.addAttribute("employeeTypes", employeeTypeList);
		model.addAttribute("jobTitles", jobTitleList);
		model.addAttribute("countries", countryList);
		model.addAttribute("states", stateList);
		model.addAttribute("titles", titleList);
		model.addAttribute("genders", genderList);
		model.addAttribute("maritalsStatus", maritalStatus);

		return "pages-employee";
	}

	@PostMapping("/employees/addNew")
	public String addNew(Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}

	@GetMapping("/employees/findById")
	@ResponseBody
	public Optional<Employee> findById(int id) {
		return employeeService.findById(id);
	}

	@RequestMapping(value = "/employees/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}

	@RequestMapping(value = "/employees/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		employeeService.deleteEmployee(id);
		return "redirect:/employees";
	}
}
