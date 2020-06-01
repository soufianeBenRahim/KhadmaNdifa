package com.KhadmaNdifa.entites;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Id;

import com.KhedmaNdifa.ParentEntities.AuditModel;
@Entity
public class Deplome extends AuditModel{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long Id;
private int annee;
private int mois;
private String description;
private String organisataion;
@ManyToOne
@JoinColumn(name="id_Cv", nullable=false)
private CV cv;
public Long getId() {
	return Id;
}
public void setId(Long id) {
	Id = id;
}
public int getAnnee() {
	return annee;
}
public void setAnnee(int annee) {
	this.annee = annee;
}
public int getMois() {
	return mois;
}
public void setMois(int mois) {
	this.mois = mois;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getOrganisataion() {
	return organisataion;
}
public void setOrganisataion(String organistaion) {
	this.organisataion = organistaion;
}
public CV getCv() {
	return cv;
}
public void setCv(CV cv) {
	this.cv = cv;
}
public Deplome(Long id, int annee, int mois, String description, String organisataion, CV cv) {
	super();
	Id = id;
	this.annee = annee;
	this.mois = mois;
	this.description = description;
	this.organisataion = organisataion;
	this.cv = cv;
}
public Deplome() {
	super();
}

}
