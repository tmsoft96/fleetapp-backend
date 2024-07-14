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

import com.tmsoft.fleetapp.models.VehicleModel;
import com.tmsoft.fleetapp.services.VehicleModelService;

@Controller
public class VehicleModelController {

	@Autowired
	VehicleModelService vehicleModelService;

	@GetMapping("/vehiclemodels")
	public String getVehicleModels(Model model) {
		List<VehicleModel> vehicleModelList = vehicleModelService.getVehicleModels();

		// passing data to the web page
		model.addAttribute("vehicleModels", vehicleModelList);

		return "pages-vehicle-model";
	}

	@PostMapping("/vehiclemodels/addNew")
	public String addNew(VehicleModel vehicleModel) {
		vehicleModelService.saveVehicleModel(vehicleModel);
		return "redirect:/vehiclemodels";
	}

	@GetMapping("/vehiclemodels/findById")
	@ResponseBody
	public Optional<VehicleModel> findById(int id) {
		return vehicleModelService.findById(id);
	}

	@RequestMapping(value = "/vehiclemodels/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleModel vehicleModel) {
		vehicleModelService.saveVehicleModel(vehicleModel);
		return "redirect:/vehiclemodels";
	}

	@RequestMapping(value = "/vehiclemodels/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		vehicleModelService.deleteVehicleModel(id);
		return "redirect:/vehiclemodels";
	}
}
