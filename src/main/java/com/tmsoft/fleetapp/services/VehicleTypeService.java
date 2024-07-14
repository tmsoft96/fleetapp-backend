package com.tmsoft.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmsoft.fleetapp.models.VehicleType;
import com.tmsoft.fleetapp.repositories.VehicleTypeRepository;

@Service
public class VehicleTypeService {

	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;
	
	//Return list of states
	public List<VehicleType> getVehicleTypes() {
		return vehicleTypeRepository.findAll();
	}
	
	//Save new state
	public void saveVehicleType(VehicleType state) {
		vehicleTypeRepository.save(state);
	}
	
	// get state by id
	public Optional<VehicleType> findById(int id) {
		return vehicleTypeRepository.findById(id);
	}
	
	// delete state
	public void deleteVehicleType(int id) {
		vehicleTypeRepository.deleteById(id);
	}
}
