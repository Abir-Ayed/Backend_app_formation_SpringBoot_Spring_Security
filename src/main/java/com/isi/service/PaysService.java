package com.isi.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.isi.dao.PaysRepository;
import com.isi.model.Pays;




@Service
public class PaysService {
	 @Autowired
	    private PaysRepository repository;
	 
	 
	 public Pays savePays(Pays Pays) {
	        return repository.save(Pays);
	    }
	 public List<Pays> getPayss() {
	        return repository.findAll();
	    }
	  public Pays getPaysById(long id) {
	        return repository.findById((long) id).orElse(null);
	    }

	  public String deletePays(long id) {
	       repository.deleteById((long) id);
	        return "Pays removed !! " + id;
		 
			  

			   
	    
	  }
	  public Pays updatePays(Pays Pays) {
	        Pays existingPays = repository.findById((long) Pays.getId()).orElse(null);
	        existingPays.setNom(Pays.getNom());
	        

	        return repository.save(existingPays);
	    }
}
