package com.tmsoft.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmsoft.fleetapp.models.UserRole;
import com.tmsoft.fleetapp.repositories.UserRoleRepository;


@Service
public class UserRoleService {

	@Autowired
	private UserRoleRepository userRoleRepository;
	
	//Return list of user roles
	public List<UserRole> getRoles() {
		return userRoleRepository.findAll();
	}
	
	//Save new roles
	public void saveRole(UserRole role) {
		userRoleRepository.save(role);
	}
	
	// get role by id
	public Optional<UserRole> findById(int id) {
		return userRoleRepository.findById(id);
	}
	
	// delete role
	public void deleteVehicleHire(int id) {
		userRoleRepository.deleteById(id);
	}
}
