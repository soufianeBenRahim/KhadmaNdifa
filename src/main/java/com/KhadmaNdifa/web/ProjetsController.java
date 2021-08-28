package com.KhadmaNdifa.web;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.KhadmaNdifa.dao.CVsRepository;
import com.KhadmaNdifa.dao.DemandeRealisationRepository;
import com.KhadmaNdifa.dao.ProjetsRepositry;
import com.KhadmaNdifa.entites.AppUser;
import com.KhadmaNdifa.entites.CV;
import com.KhadmaNdifa.entites.DemandeRealisation;
import com.KhadmaNdifa.entites.Projet;
import com.KhadmaNdifa.service.AccountServiceImpl;
import com.KhadmaNdifa.service.ProjetService;
import com.KhedmaNdifa.ParentEntities.EtatProjet;
import com.KhedmaNdifa.ParentEntities.TypeUser;

@RestController
public class ProjetsController {
	@Autowired
	ProjetService projetService;
	@Autowired
	AccountServiceImpl accountservice;
	

	@Autowired
	com.KhadmaNdifa.service.CVService CVService ;
	
	@GetMapping("/projets")
	public ResponseEntity<List<Projet>> getAllProjet() {
		List<Projet> projs = projetService.findAllProjects();

		if (!CollectionUtils.isEmpty(projs)) {
			return new ResponseEntity<List<Projet>>(projs, HttpStatus.OK);
		}
		return new ResponseEntity<List<Projet>>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/getprojectsuser")
	public ResponseEntity<List<Projet>> getProjectsUser(@RequestParam(name = "id") long id) {
		AppUser user = accountservice.GetUserByID(id);
		List<Projet> projets = null;
		if (user != null && user.getTypeuser() == TypeUser.EUR) {
			projets = projetService.finByEmploiyeur(id);
		} else {
			projets = projetService.finByEmploiye(id);
		}
		if (projets != null) {
			return new ResponseEntity<List<Projet>>(projets, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Projet>>(HttpStatus.NO_CONTENT);
		}

	}

	@PostMapping("/addprojet")

	public ResponseEntity<Projet> addprojet(@RequestBody Projet proj, @RequestParam long iduser) {
		AppUser user = accountservice.GetUserByID(iduser);
		if (user != null) {
			proj.setCreatedAt(new Date());
			proj.setDatePostilation(new Date());
			proj.setEmploiyeur(user);
			proj.setEtat(EtatProjet.LANCEMMENT);
			proj.setPourcentage(0);
			proj.setBudjet(proj.getBudjet());
			Projet p = projetService.save(proj);

			if (p != null) {

				return new ResponseEntity<Projet>(p, HttpStatus.CREATED);
			}
			return new ResponseEntity<Projet>(HttpStatus.NOT_MODIFIED);
		} else {
			return new ResponseEntity<Projet>(HttpStatus.NOT_MODIFIED);
		}

	}

	@PutMapping("/updateProjet")
	public ResponseEntity<Projet> updateProjet(@RequestBody Projet proj) {

		long id = proj.getId();
		Optional<Projet> pp = projetService.findById(proj.getId());
		if (pp.isEmpty()) {
			return new ResponseEntity<Projet>(HttpStatus.NOT_FOUND);
		} else {
			Projet projet = pp.get();
			projet.setUpdatedAt(new Date());
			projet.setDescription(proj.getDescription());
			projet.setDetail(proj.getDetail());
			projet.setBudjet(proj.getBudjet());
			projet = projetService.save(projet);

			if (projet != null) {

				return new ResponseEntity<Projet>(projet, HttpStatus.CREATED);
			}
			return new ResponseEntity<Projet>(HttpStatus.NOT_MODIFIED);
		}

	}
	
	@PostMapping("/addDemandeToProject")
	public ResponseEntity<DemandeRealisation> AddDemandeToProject(@RequestBody DemandeRealisation demande
			,@RequestParam long idProjet,@RequestParam long idUser,@RequestParam Optional<Long> idcv, @RequestHeader (name="Authorization") String token) {

		
		Optional<Projet> pp = projetService.findById(idProjet);
		if (pp.isEmpty()) {
			return new ResponseEntity<DemandeRealisation>(HttpStatus.NOT_FOUND);
		} else {
			DemandeRealisation demandeRealisation= new DemandeRealisation();
			demandeRealisation.setProjet(pp.get());
			demandeRealisation.setCreatedAt(new Date());
			AppUser user = accountservice.GetUserByID(idUser);
			demandeRealisation.setDemandeur(user);
			if(idcv.isPresent()) {
				Optional<CV> cv=CVService.FindById(idcv.get());
				if(!cv.isEmpty())
					demandeRealisation.setCv(cv.get());
			}
			demandeRealisation=projetService.saveDemandeRealisation(demandeRealisation);
String tok=token;
			if (demandeRealisation != null) {

				return new ResponseEntity<DemandeRealisation>(demandeRealisation, HttpStatus.CREATED);
			}
			return new ResponseEntity<DemandeRealisation>(HttpStatus.NOT_MODIFIED);
		}

	}
	
	@PostMapping("/acceptDemandeInProjet")
	public ResponseEntity<HttpStatus> acceptDemandeInProjet(
			@RequestParam long idprojet,@RequestParam long iddemmande) {

		Optional<Projet> pp = projetService.findById(idprojet);
		if (pp.isEmpty()) {
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		} else {
			Optional<DemandeRealisation> demandeRealisation =projetService.findDEmandeRealisationById(iddemmande);
			if(demandeRealisation.isEmpty()) {
				return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
			}else {
				pp.get().setAcceptedDemande(demandeRealisation.get());
				projetService.save(pp.get());
				return new ResponseEntity<HttpStatus>(HttpStatus.OK);
			}
		}
	}

}
