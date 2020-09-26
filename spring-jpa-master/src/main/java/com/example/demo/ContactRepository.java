package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ContactRepository extends CrudRepository<Contact, Integer> {
	

	@Modifying 
    @Query(value = "DELETE FROM Contact WHERE email = :email",nativeQuery = true)
    int deleteByNameNative(@Param("email") String email); 

	@Query("select t from Contact t join t.places u where u.name = :name")
	List<Contact> findAllByUsername(@Param("name") String name);
	
}
