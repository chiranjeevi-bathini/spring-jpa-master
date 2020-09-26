package com.example.demo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ContactRepository extends CrudRepository<Contact, Integer> {
	

	@Modifying 
    @Query(value = "DELETE FROM Contact WHERE email = :email",nativeQuery = true)
    int deleteByNameNative(@Param("email") String email); 
	
	@Query("from Contact a join a.name a where a.name=:name")
	public Iterable<Contact> findByCategory(@Param("name") String name);

}
