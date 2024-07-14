package com.tmsoft.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmsoft.fleetapp.models.Client;
import com.tmsoft.fleetapp.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	//Return list of states
	public List<Client> getClients() {
		return clientRepository.findAll();
	}
	
	//Save new state
	public void saveClient(Client state) {
		clientRepository.save(state);
	}
	
	// get state by id
	public Optional<Client> findById(int id) {
		return clientRepository.findById(id);
	}
	
	// delete state
	public void deleteClient(int id) {
		clientRepository.deleteById(id);
	}
}
