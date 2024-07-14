package com.tmsoft.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmsoft.fleetapp.models.Contact;
import com.tmsoft.fleetapp.repositories.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	//Return list of states
	public List<Contact> getContacts() {
		return contactRepository.findAll();
	}
	
	//Save new state
	public void saveContact(Contact state) {
		contactRepository.save(state);
	}
	
	// get state by id
	public Optional<Contact> findById(int id) {
		return contactRepository.findById(id);
	}
	
	// delete state
	public void deleteContact(int id) {
		contactRepository.deleteById(id);
	}
}
