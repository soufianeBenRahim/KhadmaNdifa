package com.KhadmaNdifa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KhadmaNdifa.entites.Experiance;
@Repository
public interface ExperianceRepository extends JpaRepository<Experiance, Long> {

}
