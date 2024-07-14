package com.tmsoft.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmsoft.fleetapp.models.Supplier;
import com.tmsoft.fleetapp.repositories.SupplierRepository;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;
	
	//Return list of suppliers
	public List<Supplier> getSuppliers() {
		return supplierRepository.findAll();
	}
	
	//Save new supplier
	public void saveSupplier(Supplier supplier) {
		supplierRepository.save(supplier);
	}
	
	// get supplier by id
	public Optional<Supplier> findById(int id) {
		return supplierRepository.findById(id);
	}
	
	// delete supplier
	public void deleteSupplier(int id) {
		supplierRepository.deleteById(id);
	}
}
