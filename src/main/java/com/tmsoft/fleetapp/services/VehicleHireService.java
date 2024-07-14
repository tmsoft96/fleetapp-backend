package com.tmsoft.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmsoft.fleetapp.models.VehicleHire;
import com.tmsoft.fleetapp.repositories.VehicleHireRepository;

@Service
public class VehicleHireService {

	@Autowired
	private VehicleHireRepository vehicleHireRepository;
	
	//Return list of states
	public List<VehicleHire> getVehicleHires() {
		return vehicleHireRepository.findAll();
	}
	
	//Save new state
	public void saveVehicleHire(VehicleHire state) {
		vehicleHireRepository.save(state);
	}
	
	// get state by id
	public Optional<VehicleHire> findById(int id) {
		return vehicleHireRepository.findById(id);
	}
	
	// delete state
	public void deleteVehicleHire(int id) {
		vehicleHireRepository.deleteById(id);
	}
}
