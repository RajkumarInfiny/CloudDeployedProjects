package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonDao;
import com.example.demo.dto.ResponseStructure;
import com.example.demo.entity.Person;

@Service
public class PersonService {

	@Autowired
	private PersonDao personDao;

	public Person savePerson(Person person) {
		
		return personDao.savePerson(person);
	}
	
	public ResponseEntity<ResponseStructure<List<Person>>> getAllPerson() {
		List<Person> personList = personDao.getAllPerson();
		ResponseStructure<List<Person>> structure = new ResponseStructure<List<Person>>();
		if (personList.size() > 0) {
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Data Found");
			structure.setData(personList);
			return new ResponseEntity<ResponseStructure<List<Person>>>(structure, HttpStatus.FOUND);
		} else {
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMessage("Data Not Found");
			structure.setData(personList);
			return new ResponseEntity<ResponseStructure<List<Person>>>(structure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<Person>> getPersonById(int id) {
		ResponseStructure<Person> structure = new ResponseStructure<Person>();
		Person person = personDao.getPersonById(id);
		if(person !=null) {
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Data Found");
			structure.setData(person);
			return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.FOUND);
		}else {
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMessage("Data Not Found");
			structure.setData(person);
			return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<List<Person>>> getPersonByFirstName(String firstName) {
		List<Person> personList = personDao.findByFirstName(firstName);
		ResponseStructure<List<Person>> structure = new ResponseStructure<List<Person>>();
		if (personList.size() > 0) {
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Data Found");
			structure.setData(personList);
			return new ResponseEntity<ResponseStructure<List<Person>>>(structure, HttpStatus.FOUND);
		} else {
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMessage("Data Not Found");
			structure.setData(personList);
			return new ResponseEntity<ResponseStructure<List<Person>>>(structure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<List<Person>>> getPersonByLastName(String lastname) {

		List<Person> personList = personDao.getPersonByLastName(lastname);
		ResponseStructure<List<Person>> structure = new ResponseStructure<List<Person>>();
		if (personList.size() > 0) {
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Data Found");
			structure.setData(personList);
			return new ResponseEntity<ResponseStructure<List<Person>>>(structure, HttpStatus.FOUND);
		} else {
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMessage("Data Not Found");
			structure.setData(personList);
			return new ResponseEntity<ResponseStructure<List<Person>>>(structure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<Person>> deletePersonById(int id) {
		Person person = personDao.deletePersonById(id);
		ResponseStructure<Person> structure = new ResponseStructure<Person>();
		if (person != null) {
			structure.setStatus(HttpStatus.ACCEPTED.value());
			structure.setMessage("DELETED");
			structure.setData(person);
			return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.ACCEPTED);
		} else {
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMessage("NOT FOUND");
			structure.setData(person);
			return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<Person>> updatePersonById(Person person) {
		Person updatedPerson = personDao.updatePersonById(person);
		ResponseStructure<Person> structure = new ResponseStructure<Person>();
		if (updatedPerson != null) {
			structure.setStatus(HttpStatus.ACCEPTED.value());
			structure.setMessage("UPDATED");
			structure.setData(updatedPerson);
			return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.ACCEPTED);
		} else {
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMessage("ID NOT FOUND");
			structure.setData(updatedPerson);
			return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.NOT_FOUND);
		}
	}



	

}
