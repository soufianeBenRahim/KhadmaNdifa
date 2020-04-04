package com.KhadmaNdifa.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.KhadmaNdifa.dao.CVsRepository;

import com.KhadmaNdifa.entites.CV;
import com.KhadmaNdifa.entites.Deplome;
import com.KhadmaNdifa.service.CVService;

@RestController
@RequestMapping(path = "/CVs")
public class CvConroller {

	@Autowired
	CVService cvService;
	@GetMapping("/CVsUser")
	public ResponseEntity<List<CV>> getCVofUser(@RequestParam(required = false) Long id){
     	 try {
		      List<CV> CVs = new ArrayList<CV>();

		      if (id != null) {
		    	  cvService.GetCVByidEmploiyee(id).forEach((cvelement)->{CVs.add(cvelement);System.out.println("le cv selectionnee "+cvelement.getDesignationCV());});
	
		      }
		      if (CVs.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
	    	  
		      return new ResponseEntity(CVs, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}


	  @GetMapping("/{id}")
	  public ResponseEntity<CV> getCVById(@PathVariable("id") long idCV) {
	    Optional<CV> CvData = cvService.FindById(idCV);

	    if (CvData.isPresent()) {
	      return new ResponseEntity<>(CvData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	  @PostMapping("/")
	  public ResponseEntity<CV> createCV(@RequestBody CV cv) {
	    try {
	      CV _cv = cvService.SaveCV(cv);
	      return new ResponseEntity<>(_cv, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	    }
	  }

	  @PutMapping("/update/{id}")
	  public ResponseEntity<CV> updateCV(@PathVariable("id") long id, @RequestBody CV cv) {
	    Optional<CV> cvData = cvService.FindById(id);
	    if (cvData.isPresent()) {
	      CV _cv = cvData.get();
	      _cv.setNom(cv.getNom());
	      _cv.setPrenom(cv.getPrenom());
	      _cv.setEmail(cv.getEmail());
	      _cv.setTel(cv.getTel());
	      _cv.setAdress(cv.getAdress());
	      _cv.setEtatcivile(cv.getEtatcivile());
	      _cv= cvService.SaveCV(_cv);
	      return new ResponseEntity<>(_cv, HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	  @DeleteMapping("/{id}")
	  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
	    try {
	      cvService.DeleteCVById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	    }
	  }
//// deplomes
	  @PostMapping("/adddeplome")
	  public ResponseEntity<Deplome> addDeplomeToCV(@RequestBody Deplome deplome,@RequestParam long id) {
	    try {
	    	System.out.println(" id cv recupperer :"+id);
	    	System.out.println(deplome.getDescription());
	    	System.out.println(deplome.getOrganisataion());
	    	System.out.println(deplome.getAnnee());
	    	System.out.println(deplome.getMois());
	    	System.out.println(deplome.getDescription());
	    	System.out.println(deplome.getDescription());
	  //    Deplome _depolme = cvService.AddDeplomeToCV(deplome,id);
	      return new ResponseEntity<>(deplome, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	    }
	  }
	  
		@GetMapping("/{id}/deplomes")
		public ResponseEntity<List<Deplome>> getDeplomesFromCV(@PathVariable(required = false) Long id){
	     	 try {
			      List<Deplome> deplomes = new ArrayList<Deplome>();

			      if (id != null) {
			    	  cvService.GetDeplomesFromCv(id).forEach((dep)->{
			    		  deplomes.add(dep);
			    	  }
			    	  );
		
			      }
			      if (deplomes.isEmpty()) {
			        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			      }
		    	  
			      return new ResponseEntity(deplomes, HttpStatus.OK);
			    } catch (Exception e) {
			      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			    }
		}
		  @DeleteMapping("/deplomes/{idDeplomes}/delete")
		  public ResponseEntity<HttpStatus> deleteDeplome(@PathVariable("idDeplomes") long id) {
		    try {
		    	System.out.println("delete deplome n ° "+id);
		      cvService.deleteDeplom(id);
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    } catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		    }
		  }
		

}
