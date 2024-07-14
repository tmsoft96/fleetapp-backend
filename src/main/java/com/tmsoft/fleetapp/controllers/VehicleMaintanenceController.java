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

import com.tmsoft.fleetapp.models.Supplier;
import com.tmsoft.fleetapp.models.Vehicle;
import com.tmsoft.fleetapp.models.VehicleMaintanance;
import com.tmsoft.fleetapp.services.SupplierService;
import com.tmsoft.fleetapp.services.VehicleMaintananceService;
import com.tmsoft.fleetapp.services.VehicleService;

@Controller
public class VehicleMaintanenceController {
	
	@Autowired VehicleMaintananceService vehicleMaintananceService;
	@Autowired SupplierService supplierService;
	@Autowired VehicleService vehicleService;

	@GetMapping("/vehiclemaintenances")
	public String getVehicleMaintenances(Model model) {
		List<VehicleMaintanance> vehicleMaintananceList = vehicleMaintananceService.getVehicleMaintanances();
		List<Supplier> supplierList = supplierService.getSuppliers();
		List<Vehicle> vehicleList = vehicleService.getVehicles();

		// passing data to the web page
		model.addAttribute("vehicleMaintanances", vehicleMaintananceList);
		model.addAttribute("suppliers", supplierList);
		model.addAttribute("vehicles", vehicleList);

		return "pages-vehicle-maintenance";
	}

	@PostMapping("/vehiclemaintenances/addNew")
	public String addNew(VehicleMaintanance vehicleMaintanance) {
		vehicleMaintananceService.saveVehicleMaintanance(vehicleMaintanance);
		return "redirect:/vehiclemaintenances";
	}

	@GetMapping("/vehiclemaintenances/findById")
	@ResponseBody
	public Optional<VehicleMaintanance> findById(int id) {
		return vehicleMaintananceService.findById(id);
	}

	@RequestMapping(value = "/vehiclemaintenances/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleMaintanance vehicleMaintanance) {
		vehicleMaintananceService.saveVehicleMaintanance(vehicleMaintanance);
		return "redirect:/vehiclemaintenances";
	}

	@RequestMapping(value = "/vehiclemaintenances/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		vehicleMaintananceService.deleteVehicleMaintanance(id);
		return "redirect:/vehiclemaintenances";
	}
}
