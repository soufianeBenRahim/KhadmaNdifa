package com.KhadmaNdifa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KhadmaNdifa.entites.LookUpRebriqueCV;
@Repository
public interface LookupRebriqueRepository extends JpaRepository<LookUpRebriqueCV, Long> {

}
