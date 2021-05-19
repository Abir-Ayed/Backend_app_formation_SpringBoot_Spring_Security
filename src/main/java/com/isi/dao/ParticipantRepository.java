package com.isi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.isi.model.Participant;


@EnableJpaRepositories
public interface ParticipantRepository extends JpaRepository <Participant,Long>{

}
