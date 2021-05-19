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

import com.isi.model.Pays;
import com.isi.service.PaysService;


    

@RestController
@CrossOrigin(origins = "http://localhost:4400")

@RequestMapping("/api/v1")
public class PaysController {
	 @Autowired
	    private PaysService service;
	  @PostMapping("/Pays")
		@PreAuthorize("hasRole('ROLE_ADMIN')")

	    public Pays addProduct(@RequestBody Pays Pays) {
	        return service.savePays(Pays);
	    }
	  @GetMapping("/Pays")
		@PreAuthorize("hasRole('ROLE_ADMIN')")

	    public List<Pays> findAllProducts() {
	        return service.getPayss();
	    }
	  @GetMapping("/Pays/{id}")
		@PreAuthorize("hasRole('ROLE_ADMIN')")

	    public Pays findProductById(@PathVariable long id) {
	        return service.getPaysById(id);
	    }
	  @DeleteMapping("/Pays/{id}")
		@PreAuthorize("hasRole('ROLE_ADMIN')")

	    public String deleteProduct(@PathVariable long id) {
	        return service.deletePays(id);
	    }
	  @PutMapping("/updatePays")
		@PreAuthorize("hasRole('ROLE_ADMIN')")

	    public Pays updateProduct(@RequestBody Pays Pays) {
	        return service.updatePays(Pays);
	    }


}
