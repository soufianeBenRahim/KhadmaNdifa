package com.KhadmaNdifa.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KhadmaNdifa.dao.CVsRepository;
import com.KhadmaNdifa.dao.CompitanceRepository;
import com.KhadmaNdifa.dao.DeplomeRepository;
import com.KhadmaNdifa.dao.EmploiyeeRepository;
import com.KhadmaNdifa.dao.ExperianceRepository;
import com.KhadmaNdifa.entites.CV;
import com.KhadmaNdifa.entites.Compitance;
import com.KhadmaNdifa.entites.Deplome;
import com.KhadmaNdifa.entites.Emploiyee;
import com.KhadmaNdifa.entites.Experiance;
@Service
public class CVServiceImpl implements CVService {
@Autowired
private CVsRepository cVRepository;
@Autowired
private DeplomeRepository deplomeRepository;
@Autowired
private ExperianceRepository experianceRepository;
@Autowired
private CompitanceRepository compitanceRepository;
@Autowired
private EmploiyeeRepository emploiyeeRepository;
	@Override
	public CV SaveCV(CV cv) {
		
		return cVRepository.save(cv);
	}

	@Override
	public void DeleteCVById(long idCV) {
		cVRepository.deleteById(idCV);
		
	}

	@Override
	public CV GetCVByid(long id) {

		return cVRepository.findById(id).get();
	}
	@Override
	public List<CV> GetCVByidEmploiyee(long idEmploiyee){
		System.out.println("Cv service GetCVByidEmploiyee :: idemploiyee ="+idEmploiyee);
		Emploiyee emp =emploiyeeRepository.findById(idEmploiyee).get();
		return cVRepository.findAllByEmploiyee(emp);
	}



	@Override
	public Optional<CV>  FindById(long idCV) {
		
		return this.cVRepository.findById(idCV);
	}

	@Override
	public void DeletAll() {
		cVRepository.deleteAll();
		
	}
	// deplomes 
	@Override
	public List<Deplome> GetDeplomesFromCv(long idCv){
		System.out.println("recumeration le cv de id  ="+idCv);
		CV cv =cVRepository.findById(idCv).get();
		System.out.println("recumeration le des deplome de cv   ="+idCv);
		return deplomeRepository.findAllByCv(cv);
	}
	@Override
	public Deplome AddDeplomeToCV(Deplome deplome, long idCV) {
		CV cv=cVRepository.findById(idCV).get();
		deplome.setCv(cv);
		deplome.setCreatedAt(new Date());
		deplome.setUpdatedAt(new Date());
		cv.getDeplomes().add(deplome);
			Deplome dep=	deplomeRepository.save(deplome);
			return dep;
		
	}
	@Override
	public void deleteDeplom(long id) {
		this.deplomeRepository.deleteById(id);
	};
	// compitance 
	@Override
	public void AddCompitanceToCV(Compitance compitance, long idCV) {
		CV cv=cVRepository.findById(idCV).get();
		compitance.setCv(cv);
			Compitance comp=compitanceRepository.save(compitance);
		
	}
	
	@Override
	public void AddExperianceToCV(Experiance experiance, long idCV) {
		
	CV cv=cVRepository.findById(idCV).get();
	experiance.setCv(cv);
		Experiance exp=	experianceRepository.save(experiance );

	}

}
