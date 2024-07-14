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

import com.tmsoft.fleetapp.models.Location;
import com.tmsoft.fleetapp.models.Vehicle;
import com.tmsoft.fleetapp.models.VehicleMovement;
import com.tmsoft.fleetapp.services.LocationService;
import com.tmsoft.fleetapp.services.VehicleMovementService;
import com.tmsoft.fleetapp.services.VehicleService;

@Controller
public class VehicleMovementController {
	
	@Autowired VehicleMovementService vehicleMovementService;
	@Autowired LocationService locationService;
	@Autowired VehicleService vehicleService;

	@GetMapping("/vehiclemovements")
	public String getVehicleMovements(Model model) {
		List<VehicleMovement> vehicleMovementList = vehicleMovementService.getVehicleMovements();
		List<Location> locationList = locationService.getLocations();
		List<Vehicle> vehicleList = vehicleService.getVehicles();

		// passing data to the web page
		model.addAttribute("vehicleMovements", vehicleMovementList);
		model.addAttribute("locations", locationList);
		model.addAttribute("vehicles", vehicleList);

		return "pages-vehicle-movement";
	}

	@PostMapping("/vehiclemovements/addNew")
	public String addNew(VehicleMovement vehicleMovement) {
		vehicleMovementService.saveVehicleMovement(vehicleMovement);
		return "redirect:/vehiclemovements";
	}

	@GetMapping("/vehiclemovements/findById")
	@ResponseBody
	public Optional<VehicleMovement> findById(int id) {
		return vehicleMovementService.findById(id);
	}

	@RequestMapping(value = "/vehiclemovements/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleMovement vehicleMovement) {
		vehicleMovementService.saveVehicleMovement(vehicleMovement);
		return "redirect:/vehicleMovements";
	}

	@RequestMapping(value = "/vehiclemovements/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		vehicleMovementService.deleteVehicleMovement(id);
		return "redirect:/vehiclemovements";
	}
}
