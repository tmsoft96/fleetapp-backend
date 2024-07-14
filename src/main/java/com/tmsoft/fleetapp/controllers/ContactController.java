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

import com.tmsoft.fleetapp.models.Contact;
import com.tmsoft.fleetapp.services.ContactService;

@Controller
public class ContactController {

	@Autowired
	ContactService contactService;

	@GetMapping("/contacts")
	public String getContacts(Model model) {
		List<Contact> contactList = contactService.getContacts();

		// passing data to the web page
		model.addAttribute("contacts", contactList);

		return "pages-contact";
	}

	@PostMapping("/contacts/addNew")
	public String addNew(Contact contact) {
		contactService.saveContact(contact);
		return "redirect:/contacts";
	}

	@GetMapping("/contacts/findById")
	@ResponseBody
	public Optional<Contact> findById(int id) {
		return contactService.findById(id);
	}

	@RequestMapping(value = "/contacts/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Contact contact) {
		contactService.saveContact(contact);
		return "redirect:/contacts";
	}

	@RequestMapping(value = "/contacts/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		contactService.deleteContact(id);
		return "redirect:/contacts";
	}
}
