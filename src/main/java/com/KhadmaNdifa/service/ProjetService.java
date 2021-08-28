package com.KhadmaNdifa.service;

import java.util.List;
import java.util.Optional;

import com.KhadmaNdifa.entites.DemandeRealisation;
import com.KhadmaNdifa.entites.Projet;

public interface ProjetService {
	
	List<Projet> getProjetByUser(long id);
	List<Projet> findAllProjects();
	List<Projet> finByEmploiyeur(long id);
	List<Projet> finByEmploiye(long id);
	Projet save(Projet proj);
	Optional<Projet> findById(long id);
	DemandeRealisation saveDemandeRealisation(DemandeRealisation demande);
	Optional<DemandeRealisation> findDEmandeRealisationById(long id);
}
