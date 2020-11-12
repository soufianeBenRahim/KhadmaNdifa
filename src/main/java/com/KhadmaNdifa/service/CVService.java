package com.KhadmaNdifa.service;

import java.util.List;
import java.util.Optional;

import com.KhadmaNdifa.entites.CV;
import com.KhadmaNdifa.entites.Compitance;
import com.KhadmaNdifa.entites.CvGlobale;
import com.KhadmaNdifa.entites.Deplome;
import com.KhadmaNdifa.entites.Experiance;

public interface CVService {
	CV SaveCV(CV cv);

	void DeleteCVById(long IDCV);

	Optional<CV> FindById(long idCV);

	CV GetCVByid(long id);

	List<CvGlobale> GetCVByidEmploiyee(long idEmploiyee);

	void DeletAll();

// deplomes
	Deplome AddDeplomeToCV(Deplome deplome, long idCV);

	List<Deplome> GetDeplomesFromCv(long idCv);

	Deplome deleteDeplom(long id);

// experiance
	Experiance deleteExperiance(long id);

	Experiance AddExperianceToCV(Experiance experiance, long idCV);

//compitance
	List<Compitance> GetCompitanceFromCV(Long id);

	Compitance deleteCompitance(long id);

	Compitance AddCompitanceToCV(Compitance compitance, long idCV);
}
