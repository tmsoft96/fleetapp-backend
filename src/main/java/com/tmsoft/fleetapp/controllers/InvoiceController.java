package com.tmsoft.fleetapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tmsoft.fleetapp.models.Client;
import com.tmsoft.fleetapp.models.Invoice;
import com.tmsoft.fleetapp.models.InvoiceStatus;
import com.tmsoft.fleetapp.services.ClientService;
import com.tmsoft.fleetapp.services.InvoiceService;
import com.tmsoft.fleetapp.services.InvoiceStatusService;

@Controller
public class InvoiceController {
	
	@Autowired private InvoiceService invoiceService;
	@Autowired private ClientService clientService;
	@Autowired private InvoiceStatusService invoiceStatusService;

	@GetMapping("/invoices")
	public String getInvoices(Model model) {
		List<Invoice> invoiceList = invoiceService.getInvoices();
		List<Client> clientList = clientService.getClients();
		List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatuss();

		// passing data to the web page
		model.addAttribute("invoices", invoiceList);
		model.addAttribute("clients", clientList);
		model.addAttribute("invoicesStatus", invoiceStatusList);
		
		return "pages-invoice";
	}
	
	@PostMapping("/invoices/addNew")
	public String addNew(Invoice invoice) {
		invoiceService.saveInvoice(invoice);
		return "redirect:/invoices";
	}

	@GetMapping("/invoices/findById")
	@ResponseBody
	public Optional<Invoice> findById(int id) {
		return invoiceService.findById(id);
	}

	@RequestMapping(value = "/invoices/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Invoice invoice) {
		invoiceService.saveInvoice(invoice);
		return "redirect:/invoices";
	}

	@RequestMapping(value = "/invoices/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		invoiceService.deleteInvoice(id);
		return "redirect:/invoices";
	}
}
