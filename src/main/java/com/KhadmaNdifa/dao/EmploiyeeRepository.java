package com.KhadmaNdifa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.KhadmaNdifa.entites.Emploiyee;
@Repository
public interface EmploiyeeRepository extends JpaRepository<Emploiyee, Long>  {
	List<Emploiyee> findByUsername(String username); 
}
