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
import com.isi.model.Profil;
import com.isi.service.ProfilService;


    

@RestController
@CrossOrigin(origins = "http://localhost:4400")

@RequestMapping("/api/v1")
public class ProfilController {
	 @Autowired
	    private ProfilService service;
	  @PostMapping("/Profils")
		@PreAuthorize("hasRole('ROLE_ADMIN')")
	    public Profil addProduct(@RequestBody Profil Profil) {
	        return service.saveProfil(Profil);
	    }
	  @GetMapping("/Profils")
		@PreAuthorize("hasRole('ROLE_ADMIN')")
	    public List<Profil> findAllProfils() {
	        return service.getProfils();
	    }
	  @GetMapping("/Profils/{id}")
		@PreAuthorize("hasRole('ROLE_ADMIN')")
	    public Profil findProfilById(@PathVariable long id) {
	        return service.getProfilById(id);
	    }
	  @DeleteMapping("/Profils/{id}")
		@PreAuthorize("hasRole('ROLE_ADMIN')")
	    public String deleteProfil(@PathVariable long id) {
	        return service.deleteProfil(id);
	    }
	  @PutMapping("/Profils/{id}")
		@PreAuthorize("hasRole('ROLE_ADMIN')")
	 //   public Profil updateProfil(@RequestBody Profil Profil) {
	     //   return service.updateProfil(Profil);
	        public ResponseEntity<Profil> updateProfil(@RequestBody Profil profil,@PathVariable long id) throws ResourceNotFoundException {
		        return service.updateProfil(id, profil);
	    }


}
