package com.isi.model;


import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="Domaine")
public class Domaine  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  
	@Column(name="id")
	private Long id;
	@Column(name="libelle")
	private String libelle;
	@OneToMany(mappedBy="domaine",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
	Set<Formation> formations =  new HashSet<>();
	
	public Domaine(Long id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
	public Domaine() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Domaine [id=" + id + ", libelle=" + libelle +"]";
	}
    
    
}