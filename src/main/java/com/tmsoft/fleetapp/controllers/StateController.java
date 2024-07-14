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
import com.tmsoft.fleetapp.services.CountryService;
import com.tmsoft.fleetapp.services.StateService;

@Controller
public class StateController {

	@Autowired private StateService stateService;
	@Autowired private CountryService countryService;

	@GetMapping("/states")
	public String getStates(Model model) {
		List<State> stateList = stateService.getStates();
		List<Country> countryList = countryService.getCountries();

		// passing data to the web page
		model.addAttribute("states", stateList);
		model.addAttribute("countries", countryList);

		return "pages-state";
	}

	@PostMapping("/states/addNew")
	public String addNew(State state) {
		stateService.saveState(state);
		return "redirect:/states";
	}

	@GetMapping("/states/findById")
	@ResponseBody
	public Optional<State> findById(int id) {
		return stateService.findById(id);
	}

	@RequestMapping(value = "/states/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(State state) {
		stateService.saveState(state);
		return "redirect:/states";
	}

	@RequestMapping(value = "/states/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		stateService.deleteState(id);
		return "redirect:/states";
	}
}
