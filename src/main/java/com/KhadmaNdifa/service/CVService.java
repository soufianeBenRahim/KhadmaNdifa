package com.KhadmaNdifa.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.KhadmaNdifa.entites.CV;
import com.KhadmaNdifa.entites.Compitance;
import com.KhadmaNdifa.entites.CvGlobale;
import com.KhadmaNdifa.entites.Deplome;
import com.KhadmaNdifa.entites.Experiance;

public interface CVService {
CV SaveCV(CV cv);
void DeleteCVById(long IDCV);
Optional<CV>  FindById(long  idCV);
CV GetCVByid(long  id);
List<CvGlobale> GetCVByidEmploiyee (long idEmploiyee);
void AddExperianceToCV(Experiance experiance,long idCV);
Deplome AddDeplomeToCV(Deplome deplome,long idCV);
void AddCompitanceToCV(Compitance compitance,long idCV);
void DeletAll();

// deplomes

List<Deplome> GetDeplomesFromCv(long idCv);
Deplome deleteDeplom(long id);
List<Compitance> GetCompitanceFromCV(Long id);
void deleteCompitance(long id);

}
