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
import com.isi.model.Formation;
import com.isi.service.FormationService;


    

@RestController
@CrossOrigin(origins = "http://localhost:4400")

@RequestMapping("/api/v1")
public class FormationController {
	 @Autowired
	    private FormationService service;
	  @PostMapping("/Formation")
		@PreAuthorize("hasRole('ROLE_USER') ")

	    public Formation addProduct(@RequestBody Formation Formation) {
	        return service.saveFormation(Formation);
	    }
	  @GetMapping("/Formation")
		@PreAuthorize("hasRole('ROLE_USER') ")

	    public List<Formation> findAllProducts() {
	        return service.getFormations();
	    }
	  @GetMapping("/Formation/{id}")
		@PreAuthorize("hasRole('ROLE_USER') ")

	    public Formation findProductById(@PathVariable int id) {
	        return service.getOrganismById(id);
	    }
	  @DeleteMapping("/Formation/{id}")
		@PreAuthorize("hasRole('ROLE_USER') ")

	    public String deleteProduct(@PathVariable int id) {
	        return service.deleteFormation(id);
	    }
	  @PutMapping("/Formation/{id}")
		@PreAuthorize("hasRole('ROLE_USER') ")

	    public ResponseEntity<Formation> updateProduct(@RequestBody Formation Formation,@PathVariable long id) throws ResourceNotFoundException {
	        return service.updateFormation(id, Formation);
	    }


}
