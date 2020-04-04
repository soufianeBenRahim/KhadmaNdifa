package com.KhadmaNdifa.entites;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.metamodel.StaticMetamodel;
import javax.validation.constraints.Max;

@Entity
public class Compitance {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ID;
	private String Description;
	@Max(value=100)
	private int pourcentage;
	@ManyToOne
	@JoinColumn(name = "idCv")
	private CV cv;
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getPourcentage() {
		return pourcentage;
	}
	public void setPourcentage(int pourcentage) {
		this.pourcentage = pourcentage;
	}
	public CV getCv() {
		return cv;
	}
	public void setCv(CV cv) {
		this.cv = cv;
	}
	public Compitance(long iD, String description, @Max(100) int pourcentage, CV cv) {
		super();
		ID = iD;
		Description = description;
		this.pourcentage = pourcentage;
		this.cv = cv;
	}
	public Compitance() {
		super();
	}
	

}
