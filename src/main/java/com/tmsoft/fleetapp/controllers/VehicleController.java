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

import com.tmsoft.fleetapp.models.Employee;
import com.tmsoft.fleetapp.models.Location;
import com.tmsoft.fleetapp.models.Vehicle;
import com.tmsoft.fleetapp.models.VehicleMake;
import com.tmsoft.fleetapp.models.VehicleModel;
import com.tmsoft.fleetapp.models.VehicleStatus;
import com.tmsoft.fleetapp.models.VehicleType;
import com.tmsoft.fleetapp.services.EmployeeService;
import com.tmsoft.fleetapp.services.LocationService;
import com.tmsoft.fleetapp.services.VehicleMakeService;
import com.tmsoft.fleetapp.services.VehicleModelService;
import com.tmsoft.fleetapp.services.VehicleService;
import com.tmsoft.fleetapp.services.VehicleStatusService;
import com.tmsoft.fleetapp.services.VehicleTypeService;

@Controller
public class VehicleController {

	@Autowired VehicleService vehicleService;
	@Autowired LocationService locationService;
	@Autowired VehicleMakeService vehicleMakeService;
	@Autowired VehicleModelService vehicleModelService;
	@Autowired VehicleStatusService vehicleStatusService;
	@Autowired VehicleTypeService vehicleTypeService;
	@Autowired EmployeeService employeeService;

	@GetMapping("/vehicles")
	public String getVehicles(Model model) {
		List<Vehicle> vehicleList = vehicleService.getVehicles();
		List<Location> locationList = locationService.getLocations();
		List<VehicleMake> vehicleMakeList = vehicleMakeService.getVehicleMakes();
		List<VehicleModel> vehicleModelList = vehicleModelService.getVehicleModels();
		List<VehicleStatus> vehicleStatusList = vehicleStatusService.getVehicleStatus();
		List<VehicleType> vehicleTypeList = vehicleTypeService.getVehicleTypes();
		List<Employee> emploeeList = employeeService.getEmployees();

		// passing data to the web page
		model.addAttribute("vehicles", vehicleList);
		model.addAttribute("locations", locationList);
		model.addAttribute("vehicleMakes", vehicleMakeList);
		model.addAttribute("vehicleModels", vehicleModelList);
		model.addAttribute("vehiclesStatus", vehicleStatusList);
		model.addAttribute("vehicleTypes", vehicleTypeList);
		model.addAttribute("employees", emploeeList);

		return "pages-vehicle";
	}

	@PostMapping("/vehicles/addNew")
	public String addNew(Vehicle vehicle) {
		vehicleService.saveVehicle(vehicle);
		return "redirect:/vehicles";
	}

	@GetMapping("/vehicles/findById")
	@ResponseBody
	public Optional<Vehicle> findById(int id) {
		return vehicleService.findById(id);
	}

	@RequestMapping(value = "/vehicles/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Vehicle vehicle) {
		vehicleService.saveVehicle(vehicle);
		return "redirect:/vehicles";
	}

	@RequestMapping(value = "/vehicles/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		vehicleService.deleteVehicle(id);
		return "redirect:/vehicles";
	}
}
