package com.tmsoft.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmsoft.fleetapp.models.Vehicle;
import com.tmsoft.fleetapp.repositories.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	//Return list of states
	public List<Vehicle> getVehicles() {
		return vehicleRepository.findAll();
	}
	
	//Save new state
	public void saveVehicle(Vehicle state) {
		vehicleRepository.save(state);
	}
	
	// get state by id
	public Optional<Vehicle> findById(int id) {
		return vehicleRepository.findById(id);
	}
	
	// delete state
	public void deleteVehicle(int id) {
		vehicleRepository.deleteById(id);
	}
}
