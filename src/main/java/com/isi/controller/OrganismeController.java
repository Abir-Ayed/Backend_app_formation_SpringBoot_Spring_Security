package com.isi.controller;

import java.util.List;

import java.util.Set;

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

import com.isi.model.Formateur;
import com.isi.model.Organisme;
import com.isi.service.OrganismeService;




@CrossOrigin(origins = "http://localhost:4400")
    

@RestController
@RequestMapping("/api/v1")
public class OrganismeController {
	 @Autowired
	    private OrganismeService service;
	  @PostMapping("/Organisme")
		@PreAuthorize("hasRole('ROLE_ADMIN')")

	    public Organisme addProduct(@RequestBody Organisme Organisme) {
	        return service.saveOrganisme(Organisme);
	    }
	  @GetMapping("/Organisme")
		@PreAuthorize("hasRole('ROLE_ADMIN')")

	    public List<Organisme> findAllOrganismes() {
	        return service.getOrganismes();
	    }
	  @GetMapping("/Organisme/{id}")
		@PreAuthorize("hasRole('ROLE_ADMIN')")

	    public Organisme findProductById(@PathVariable long id) {
	        return service.getOrganismById(id);
	    }
	  @DeleteMapping("/Organisme/{id}")
		@PreAuthorize("hasRole('ROLE_ADMIN')")

	    public String deleteProduct(@PathVariable long id) {
	        return service.deleteOrganisme(id);
	    }
	  @PutMapping("/Organisme")
		@PreAuthorize("hasRole('ROLE_ADMIN')")

	    public Organisme updateProduct(@RequestBody Organisme Organisme) {
	        return service.updateOrganisme(Organisme);
	    }

	  @GetMapping("/Formateur/{id}")
		@PreAuthorize("hasRole('ROLE_ADMIN')")

		public Set<Formateur> getFormateurs(@PathVariable long id)
		{
			return service.getFormateurOrganisme(id);
		}
	
}
