package com.KhadmaNdifa.web;

import java.time.LocalDate;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.KhadmaNdifa.dao.ProjetsRepositry;
import com.KhadmaNdifa.entites.AppUser;
import com.KhadmaNdifa.entites.Projet;
import com.KhadmaNdifa.service.AccountServiceImpl;
import com.KhedmaNdifa.ParentEntities.EtatProjet;
import com.KhedmaNdifa.ParentEntities.TypeUser;



@RestController
public class ProjetsController {
	

	
	@Autowired
	ProjetsRepositry projetRepository;
	@Autowired
	AccountServiceImpl accountservice;
	
    @GetMapping("/projets")
    public ResponseEntity<List<Projet>> getAllProjet(){
    	List<Projet> projs= projetRepository.findAll();
    	
		if (!CollectionUtils.isEmpty(projs)) {
			return new ResponseEntity<List<Projet>>(projs, HttpStatus.OK);
		}
		return new ResponseEntity<List<Projet>>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/getprojectsuser")
    public ResponseEntity<List<Projet>> getProjectsUser(@RequestParam(name="id") long id)
    {
    	AppUser user = accountservice.GetUserByID(id);
    	List<Projet> projets=null;
    	if(user!=null  && user.getTypeuser()==TypeUser.EUR) {
    		projets= projetRepository.finByEmploiyeur(id);
    	}
    	else {
    		projets= projetRepository.finByEmploiye(id) ;
    	}
    	if(projets!=null) 
    	{
    		return new  ResponseEntity<List<Projet>>(projets, HttpStatus.OK);
    	}else 
    	{
    		return new ResponseEntity<List<Projet>>(HttpStatus.NO_CONTENT);
    	}

    }
    
    @PostMapping("/addprojet")
	
	public ResponseEntity<Projet> createNewCustomer(@RequestBody Projet proj,@RequestParam long iduser) {
     	AppUser user = accountservice.GetUserByID(iduser);
    	if(user!=null) {
    		proj.setCreatedAt(new Date());
    		proj.setUpdatedAt(new Date());
        	proj.setDatePostilation(new Date());
        	proj.setEmploiyeur(user);
        	proj.setEtat(EtatProjet.LANCEMMENT);
        	proj.setPourcentage(0);
        	Projet p = projetRepository.save(proj);

    		if (p != null) {
    			
    			return new ResponseEntity<Projet>(p, HttpStatus.CREATED);
    		}
    		return new ResponseEntity<Projet>(HttpStatus.NOT_MODIFIED);
    	}else {
    		return new ResponseEntity<Projet>(HttpStatus.NOT_MODIFIED);
    	}

	}
    
    
    @PutMapping("/updateProjet")
	
	public ResponseEntity<Projet> updateProjet(@RequestBody Projet proj) {
     	
    	long id =proj.getid();
    	Optional<Projet> pp= projetRepository.findById(proj.getid());
    	if(pp.isEmpty()) 
    	{
    		return new ResponseEntity<Projet>( HttpStatus.NOT_FOUND);
    	}
    	else 
    	{
    		Projet projet=pp.get();
    		projet.setUpdatedAt(new Date());
    		projet.setDescription(proj.getDescription());
    		projet.setDetail(proj.getDetail());
    		projet.setBudjet(proj.getBudjet());
    		projet = projetRepository.save(projet);

    		if (projet != null) {
    			
    			return new ResponseEntity<Projet>(projet, HttpStatus.CREATED);
    		}
    		return new ResponseEntity<Projet>(HttpStatus.NOT_MODIFIED);
    	}
    
	}
    

}
