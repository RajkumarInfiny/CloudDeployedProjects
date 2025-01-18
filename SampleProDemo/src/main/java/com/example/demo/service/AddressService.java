package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AddressDao;
import com.example.demo.dto.ResponseStructure;
import com.example.demo.entity.Address;
import com.example.demo.entity.Person;

@Service
public class AddressService {

	@Autowired
	private AddressDao addressDao;

	public ResponseEntity<ResponseStructure<List<Address>>> getAddressByPersonId(int id) {
	   List<Address> addressList= addressDao.getAddressByPersonId(id);
	   ResponseStructure<List<Address>> structure = new ResponseStructure<List<Address>>();
	   if(addressList.size()>0) {
		   structure.setStatus(HttpStatus.FOUND.value());
		   structure.setMessage("Found");
		   structure.setData(addressList);
		   return new ResponseEntity<ResponseStructure<List<Address>>>(structure,HttpStatus.FOUND);
	   }else {
		   structure.setStatus(HttpStatus.NOT_FOUND.value());
		   structure.setMessage("Not Found");
		   structure.setData(addressList);
		   return new ResponseEntity<ResponseStructure<List<Address>>>(structure,HttpStatus.NOT_FOUND);
	   }
	}

	public ResponseEntity<ResponseStructure<Address>> getAddressById(int id) {

		ResponseStructure<Address> structure = new ResponseStructure<Address>();
		Address address = addressDao.getAddressById(id);
		if(address !=null) {
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Data Found");
			structure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.FOUND);
		}else {
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMessage("Data Not Found");
			structure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<List<Person>>> getPersonByCity(String city) {
		List<Address> addressList = addressDao.getPersonByCity(city);
		List<Person> personList = new ArrayList<Person>();
		ResponseStructure<List<Person>> structure = new ResponseStructure<List<Person>>();
		if (addressList.size() > 0) {
			for (Address address : addressList) {

				personList.add(address.getPerson());

			}
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Found");
			structure.setData(personList);
			return new ResponseEntity<ResponseStructure<List<Person>>>(structure, HttpStatus.FOUND);
		} else {
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMessage("Not Found");
			structure.setData(personList);
			return new ResponseEntity<ResponseStructure<List<Person>>>(structure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<List<Person>>> getPersonByDistrict(String district) {
		List<Address> addressList = addressDao.getPersonByDistrict(district);
		List<Person> personList = new ArrayList<Person>();
		ResponseStructure<List<Person>> structure = new ResponseStructure<List<Person>>();
		if (addressList.size() > 0) {
			for (Address address : addressList) {

				personList.add(address.getPerson());

			}
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Found");
			structure.setData(personList);
			return new ResponseEntity<ResponseStructure<List<Person>>>(structure, HttpStatus.FOUND);
		} else {
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMessage("Not Found");
			structure.setData(personList);
			return new ResponseEntity<ResponseStructure<List<Person>>>(structure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<List<Person>>> getPersonByTaluka(String taluka) {
		List<Address> addressList = addressDao.getPersonByTaluka(taluka);
		List<Person> personList = new ArrayList<Person>();
		ResponseStructure<List<Person>> structure = new ResponseStructure<List<Person>>();
		if (addressList.size() > 0) {
			for (Address address : addressList) {

				personList.add(address.getPerson());

			}
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Found");
			structure.setData(personList);
			return new ResponseEntity<ResponseStructure<List<Person>>>(structure, HttpStatus.FOUND);
		} else {
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMessage("Not Found");
			structure.setData(personList);
			return new ResponseEntity<ResponseStructure<List<Person>>>(structure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<List<Person>>> getPersonByPincode(int pincode) {
		List<Address> addressList = addressDao.getPersonByPincode(pincode);
		List<Person> personList = new ArrayList<Person>();
		ResponseStructure<List<Person>> structure = new ResponseStructure<List<Person>>();
		if (addressList.size() > 0) {
			for (Address address : addressList) {

				personList.add(address.getPerson());

			}
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Found");
			structure.setData(personList);
			return new ResponseEntity<ResponseStructure<List<Person>>>(structure, HttpStatus.FOUND);
		} else {
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMessage("Not Found");
			structure.setData(personList);
			return new ResponseEntity<ResponseStructure<List<Person>>>(structure, HttpStatus.NOT_FOUND);
		}
	}

}
