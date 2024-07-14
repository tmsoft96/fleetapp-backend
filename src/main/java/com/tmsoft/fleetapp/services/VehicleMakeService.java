package com.tmsoft.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmsoft.fleetapp.models.VehicleMake;
import com.tmsoft.fleetapp.repositories.VehicleMakeRepository;

@Service
public class VehicleMakeService {

	@Autowired
	private VehicleMakeRepository vehicleMakeRepository;
	
	//Return list of states
	public List<VehicleMake> getVehicleMakes() {
		return vehicleMakeRepository.findAll();
	}
	
	//Save new state
	public void saveVehicleMake(VehicleMake state) {
		vehicleMakeRepository.save(state);
	}
	
	// get state by id
	public Optional<VehicleMake> findById(int id) {
		return vehicleMakeRepository.findById(id);
	}
	
	// delete state
	public void deleteVehicleMake(int id) {
		vehicleMakeRepository.deleteById(id);
	}
}
