package com.KhadmaNdifa.service;

import java.util.List;

import com.KhadmaNdifa.entites.Projet;

public interface ProjetService {
	List<Projet> getProjetByUser(long id);

}
