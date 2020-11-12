package com.KhadmaNdifa.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KhadmaNdifa.dao.AppUserRepository;
import com.KhadmaNdifa.dao.CVsRepository;
import com.KhadmaNdifa.dao.CompitanceRepository;
import com.KhadmaNdifa.dao.DeplomeRepository;
import com.KhadmaNdifa.dao.ExperianceRepository;
import com.KhadmaNdifa.entites.AppUser;
import com.KhadmaNdifa.entites.CV;
import com.KhadmaNdifa.entites.Compitance;
import com.KhadmaNdifa.entites.CvGlobale;
import com.KhadmaNdifa.entites.Deplome;
import com.KhadmaNdifa.entites.Experiance;

@Service
public class CVServiceImpl implements CVService {

	private CVsRepository cVRepository;

	private DeplomeRepository deplomeRepository;

	private ExperianceRepository experianceRepository;

	private CompitanceRepository compitanceRepository;

	private AppUserRepository emploiyeeRepository;

	@Autowired
	public CVServiceImpl(CVsRepository cVRepository, DeplomeRepository deplomeRepository,
			ExperianceRepository experianceRepository, CompitanceRepository compitanceRepository,
			AppUserRepository emploiyeeRepository) {
		super();
		this.cVRepository = cVRepository;
		this.deplomeRepository = deplomeRepository;
		this.experianceRepository = experianceRepository;
		this.compitanceRepository = compitanceRepository;
		this.emploiyeeRepository = emploiyeeRepository;
	}

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
	public List<CvGlobale> GetCVByidEmploiyee(long idEmploiyee) {
		System.out.println("Cv service GetCVByidEmploiyee :: idemploiyee =" + idEmploiyee);
		AppUser emp = emploiyeeRepository.findById(idEmploiyee).get();
		List<CV> cvs = cVRepository.findAllByUser(emp);
		List<CvGlobale> cvToReturn = new ArrayList<CvGlobale>();
		cvs.forEach((cv) -> {
			CvGlobale cvg = new CvGlobale();
			cvg.setCv(cv);
			List<Deplome> deplomes = deplomeRepository.findAllByCv(cv);
			cvg.setDeplomes(deplomes);
			List<Compitance> compitances = compitanceRepository.findAllBycv(cv);
			cvg.setCompitances(compitances);
			List<Experiance> experiances = experianceRepository.findAllBycv(cv);
			cvg.setExperiances(experiances);
			cvToReturn.add(cvg);
		});
		return cvToReturn;
	}

	@Override
	public Optional<CV> FindById(long idCV) {

		return this.cVRepository.findById(idCV);
	}

	@Override
	public void DeletAll() {
		this.deplomeRepository.deleteAll();
		this.compitanceRepository.deleteAll();
		this.experianceRepository.deleteAll();
		this.cVRepository.deleteAll();

	}

	// deplomes
	@Override
	public List<Deplome> GetDeplomesFromCv(long idCv) {
		System.out.println("recumeration le cv de id  =" + idCv);
		CV cv = cVRepository.findById(idCv).get();
		System.out.println("recumeration le des deplome de cv   =" + idCv);
		return deplomeRepository.findAllByCv(cv);
	}

	@Override
	public Deplome AddDeplomeToCV(Deplome deplome, long idCV) {
		CV cv = cVRepository.findById(idCV).get();
		deplome.setCv(cv);
		deplome.setCreatedAt(new Date());
		deplome.setUpdatedAt(new Date());
		return deplomeRepository.save(deplome);

	}

	@Override
	public Deplome deleteDeplom(long id) {
		Deplome d = this.deplomeRepository.findById(id).get();
		this.deplomeRepository.deleteById(id);
		return d;
	};

	// compitance
	@Override
	public Compitance AddCompitanceToCV(Compitance compitance, long idCV) {
		CV cv = cVRepository.findById(idCV).get();
		compitance.setCv(cv);
		compitance.setCreatedAt(new Date());
		compitance.setUpdatedAt(new Date());
		Compitance comp = compitanceRepository.save(compitance);
		return comp;

	}

	public List<Compitance> GetCompitanceFromCV(Long id) {
		System.out.println("recumeration le cv de id  =" + id);
		CV cv = cVRepository.findById(id).get();
		System.out.println("recumeration le des compitances de cv   =" + id);
		return compitanceRepository.findAllBycv(cv);
	}

	public Compitance deleteCompitance(long id) {
		Compitance c = this.compitanceRepository.findById(id).get();
		this.compitanceRepository.deleteById(id);
		return c;
	}

	// Experiance
	@Override
	public Experiance AddExperianceToCV(Experiance experiance, long idCV) {
		CV cv = cVRepository.findById(idCV).get();
		experiance.setCv(cv);
		experiance.setCreatedAt(new Date());
		experiance.setUpdatedAt(new Date());
		Experiance exp = experianceRepository.save(experiance);
		return exp;
	}

	@Override
	public Experiance deleteExperiance(long id) {
		Experiance exp = this.experianceRepository.findById(id).get();
		experianceRepository.deleteById(id);
		return exp;
	}

}
