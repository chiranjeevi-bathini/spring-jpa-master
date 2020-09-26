package com.example.demo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Place {

     	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Integer id;
     	 
     	 
     	 

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}
		public String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		@ManyToMany(targetEntity = Contact.class,cascade = CascadeType.ALL )
		
		    private List<Contact> contacts;

}
