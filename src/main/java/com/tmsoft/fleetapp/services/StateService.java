package com.tmsoft.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmsoft.fleetapp.models.State;
import com.tmsoft.fleetapp.repositories.StateRepository;

@Service
public class StateService {

	@Autowired
	private StateRepository stateRepository;
	
	//Return list of states
	public List<State> getStates() {
		return stateRepository.findAll();
	}
	
	//Save new state
	public void saveState(State state) {
		stateRepository.save(state);
	}
	
	// get state by id
	public Optional<State> findById(int id) {
		return stateRepository.findById(id);
	}
	
	// delete state
	public void deleteState(int id) {
		stateRepository.deleteById(id);
	}
}
