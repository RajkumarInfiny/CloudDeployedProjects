package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseStructure;
import com.example.demo.entity.Address;
import com.example.demo.entity.Person;
import com.example.demo.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@GetMapping("/person/{id}")
	public ResponseEntity<ResponseStructure<List<Address>>> getAddressByPersonId(@PathVariable int id){
		return addressService.getAddressByPersonId(id);
	}
    @GetMapping("/{id}")
    public ResponseEntity<ResponseStructure<Address>> getAddressById(@PathVariable int id){
    	return addressService.getAddressById(id);
    }
	@GetMapping("/city/{city}")
	public ResponseEntity<ResponseStructure<List<Person>>> getPersonByCity(@PathVariable String city){
		return addressService.getPersonByCity(city);
	}
	
	@GetMapping("/district/{district}")
	public ResponseEntity<ResponseStructure<List<Person>>> getPersonByDistrict(@PathVariable String district){
		return addressService.getPersonByDistrict(district);
	}
	
	@GetMapping("/taluka/{taluka}")
	public ResponseEntity<ResponseStructure<List<Person>>> getPersonByTaluka(@PathVariable String taluka){
		return addressService.getPersonByTaluka(taluka);
	}
	
	@GetMapping("/pincode/{pincode}")
	public ResponseEntity<ResponseStructure<List<Person>>> getPersonByPincode(@PathVariable int pincode){
		return addressService.getPersonByPincode(pincode);
	} 
}
