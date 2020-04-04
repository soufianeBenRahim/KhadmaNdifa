package com.KhadmaNdifa.dao;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KhadmaNdifa.entites.CV;
import com.KhadmaNdifa.entites.Emploiyee;
@Repository
public interface CVsRepository extends JpaRepository<CV, Long>
{
	public List<CV> findAllByEmploiyee(Emploiyee emp); 
	
}
