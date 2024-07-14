package com.tmsoft.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmsoft.fleetapp.models.InvoiceStatus;
import com.tmsoft.fleetapp.repositories.InvoiceStatusRepository;

@Service
public class InvoiceStatusService {

	@Autowired
	private InvoiceStatusRepository invoiceStatusRepository;
	
	//Return list of states
	public List<InvoiceStatus> getInvoiceStatuss() {
		return invoiceStatusRepository.findAll();
	}
	
	//Save new state
	public void saveInvoiceStatus(InvoiceStatus state) {
		invoiceStatusRepository.save(state);
	}
	
	// get state by id
	public Optional<InvoiceStatus> findById(int id) {
		return invoiceStatusRepository.findById(id);
	}
	
	// delete state
	public void deleteInvoiceStatus(int id) {
		invoiceStatusRepository.deleteById(id);
	}
}
