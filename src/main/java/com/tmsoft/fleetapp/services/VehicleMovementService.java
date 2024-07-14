package com.tmsoft.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmsoft.fleetapp.models.VehicleMovement;
import com.tmsoft.fleetapp.repositories.VehicleMovementRepository;

@Service
public class VehicleMovementService {

	@Autowired
	private VehicleMovementRepository vehicleMovementRepository;

	// Return list of states
	public List<VehicleMovement> getVehicleMovements() {
		return vehicleMovementRepository.findAll();
	}

	// Save new state
	public void saveVehicleMovement(VehicleMovement state) {
		vehicleMovementRepository.save(state);
	}

	// get state by id
	public Optional<VehicleMovement> findById(int id) {
		return vehicleMovementRepository.findById(id);
	}

	// delete state
	public void deleteVehicleMovement(int id) {
		vehicleMovementRepository.deleteById(id);
	}
}
