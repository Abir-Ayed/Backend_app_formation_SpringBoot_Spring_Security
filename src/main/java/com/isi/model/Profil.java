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

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Entity
@Data
@Table(name = "profils")
public class Profil {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  
	@Column(name = "idProfil")
	private Long id;
	private String libelle;
	@OneToMany(mappedBy="profils",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore

	Set<Participant> participant =  new HashSet<>();
	public Profil() {
		super();
		// TODO Auto-generated constructor stub
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
	public Set<Participant> getParticipant() {
		return participant;
	}
	public void setParticipant(Set<Participant> participant) {
		this.participant = participant;
	}
	public Profil(String libelle) {
		super();
		this.libelle = libelle;
	}
}
