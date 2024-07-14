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

import com.tmsoft.fleetapp.models.VehicleMake;
import com.tmsoft.fleetapp.services.VehicleMakeService;

@Controller
public class VehicleMakeController {

	@Autowired
	VehicleMakeService vehicleMakeService;

	@GetMapping("/vehiclemakes")
	public String getVehicleMakes(Model model) {
		List<VehicleMake> vehicleMakeList = vehicleMakeService.getVehicleMakes();

		// passing data to the web page
		model.addAttribute("vehicleMakes", vehicleMakeList);

		return "pages-vehicle-make";
	}

	@PostMapping("/vehiclemakes/addNew")
	public String addNew(VehicleMake vehicleMake) {
		vehicleMakeService.saveVehicleMake(vehicleMake);
		return "redirect:/vehiclemakes";
	}

	@GetMapping("/vehiclemakes/findById")
	@ResponseBody
	public Optional<VehicleMake> findById(int id) {
		return vehicleMakeService.findById(id);
	}

	@RequestMapping(value = "/vehiclemakes/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleMake vehicleMake) {
		vehicleMakeService.saveVehicleMake(vehicleMake);
		return "redirect:/vehiclemakes";
	}

	@RequestMapping(value = "/vehiclemakes/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		vehicleMakeService.deleteVehicleMake(id);
		return "redirect:/vehiclemakes";
	}
}
