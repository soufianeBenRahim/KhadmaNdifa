package com.KhadmaNdifa.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.KhadmaNdifa.dao.ProjetsRepositry;
import com.KhadmaNdifa.entites.AppUser;
import com.KhadmaNdifa.entites.Projet;
import com.KhadmaNdifa.service.AccountServiceImpl;
import com.KhedmaNdifa.ParentEntities.TypeUser;

@RestController
public class ProjetsController {
	

	
	@Autowired
	ProjetsRepositry projetRepository;
	@Autowired
	AccountServiceImpl accountservice;
	
    @GetMapping("/projets")
    public List<Projet> getAllProjet(){
    	List<Projet> projs= projetRepository.findAll();
    	
    	return projs;
    }
    
    @GetMapping("/getprojectsuser")
    public List<Projet> getProjectsUser(@RequestParam(name="id") long id)
    {
    	AppUser user = accountservice.GetUserByID(id);
    	if(user!=null  && user.getTypeuser()==TypeUser.EUR) {
    		return projetRepository.finByEmploiyeur(id);
    	}
    	else {
    		return projetRepository.finByEmploiye(id) ;
    	}

    }
    

}
