package com.KhadmaNdifa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.KhadmaNdifa.entites.Emploiyeur;
@Repository
public interface EmploiyeurRepository extends JpaRepository<Emploiyeur,Long> {
Emploiyeur findByUsername(String username);
}
