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

import com.tmsoft.fleetapp.models.InvoiceStatus;
import com.tmsoft.fleetapp.services.InvoiceStatusService;

@Controller
public class InvoiceStatusController {
	
	@Autowired InvoiceStatusService invoiceStatusService;

	@GetMapping("/invoicestatus")
	public String getInvoiceStatus(Model model) {
		List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatuss();
		
		// passing data to the web page
		model.addAttribute("invoicesStatus", invoiceStatusList);
		
		return "pages-invoice-status";
	}
	
	@PostMapping("/invoicestatus/addNew")
	public String addNew(InvoiceStatus invoiceStatus) {
		invoiceStatusService.saveInvoiceStatus(invoiceStatus);
		return "redirect:/invoicestatus";
	}

	@GetMapping("/invoicestatus/findById")
	@ResponseBody
	public Optional<InvoiceStatus> findById(int id) {
		return invoiceStatusService.findById(id);
	}

	@RequestMapping(value = "/invoicestatus/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(InvoiceStatus invoiceStatus) {
		invoiceStatusService.saveInvoiceStatus(invoiceStatus);
		return "redirect:/invoicestatus";
	}

	@RequestMapping(value = "/invoicestatus/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		invoiceStatusService.deleteInvoiceStatus(id);
		return "redirect:/invoicestatus";
	}
}
