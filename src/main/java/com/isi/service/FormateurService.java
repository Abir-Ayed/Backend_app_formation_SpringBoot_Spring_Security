package com.isi.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.isi.dao.FormateurRepository;
import com.isi.dao.OrganismeRepository;
import com.isi.exception.ResourceNotFoundException;
import com.isi.model.Formateur;





@Service
public class FormateurService {
	 @Autowired
	    private FormateurRepository repository;
	 @Autowired
	    private OrganismeRepository organismerepo;
	 
	/* public Formateur saveFormateur(Formateur Formateur) {
	        return repository.save(Formateur);
	    }*/
	/* public Formateur saveFormateur( Long Id,Formateur Formateur) {
		
		
		 Formateur formateur = new Formateur();
		 Organisme organisme = organismerepo.findById(Id).orElse(null);
		 
 formateur.setOrganismes(organisme);
 formateur.setNom(Formateur.getNom());
 formateur.setPrenom(Formateur.getPrenom());
 formateur.setEmail(Formateur.getEmail());
 formateur.setEmail(Formateur.getEmail());
 formateur.setTel(Formateur.getTel());
 formateur.setType(Formateur.getType());

	        return repository.save(  formateur);
	    }*/
	 
	 
	public Formateur saveFormateur(@Validated @RequestBody Formateur formateur) {
		    return repository.save(formateur);
		}
		
		
		/*@PutMapping("/affecterFormateur/{uid}/{pid}")
		public void affecterformateurOrganisme(@PathVariable("uid") Long Id,
				@PathVariable("pid") Long Idp) {

		    
		   
			   Formateur  Formateur = repository.findById(Id).get();
			   Organisme organisme =organismerepo.findById(Idp).get();
			  
			   
			   Formateur.setOrganismes(organisme);
			 
			
			   repository.save(Formateur);
			
		

		}*/
	 
	 
	 public List<Formateur> getFormateurs() {
	        return repository.findAll();
	    }
	  public Formateur getFormateurById(long id) {
	        return repository.findById((long) id).orElse(null);
	    }
	  public Formateur getOrganismById(int id) {
	        return repository.findById((long) id).orElse(null);
	    }

	  public String deleteFormateur(long id) {
	        repository.deleteById((long) id);
	        return "Formation removed !! " + id;
	    }
	/*  public Formateur updateFormateur(Formateur Formateur) {
		  Formateur existingFormateur = repository.findById((long) Formateur.getId()).orElse(null);
	        existingFormateur.setNom(Formateur.getNom());
	        existingFormateur.setPrenom(Formateur.getPrenom());
	        existingFormateur.setType(Formateur.getType());
	        existingFormateur.setTel(Formateur.getTel());
	        existingFormateur.setEmail(Formateur.getEmail());

	        existingFormateur.setOrganisme(Formateur.getOrganisme());


	        return repository.save(  existingFormateur);
	    }*/
	             public ResponseEntity<Formateur> updateFormateur(
	             @PathVariable(value = "id") long id,
	             @RequestBody Formateur formateurDetails) throws ResourceNotFoundException {
		         Formateur existingFormateur = repository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("profil introuvable avec le code = " + id));

		
		    existingFormateur.setNom(formateurDetails.getNom());
	        existingFormateur.setPrenom(formateurDetails.getPrenom());
	        existingFormateur.setEmail(formateurDetails.getEmail());
	        existingFormateur.setTel(formateurDetails.getTel());
		       
	        existingFormateur.setType(formateurDetails.getType());
	      

	        existingFormateur.setOrganisme(formateurDetails.getOrganisme());

	        final Formateur updatedFormateur = repository.save( existingFormateur);
	        return ResponseEntity.ok(updatedFormateur);
	    }
}
