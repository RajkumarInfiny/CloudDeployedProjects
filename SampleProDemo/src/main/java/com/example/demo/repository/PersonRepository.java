package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Person;

public interface PersonRepository extends JpaRepository<Person,Integer> {

	public List<Person> findByFirstName(String firstName);
	public List<Person> findByLastName(String lastName);
}
