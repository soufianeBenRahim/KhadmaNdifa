package com.KhadmaNdifa.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KhadmaNdifa.dao.ProjetsRepositry;
import com.KhadmaNdifa.entites.Projet;

@RestController
public class ProjetsController {
	

	
	@Autowired
	ProjetsRepositry projetRepository;
    @GetMapping("/projets")
    public List<Projet> getAllProjet(){
        return  projetRepository.findAll();
    }

}
