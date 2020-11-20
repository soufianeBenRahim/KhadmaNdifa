package com.KhadmaNdifa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.KhadmaNdifa.entites.Projet;

@Repository
public interface ProjetsRepositry extends JpaRepository<Projet, Long> {
	@Query("select p from Projet p where p.emploiyeur.id= ?1")
	public List<Projet> finByEmploiyeur(long id);

	@Query("select p from Projet p where p.acceptedDemande.demandeur.id= ?1")
	public List<Projet> finByEmploiye(long id);
}