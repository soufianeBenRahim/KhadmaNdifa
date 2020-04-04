package com.KhadmaNdifa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KhadmaNdifa.entites.CV;
import com.KhadmaNdifa.entites.Deplome;
@Repository
public interface DeplomeRepository extends JpaRepository<Deplome, Long >{
public List<Deplome>findAllByCv(CV cv);
}
