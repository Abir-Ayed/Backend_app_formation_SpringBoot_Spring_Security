package com.isi.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isi.dao.DomaineRepository;
import com.isi.model.Domaine;


@Service
public class DomaineService {
	 @Autowired
	    private DomaineRepository repository;
	 
	 public Domaine saveDomaine(Domaine Domaine) {
	        return repository.save(Domaine);
	    }
	 public List<Domaine> getDomaines() {
	        return repository.findAll();
	    }
	  public Domaine getOrganismById(long id) {
	        return repository.findById((long) id).orElse(null);
	    }

	  public String deleteDomaine(long id) {
	        repository.deleteById((long) id);
	        return "Domaine removed !! " + id;
	    }
	  public Domaine updateDomaine(Domaine Domaine) {
	        Domaine existingDomaine = repository.findById((long) Domaine.getId()).orElse(null);
	        existingDomaine.setLibelle(Domaine.getLibelle());
	       
	        return repository.save(existingDomaine);
	    }
}
