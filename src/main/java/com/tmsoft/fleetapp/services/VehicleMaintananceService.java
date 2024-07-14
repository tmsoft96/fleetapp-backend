package com.tmsoft.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmsoft.fleetapp.models.VehicleMaintanance;
import com.tmsoft.fleetapp.repositories.VehicleMaintananceRepository;

@Service
public class VehicleMaintananceService {

	@Autowired
	private VehicleMaintananceRepository vehicleMaintananceRepository;
	
	//Return list of states
	public List<VehicleMaintanance> getVehicleMaintanances() {
		return vehicleMaintananceRepository.findAll();
	}
	
	//Save new state
	public void saveVehicleMaintanance(VehicleMaintanance state) {
		vehicleMaintananceRepository.save(state);
	}
	
	// get state by id
	public Optional<VehicleMaintanance> findById(int id) {
		return vehicleMaintananceRepository.findById(id);
	}
	
	// delete state
	public void deleteVehicleMaintanance(int id) {
		vehicleMaintananceRepository.deleteById(id);
	}
}
