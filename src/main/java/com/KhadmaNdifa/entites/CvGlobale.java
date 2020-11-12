package com.KhadmaNdifa.entites;

import java.util.List;

public class CvGlobale {
	private CV cv;
	private List<Deplome> deplomes;
	private List<Compitance> compitances;
	private List<Experiance> experiances;

	public CV getCv() {
		return cv;
	}

	public void setCv(CV cv) {
		this.cv = cv;
	}

	public List<Deplome> getDeplomes() {
		return deplomes;
	}

	public void setDeplomes(List<Deplome> deplomes) {
		this.deplomes = deplomes;
	}

	public List<Compitance> getCompitances() {
		return compitances;
	}

	public void setCompitances(List<Compitance> compitances) {
		this.compitances = compitances;
	}

	public List<Experiance> getExperiances() {
		return experiances;
	}

	public void setExperiances(List<Experiance> experiances) {
		this.experiances = experiances;
	}

	public CvGlobale(CV cv, List<Deplome> deplomes, List<Compitance> compitances, List<Experiance> experiances) {
		super();
		this.cv = cv;
		this.deplomes = deplomes;
		this.compitances = compitances;
		this.experiances = experiances;
	}

	public CvGlobale() {
		super();
	}

}
