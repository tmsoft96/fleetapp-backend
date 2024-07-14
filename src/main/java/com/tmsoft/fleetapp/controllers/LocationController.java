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
import com.tmsoft.fleetapp.models.Location;
import com.tmsoft.fleetapp.models.State;
import com.tmsoft.fleetapp.services.CountryService;
import com.tmsoft.fleetapp.services.LocationService;
import com.tmsoft.fleetapp.services.StateService;

@Controller
public class LocationController {
	
	@Autowired LocationService locationService;
	@Autowired CountryService countryService;
	@Autowired StateService stateService;

	@GetMapping("/locations")
	public String getLocations(Model model) {
		List<Location> locationList = locationService.getLocations();
		List<Country> countryList = countryService.getCountries();
		List<State> stateList = stateService.getStates();

		// passing data to the web page
		model.addAttribute("locations", locationList);
		model.addAttribute("countries", countryList);
		model.addAttribute("states", stateList);
		
		return "pages-location";
	}
	
	@PostMapping("/locations/addNew")
	public String addNew(Location location) {
		locationService.saveLocation(location);
		return "redirect:/locations";
	}

	@GetMapping("/locations/findById")
	@ResponseBody
	public Optional<Location> findById(int id) {
		return locationService.findById(id);
	}

	@RequestMapping(value = "/locations/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Location location) {
		locationService.saveLocation(location);
		return "redirect:/locations";
	}

	@RequestMapping(value = "/locations/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		locationService.deleteLocation(id);
		return "redirect:/locations";
	}
}
