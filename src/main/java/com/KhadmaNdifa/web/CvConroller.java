package com.KhadmaNdifa.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



import com.KhadmaNdifa.entites.CV;
import com.KhadmaNdifa.entites.Compitance;
import com.KhadmaNdifa.entites.CvGlobale;
import com.KhadmaNdifa.entites.Deplome;
import com.KhadmaNdifa.service.CVService;


@RestController
@RequestMapping(path = "/CVs")
public class CvConroller {

	@Autowired
	public CvConroller(CVService _cvService) {
		this.cvService=_cvService;
	}
	CVService cvService;
	@GetMapping("/CVsUser")
	ResponseEntity<List<CvGlobale>> getCVofUser(@RequestParam(required = false) Long id){
     	 try {
		      List<CvGlobale> CVs = new ArrayList<CvGlobale>();

		      if (id != null) {
		    	  cvService.GetCVByidEmploiyee(id).forEach((cvelement)->
		    	  {
		    		  CVs.add(cvelement);
		    		  System.out.println(cvelement.getCv().getDesignationCV());
		    		  cvelement.getDeplomes().forEach((deplome)->
		    		  {
		    			  System.out.println(deplome.getDescription());  
		    		  });
		    		  cvelement.getCompitances().forEach((comp)->
		    		  {
		    			  System.out.println(comp.getDescription());  
		    		  });
		    	  });
	
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
	  ResponseEntity<CV> getCVById(@PathVariable("id") long idCV) {
	    Optional<CV> CvData = cvService.FindById(idCV );

	    if (CvData.isPresent()) {
	      return new ResponseEntity<>(CvData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	  @PostMapping("/")
	  ResponseEntity<CV> createCV(@RequestBody CV cv) {
	    try {
	      CV _cv = cvService.SaveCV(cv);
	      return new ResponseEntity<>(_cv, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	    }
	  }

	  @PutMapping("/update/{id}")
	  ResponseEntity<CV> updateCV(@PathVariable("id") long id, @RequestBody CV cv) {
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
	  ResponseEntity<HttpStatus> deleteCv(@PathVariable("id") long id) {
	    try {
	      cvService.DeleteCVById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	    }
	  }
// deplomes
	    @PutMapping(value = "/adddeplome")
	    @ResponseBody
	    public ResponseEntity<Deplome>  addDeplomeToCV(@RequestBody Deplome deplome,@RequestParam Long id) {
	    try {
	    	try {
		    	Deplome d= cvService.AddDeplomeToCV(deplome,id);
		    	if(d!=null) {
		    		return new ResponseEntity(d, HttpStatus.OK);
		    	}else {
		    		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    	}
	    	}catch (Exception e) {
			      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
		@GetMapping("/{idCv}/deplomes")
		public ResponseEntity<List<Deplome>> getDeplomesFromCV(@PathVariable(required = false) Long idCv){
	     	 try {
			      List<Deplome> deplomes = new ArrayList<Deplome>();

			      if (idCv != null) {
			    	  cvService.GetDeplomesFromCv(idCv).forEach((dep)->{
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
		public ResponseEntity<Deplome> deleteDeplome(@PathVariable("idDeplomes") long idDeplomes) {
		try {
		      System.out.println("delete deplome n ° "+idDeplomes);
 		      Deplome Diplome =cvService.deleteDeplom(idDeplomes);
		      if (Diplome !=null ) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity(Diplome, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		  }
		// copitances
			@GetMapping("/{idCv}/compitances")
			public ResponseEntity<List<Compitance>> getCompitancesFromCV(@PathVariable(required = false) Long idCv){
		     	 try {
				      List<Compitance> compitances = new ArrayList<Compitance>();

				      if (idCv != null) {
				    	  cvService.GetCompitanceFromCV(idCv).forEach((comp)->{
				    		  compitances.add(comp);
				    	  }
				    	  );
			
				      }
				      if (compitances.isEmpty()) {
				        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				      }
			    	  
				      return new ResponseEntity(compitances, HttpStatus.OK);
				    } catch (Exception e) {
				      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
				    }
			}
			  @DeleteMapping("/compitances/{idCompitance}/delete")
			  public ResponseEntity<HttpStatus> deleteCompitance(@PathVariable("idCompitance") long idCompitance) {
			    try {
			    	System.out.println("delete deplome n ° "+idCompitance);
			      cvService.deleteCompitance(idCompitance);
			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			    } catch (Exception e) {
			      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
			    }
			  }
}
