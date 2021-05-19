package com.isi.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.isi.dao.FormationRepository;
import com.isi.exception.ResourceNotFoundException;
import com.isi.model.Formation;

@Service
public class FormationService {
	 @Autowired
	    private FormationRepository repository;
	 
	 public Formation saveFormation(Formation Formation) {
	        return repository.save(Formation);
	    }
	 public List<Formation> getFormations() {
	        return repository.findAll();
	    }
	  public Formation getOrganismById(int id) {
	        return repository.findById((long) id).orElse(null);
	    }

	  public String deleteFormation(int id) {
	        repository.deleteById((long) id);
	        return "Formation removed !! " + id;
	    }
	/*  public Formation updateFormation(Formation Formation) {
	        Formation existingFormation = repository.findById((long) Formation.getId()).orElse(null);
	        existingFormation.setTitre(Formation.getTitre());
	        existingFormation.setType_formation(Formation.getType_formation());
	        existingFormation.setAnnee(Formation.getAnnee());
	        existingFormation.setSessionFormation(Formation.getSessionFormation());
	        existingFormation.setDuree(Formation.getDuree());
	        existingFormation.setBudget(Formation.getBudget());
	        existingFormation.setNb_session(Formation.getNb_session());
	        existingFormation.setDomaine(Formation.getDomaine());

	        return repository.save(existingFormation);
	    }*/
	  
	  public ResponseEntity<Formation> updateFormation(
	            @PathVariable(value = "id") long id,
	             @RequestBody Formation formationDetails) throws ResourceNotFoundException {
		  Formation existingFormation = repository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("formation introuvable avec le code = " + id));

		  existingFormation.setTitre(formationDetails.getTitre());
	        existingFormation.setDomaine(formationDetails.getDomaine());
	        existingFormation.setAnnee(formationDetails.getAnnee());
	        existingFormation.setType_formation(formationDetails.getType_formation());

	        existingFormation.setNb_session(formationDetails.getNb_session());
	        existingFormation.setDuree(formationDetails.getDuree());

	        existingFormation.setBudget(formationDetails.getBudget());
	        final Formation updatedFormation = repository.save(existingFormation);
	        return ResponseEntity.ok(updatedFormation);
	    }
}
