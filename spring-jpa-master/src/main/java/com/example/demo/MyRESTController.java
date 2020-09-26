package com.example.demo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRESTController {

	@Autowired
	ContactRepository repository;

	@GetMapping("/contacts")
	public Iterable<Contact> getContacts() {
		return repository.findAll();
	}

	
	@PostMapping("/addcontact")
	public Contact createEmployee(@Valid @RequestBody Contact contact) {
        return repository.save(contact);
    }


	@DeleteMapping("/contacts/{email}")
    public ResponseEntity deleteEmployee(@Param("email") String email){
		
		repository.deleteByNameNative(email);
        return  ResponseEntity.ok("deleted");
    }

	@GetMapping("/contact/{name}")
    public ResponseEntity<List<Contact>> getEmployeeById(@PathVariable(value = "name") String name)
    {
        List<Contact>contacts =  repository.
            
        return ResponseEntity.ok().body(contacts);
    }

}
