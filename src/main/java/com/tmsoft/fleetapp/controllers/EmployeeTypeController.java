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

import com.tmsoft.fleetapp.models.EmployeeType;
import com.tmsoft.fleetapp.services.EmployeeTypeService;

@Controller
public class EmployeeTypeController {

	@Autowired
	EmployeeTypeService employeeTypeService;

	@GetMapping("/employeetypes")
	public String getEmployeeTypes(Model model) {
		List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeeTypes();

		// passing data to the web page
		model.addAttribute("employeeTypes", employeeTypeList);

		return "pages-employee-type";
	}

	@PostMapping("/employeetypes/addNew")
	public String addNew(EmployeeType employeeType) {
		employeeTypeService.saveEmployeeType(employeeType);
		return "redirect:/employeetypes";
	}

	@GetMapping("/employeetypes/findById")
	@ResponseBody
	public Optional<EmployeeType> findById(int id) {
		return employeeTypeService.findById(id);
	}

	@RequestMapping(value = "/employeetypes/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(EmployeeType employeeType) {
		employeeTypeService.saveEmployeeType(employeeType);
		return "redirect:/employeetypes";
	}

	@RequestMapping(value = "/employeetypes/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		employeeTypeService.deleteEmployeeType(id);
		return "redirect:/employeetypes";
	}
}
