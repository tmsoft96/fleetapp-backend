package com.tmsoft.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmsoft.fleetapp.models.Location;
import com.tmsoft.fleetapp.repositories.LocationRepository;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;
	
	//Return list of states
	public List<Location> getLocations() {
		return locationRepository.findAll();
	}
	
	//Save new state
	public void saveLocation(Location state) {
		locationRepository.save(state);
	}
	
	// get state by id
	public Optional<Location> findById(int id) {
		return locationRepository.findById(id);
	}
	
	// delete state
	public void deleteLocation(int id) {
		locationRepository.deleteById(id);
	}
}
