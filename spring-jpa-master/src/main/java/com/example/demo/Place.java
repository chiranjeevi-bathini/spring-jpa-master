package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
		
		@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	    @JoinTable(name = "contact_places",
	            joinColumns = {
	            		@JoinColumn(name = "id", referencedColumnName = "id",
	                            nullable = false, updatable = false)},
	            inverseJoinColumns = {
	                    @JoinColumn(name = "id", referencedColumnName = "id",
	                            nullable = false, updatable = false)})
	    private Set<Contact> contacts = new HashSet<>();

}
