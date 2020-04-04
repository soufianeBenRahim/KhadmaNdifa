package com.KhadmaNdifa.entites;

import javax.persistence.Entity;
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
private String Description;
private String Organisataion;
@ManyToOne
@JoinColumn(name = "id_Cv")
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
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
public String getOrganisataion() {
	return Organisataion;
}
public void setOrganisataion(String organistaion) {
	Organisataion = organistaion;
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
	Description = description;
	Organisataion = organisataion;
	this.cv = cv;
}
public Deplome() {
	super();
}

}
