package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;

@Repository
public class PersonDao {

	@Autowired
	private PersonRepository personRepository;

	public Person savePerson(Person person) {

		return personRepository.save(person);
	}

	public List<Person> getAllPerson() {
		return personRepository.findAll();

	}

	public Person getPersonById(int id) {
		Optional<Person> opt = personRepository.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}

	public List<Person> findByFirstName(String firstName) {
		return personRepository.findByFirstName(firstName);

	}

	public List<Person> getPersonByLastName(String lastname) {

		return personRepository.findByLastName(lastname);

	}

	public Person deletePersonById(int id) {
		Optional<Person> optional = personRepository.findById(id);
		if(optional.isPresent()) {
			Person person = optional.get();
			personRepository.delete(person);
			return person;
		}else {
			return null;
		}
	}

	public Person updatePersonById(Person person) {
		Optional<Person> optional = personRepository.findById(person.getId());
		if(optional.isPresent()) {
			personRepository.save(person);
			return person;
		}else {
			return null;
		}
	}

}
