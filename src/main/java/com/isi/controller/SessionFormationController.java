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
import com.isi.model.Session_de_formation;
import com.isi.service.SessionFormationService;


    

@RestController
@CrossOrigin(origins = "http://localhost:4400")

@RequestMapping("/api/v1")
public class SessionFormationController {
	 @Autowired
	    private SessionFormationService service;
	  @PostMapping("/SessionFormation")
	//	@PreAuthorize("hasRole('ROLE_USER') ")

	    public Session_de_formation addProduct(@RequestBody Session_de_formation SessionFormation) {
	        return service.saveSessionFormation(SessionFormation);
	    }
	  @GetMapping("/SessionFormation")
		//@PreAuthorize("hasRole('ROLE_USER') ")

	    public List<Session_de_formation> findAllProducts() {
	        return service.getSessionFormations();
	    }
	  @GetMapping("/SessionFormation/{id}")
		//@PreAuthorize("hasRole('ROLE_USER') ")

	    public Session_de_formation findProductById(@PathVariable int id) {
	        return service.getOrganismById(id);
	    }
	  @DeleteMapping("/SessionFormation/{id}")
	//	@PreAuthorize("hasRole('ROLE_USER') ")

	    public String deleteProduct(@PathVariable int id) {
	        return service.deleteSessionFormation(id);
	    }
	  @PutMapping("/SessionFormation/{id}")
		//@PreAuthorize("hasRole('ROLE_USER') ")

	    public ResponseEntity<Session_de_formation> updateProduct(@RequestBody Session_de_formation SessionFormation,@PathVariable long id) throws ResourceNotFoundException {
	        return service.updateSession(id, SessionFormation);


}
}
