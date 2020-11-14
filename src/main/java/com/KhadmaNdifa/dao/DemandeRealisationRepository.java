package com.KhadmaNdifa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.KhadmaNdifa.entites.DemandeRealisation;

import org.springframework.stereotype.Repository;
@Repository
public interface DemandeRealisationRepository extends JpaRepository<DemandeRealisation, Long>
{
}
