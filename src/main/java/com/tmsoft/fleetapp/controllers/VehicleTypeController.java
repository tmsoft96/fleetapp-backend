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

import com.tmsoft.fleetapp.models.VehicleType;
import com.tmsoft.fleetapp.services.VehicleTypeService;

@Controller
public class VehicleTypeController {

	@Autowired
	VehicleTypeService vehicleTypeService;

	@GetMapping("/vehicletypes")
	public String getVehicleTypes(Model model) {
		List<VehicleType> vehicleTypeList = vehicleTypeService.getVehicleTypes();

		// passing data to the web page
		model.addAttribute("vehicleTypes", vehicleTypeList);

		return "pages-vehicle-type";
	}

	@PostMapping("/vehicletypes/addNew")
	public String addNew(VehicleType vehicleType) {
		vehicleTypeService.saveVehicleType(vehicleType);
		return "redirect:/vehicletypes";
	}

	@GetMapping("/vehicletypes/findById")
	@ResponseBody
	public Optional<VehicleType> findById(int id) {
		return vehicleTypeService.findById(id);
	}

	@RequestMapping(value = "/vehicletypes/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleType vehicleType) {
		vehicleTypeService.saveVehicleType(vehicleType);
		return "redirect:/vehicletypes";
	}

	@RequestMapping(value = "/vehicletypes/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		vehicleTypeService.deleteVehicleType(id);
		return "redirect:/vehicletypes";
	}

}
