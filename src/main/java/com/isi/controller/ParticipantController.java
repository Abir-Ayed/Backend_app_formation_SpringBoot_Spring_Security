package com.isi.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isi.exception.ResourceNotFoundException;
import com.isi.model.Formateur;
import com.isi.model.Participant;
import com.isi.service.ParticipantService;


    

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4400")
public class ParticipantController {
	 @Autowired
	    private ParticipantService service;
	/*  @PostMapping("/participant")
	    public Participant addProduct(@RequestBody Participant Participant) {
	        return service.saveParticipant(Participant);
	    }*/
	 
	 @PostMapping("/participant")
		@PreAuthorize("hasRole('ROLE_ADMIN')")

	    public Participant addProduct(@RequestBody Participant Participant) {
	        return service.saveParticipant(Participant);
	    }
	  
	  @GetMapping("/participant")
		@PreAuthorize("hasRole('ROLE_ADMIN')")

	    public List<Participant> findAllProducts() {
	        return service.getParticipants();
	    }
	  @GetMapping("/participant/{id}")
		@PreAuthorize("hasRole('ROLE_ADMIN')")

	    public Participant findProductById(@PathVariable int id) {
	        return service.getOrganismById(id);
	    }
	  @DeleteMapping("/participant/{id}")
		@PreAuthorize("hasRole('ROLE_ADMIN')")

	    public String deleteProduct(@PathVariable int id) {
	        return service.deleteParticipant(id);
	    }
	 
	 

	  @PutMapping("/participant/{id}")
		@PreAuthorize("hasRole('ROLE_ADMIN')")

	    public ResponseEntity<Participant> updateProduct(@RequestBody Participant Participant,@PathVariable long id) throws ResourceNotFoundException {
	        return service.updateParticipant(Participant, id);
	    }


}
