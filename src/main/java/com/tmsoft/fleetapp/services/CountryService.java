package com.tmsoft.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmsoft.fleetapp.models.Country;
import com.tmsoft.fleetapp.repositories.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;
	
	//Return list of countries
	public List<Country> getCountries() {
		return countryRepository.findAll();
	}
	
	//Save new country
	public void saveCountry(Country country) {
		countryRepository.save(country);
	}
	
	// get country by id
	public Optional<Country> findById(int id) {
		return countryRepository.findById(id);
	}
	
	// delete country
	public void deleteCountry(int id) {
		countryRepository.deleteById(id);
	}
}
