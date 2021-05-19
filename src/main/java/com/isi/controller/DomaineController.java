package com.isi.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
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

import com.isi.model.Domaine;
import com.isi.service.DomaineService;


    

@RestController
@CrossOrigin(origins = "http://localhost:4400")

@RequestMapping("/api/v1")
public class DomaineController {
	 @Autowired
	    private DomaineService service;
	  @PostMapping("/Domaines")
	//	@PreAuthorize("hasRole('ROLE_ADMIN')")

	    public Domaine addProduct(@RequestBody Domaine Domaine) {
	        return service.saveDomaine(Domaine);
	    }
	  @GetMapping("/Domaines")	
//	  @PreAuthorize("hasRole('ROLE_ADMIN')")

	    public List<Domaine> findAllProducts() {
	        return service.getDomaines();
	    }
	  @GetMapping("/Domaines/{id}")
	//	@PreAuthorize("hasRole('ROLE_ADMIN')")

	    public Domaine findProductById(@PathVariable long id) {
	        return service.getOrganismById(id);
	    }
	  @DeleteMapping("/Domaines/{id}")
	//	@PreAuthorize("hasRole('ROLE_ADMIN')")

	    public String deleteProduct(@PathVariable long id) {
	        return service.deleteDomaine(id);
	    }
	  @PutMapping("/Domaines")
	//	@PreAuthorize("hasRole('ROLE_ADMIN')")

	    public Domaine updateProduct(@RequestBody Domaine Domaine) {
	        return service.updateDomaine(Domaine);
	    }


}
