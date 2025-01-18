package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.ResponseStructure;
import com.example.demo.entity.Address;
import com.example.demo.entity.Person;
import com.example.demo.repository.AddressRepository;

@Repository
public class AddressDao {
	
	@Autowired
	private AddressRepository addressRepository;

	public List<Address> getAddressByPersonId(int id) {
		return addressRepository.findByPersonId(id);
	}

	public List<Address> getPersonByCity(String city) {
		
		return addressRepository.findByCity(city);
	}

	public List<Address> getPersonByDistrict(String district) {
		return addressRepository.findByDistrict(district);
	}

	public List<Address> getPersonByTaluka(String taluka) {
		return addressRepository.findByTaluka(taluka);
	}

	public List<Address> getPersonByPincode(int pincode) {
		return addressRepository.findByPincode(pincode);
	}

	public Address getAddressById(int id) {
		Optional<Address> opt = addressRepository.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}

}
