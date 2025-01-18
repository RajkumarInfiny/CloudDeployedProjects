package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseStructure;
import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@PostMapping
	public Person savePerson(@RequestBody Person person) {
		return personService.savePerson(person);
	}

	@GetMapping("/all")
	public ResponseEntity<ResponseStructure<List<Person>>> getAllPerson() {
		return personService.getAllPerson();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Person>> getPersonById(@PathVariable int id) {
		return personService.getPersonById(id);
	}

	@GetMapping("/firstname/{firstname}")
	public ResponseEntity<ResponseStructure<List<Person>>> getPersonByFirstName(@PathVariable String firstname) {
		return personService.getPersonByFirstName(firstname);
	}
	
	@GetMapping("/lastname/{lastname}")
	public ResponseEntity<ResponseStructure<List<Person>>> getPersonByLastName(@PathVariable String lastname) {
		return personService.getPersonByLastName(lastname);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Person>> deletePersonById(@PathVariable int id) {
		return personService.deletePersonById(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Person>> updatePersonById(@RequestBody Person person) {
		return personService.updatePersonById(person);
	} 

	
}
