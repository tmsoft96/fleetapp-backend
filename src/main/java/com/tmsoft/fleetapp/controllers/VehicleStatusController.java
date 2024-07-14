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

import com.tmsoft.fleetapp.models.VehicleStatus;
import com.tmsoft.fleetapp.services.VehicleStatusService;

@Controller
public class VehicleStatusController {

	@Autowired
	VehicleStatusService vehicleStatusService;

	@GetMapping("/vehiclestatus")
	public String getVehicleStatus(Model model) {
		List<VehicleStatus> vehicleStatusList = vehicleStatusService.getVehicleStatus();

		// passing data to the web page
		model.addAttribute("vehiclesStatus", vehicleStatusList);

		return "pages-vehicle-status";
	}

	@PostMapping("/vehiclestatus/addNew")
	public String addNew(VehicleStatus vehicleStatus) {
		vehicleStatusService.saveVehicleStatus(vehicleStatus);
		return "redirect:/vehiclestatus";
	}

	@GetMapping("/vehiclestatus/findById")
	@ResponseBody
	public Optional<VehicleStatus> findById(int id) {
		return vehicleStatusService.findById(id);
	}

	@RequestMapping(value = "/vehiclestatus/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleStatus vehicleStatus) {
		vehicleStatusService.saveVehicleStatus(vehicleStatus);
		return "redirect:/vehiclestatus";
	}

	@RequestMapping(value = "/vehiclestatus/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		vehicleStatusService.deleteVehicleStatus(id);
		return "redirect:/vehiclestatus";
	}
}
