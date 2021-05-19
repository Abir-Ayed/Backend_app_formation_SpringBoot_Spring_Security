package com.isi.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
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
import com.isi.service.FormateurService;





@RestController
@CrossOrigin(origins = "http://localhost:4400")
@RequestMapping("/api/v1")
public class FormateurController {
	 @Autowired
	    private FormateurService service;
	  @PostMapping("/Formateurs")
		@PreAuthorize("hasRole('ROLE_ADMIN')")

	    public Formateur addProduct(@RequestBody Formateur Formateur) {
	        return service.saveFormateur(Formateur);
	    }
	  @GetMapping("/Formateurs")
		@PreAuthorize("hasRole('ROLE_ADMIN')")

	    public List<Formateur> findAllProducts() {
	        return service.getFormateurs();
	    }
	  @GetMapping("/Formateurs/{id}")
		@PreAuthorize("hasRole('ROLE_ADMIN')")

	    public Formateur findProductById(@PathVariable int id) {
	        return service.getOrganismById(id);
	    }
	  @DeleteMapping("/Formateurs/{id}")
		@PreAuthorize("hasRole('ROLE_ADMIN')")

	    public String deleteProduct(@PathVariable int id) {
	        return service.deleteFormateur(id);
	    }
	  @PutMapping("/Formateurs/{id}")
		@PreAuthorize("hasRole('ROLE_ADMIN')")

	    public ResponseEntity<Formateur> updateProduct(@RequestBody Formateur Formateur,@PathVariable long id) throws ResourceNotFoundException {
	        return service.updateFormateur(id, Formateur);
	    }
}
