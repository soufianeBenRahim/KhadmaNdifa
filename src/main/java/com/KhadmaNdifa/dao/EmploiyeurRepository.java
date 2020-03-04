package com.KhadmaNdifa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.KhadmaNdifa.entites.Emploiyeur;
@RepositoryRestResource
public interface EmploiyeurRepository extends JpaRepository<Emploiyeur,Long> {

}
