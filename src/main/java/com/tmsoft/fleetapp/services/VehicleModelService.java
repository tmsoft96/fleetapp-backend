package com.tmsoft.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmsoft.fleetapp.models.VehicleModel;
import com.tmsoft.fleetapp.repositories.VehicleModelRepository;

@Service
public class VehicleModelService {

	@Autowired
	private VehicleModelRepository vehicleModelRepository;
	
	//Return list of states
	public List<VehicleModel> getVehicleModels() {
		return vehicleModelRepository.findAll();
	}
	
	//Save new state
	public void saveVehicleModel(VehicleModel state) {
		vehicleModelRepository.save(state);
	}
	
	// get state by id
	public Optional<VehicleModel> findById(int id) {
		return vehicleModelRepository.findById(id);
	}
	
	// delete state
	public void deleteVehicleModel(int id) {
		vehicleModelRepository.deleteById(id);
	}
}
