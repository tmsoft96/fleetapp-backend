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
import com.tmsoft.fleetapp.models.State;
import com.tmsoft.fleetapp.models.Supplier;
import com.tmsoft.fleetapp.services.CountryService;
import com.tmsoft.fleetapp.services.StateService;
import com.tmsoft.fleetapp.services.SupplierService;

@Controller
public class SupplierController {
	
	@Autowired private SupplierService supplierService;
	@Autowired private CountryService countryService;
	@Autowired private StateService stateService;


	@GetMapping("/suppliers")
	public String getSuppliers(Model model) {
		List<Supplier> supplierList = supplierService.getSuppliers();
		List<Country> countryList = countryService.getCountries();
		List<State> stateList = stateService.getStates();

		// passing data to the web page
		model.addAttribute("suppliers", supplierList);
		model.addAttribute("countries", countryList);
		model.addAttribute("states", stateList);

		return "pages-supplier";
	}
	
	@PostMapping("/suppliers/addNew")
	public String addNew(Supplier supplier) {
		supplierService.saveSupplier(supplier);
		return "redirect:/suppliers";
	}

	@GetMapping("/suppliers/findById")
	@ResponseBody
	public Optional<Supplier> findById(int id) {
		return supplierService.findById(id);
	}

	@RequestMapping(value = "/suppliers/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Supplier supplier) {
		supplierService.saveSupplier(supplier);
		return "redirect:/suppliers";
	}

	@RequestMapping(value = "/suppliers/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		supplierService.deleteSupplier(id);
		return "redirect:/suppliers";
	}
}
