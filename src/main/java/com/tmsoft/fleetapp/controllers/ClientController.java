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
import com.tmsoft.fleetapp.models.Country;
import com.tmsoft.fleetapp.models.State;
import com.tmsoft.fleetapp.services.ClientService;
import com.tmsoft.fleetapp.services.CountryService;
import com.tmsoft.fleetapp.services.StateService;

@Controller
public class ClientController {

	@Autowired ClientService clientService;
	@Autowired CountryService countryService;
	@Autowired StateService stateService;

	@GetMapping("/clients")
	public String getClients(Model model) {
		List<Client> clientList = clientService.getClients();
		List<Country> countryList = countryService.getCountries();
		List<State> stateList = stateService.getStates();

		// passing data to the web page
		model.addAttribute("clients", clientList);
		model.addAttribute("states", stateList);
		model.addAttribute("countries", countryList);

		return "pages-client";
	}

	@PostMapping("/clients/addNew")
	public String addNew(Client client) {
		clientService.saveClient(client);
		return "redirect:/clients";
	}

	@GetMapping("/clients/findById")
	@ResponseBody
	public Optional<Client> findById(int id) {
		return clientService.findById(id);
	}

	@RequestMapping(value = "/clients/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Client client) {
		clientService.saveClient(client);
		return "redirect:/clients";
	}

	@RequestMapping(value = "/clients/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		clientService.deleteClient(id);
		return "redirect:/clients";
	}
}
