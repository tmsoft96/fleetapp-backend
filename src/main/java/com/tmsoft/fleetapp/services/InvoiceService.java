package com.tmsoft.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmsoft.fleetapp.models.Invoice;
import com.tmsoft.fleetapp.repositories.InvoiceRepository;

@Service
public class InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;
	
	//Return list of invoices
	public List<Invoice> getInvoices() {
		return invoiceRepository.findAll();
	}
	
	//Save new invoice
	public void saveInvoice(Invoice invoice) {
		invoiceRepository.save(invoice);
	}
	
	// get invoice by id
	public Optional<Invoice> findById(int id) {
		return invoiceRepository.findById(id);
	}
	
	// delete invoice
	public void deleteInvoice(int id) {
		invoiceRepository.deleteById(id);
	}
}
