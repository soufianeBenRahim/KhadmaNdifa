package com.KhadmaNdifa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KhadmaNdifa.dao.DemandeRealisationRepository;
import com.KhadmaNdifa.dao.ProjetsRepositry;
import com.KhadmaNdifa.entites.DemandeRealisation;
import com.KhadmaNdifa.entites.Projet;
@Service
public class ProjetServiceImpl implements ProjetService {
	@Autowired
	DemandeRealisationRepository demanderealisationRepository;
	@Autowired
	ProjetsRepositry projetRepository;
	
	@Override
	public List<Projet> getProjetByUser(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Projet> findAllProjects() {
		// TODO Auto-generated method stub
		return projetRepository.findAll();
	}

	@Override
	public List<Projet> finByEmploiyeur(long id) {
		// TODO Auto-generated method stub
		return projetRepository.finByEmploiyeur(id);
	}

	@Override
	public List<Projet> finByEmploiye(long id) {
		// TODO Auto-generated method stub
		return projetRepository.finByEmploiye(id);
	}

	@Override
	public Projet save(Projet proj) {
		// TODO Auto-generated method stub
		return projetRepository.save(proj);
	}

	@Override
	public Optional<Projet> findById(long id) {
		// TODO Auto-generated method stub
		return projetRepository.findById(id);
	}

	@Override
	public DemandeRealisation saveDemandeRealisation(DemandeRealisation demande) {
		// TODO Auto-generated method stub
		return demanderealisationRepository.save(demande);
	}

	@Override
	public Optional<DemandeRealisation> findDEmandeRealisationById(long id) {
		// TODO Auto-generated method stub
		return demanderealisationRepository.findById(id);
	}

}
