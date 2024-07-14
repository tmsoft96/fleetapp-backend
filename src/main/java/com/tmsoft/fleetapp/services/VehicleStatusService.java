package com.tmsoft.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmsoft.fleetapp.models.VehicleStatus;
import com.tmsoft.fleetapp.repositories.VehicleStatusRepository;

@Service
public class VehicleStatusService {

	@Autowired
	private VehicleStatusRepository vehicleStatusRepository;
	
	//Return list of states
	public List<VehicleStatus> getVehicleStatus() {
		return vehicleStatusRepository.findAll();
	}
	
	//Save new state
	public void saveVehicleStatus(VehicleStatus state) {
		vehicleStatusRepository.save(state);
	}
	
	// get state by id
	public Optional<VehicleStatus> findById(int id) {
		return vehicleStatusRepository.findById(id);
	}
	
	// delete state
	public void deleteVehicleStatus(int id) {
		vehicleStatusRepository.deleteById(id);
	}
}
