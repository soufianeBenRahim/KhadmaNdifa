package com.KhadmaNdifa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KhadmaNdifa.entites.Compitance;
@Repository
public interface CompitanceRepository extends JpaRepository<Compitance, Long>{

}
