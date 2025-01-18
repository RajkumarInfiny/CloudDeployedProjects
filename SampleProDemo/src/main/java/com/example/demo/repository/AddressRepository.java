package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Address;
import com.example.demo.entity.Person;

public interface AddressRepository extends JpaRepository<Address,Integer> {

	public List<Address> findByPersonId(int id);

	public List<Address> findByCity(String city);

	public List<Address> findByDistrict(String district);

	public List<Address> findByTaluka(String taluka);

	public List<Address> findByPincode(int pincode);
	
//	@Query("select a from Address a where a.Person.id =:id")
//	public Person findAddressByPersonId();
}
