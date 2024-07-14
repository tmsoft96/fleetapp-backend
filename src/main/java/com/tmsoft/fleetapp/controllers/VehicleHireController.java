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

import com.tmsoft.fleetapp.models.Client;
import com.tmsoft.fleetapp.models.Location;
import com.tmsoft.fleetapp.models.Vehicle;
import com.tmsoft.fleetapp.models.VehicleHire;
import com.tmsoft.fleetapp.services.ClientService;
import com.tmsoft.fleetapp.services.LocationService;
import com.tmsoft.fleetapp.services.VehicleHireService;
import com.tmsoft.fleetapp.services.VehicleService;

@Controller
public class VehicleHireController {
	@Autowired VehicleHireService vehicleHireService;
	@Autowired VehicleService vehicleService;
	@Autowired LocationService locationService;
	@Autowired ClientService clientService;

	@GetMapping("/vehiclehires")
	public String getVehicleHires(Model model) {
		List<VehicleHire> vehicleHireList = vehicleHireService.getVehicleHires();
		List<Vehicle> vehicleList = vehicleService.getVehicles();
		List<Location> locationList = locationService.getLocations();
		List<Client> clientList = clientService.getClients();

		// passing data to the web page
		model.addAttribute("vehicleHires", vehicleHireList);
		model.addAttribute("vehicles", vehicleList);
		model.addAttribute("locations", locationList);
		model.addAttribute("clients", clientList);

		return "pages-vehicle-hire";
	}

	@PostMapping("/vehiclehires/addNew")
	public String addNew(VehicleHire vehicleHire) {
		vehicleHireService.saveVehicleHire(vehicleHire);
		return "redirect:/vehicleHires";
	}

	@GetMapping("/vehiclehires/findById")
	@ResponseBody
	public Optional<VehicleHire> findById(int id) {
		return vehicleHireService.findById(id);
	}

	@RequestMapping(value = "/vehiclehires/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleHire vehicleHire) {
		vehicleHireService.saveVehicleHire(vehicleHire);
		return "redirect:/vehicleHires";
	}

	@RequestMapping(value = "/vehiclehires/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		vehicleHireService.deleteVehicleHire(id);
		return "redirect:/vehicleHires";
	}
}
