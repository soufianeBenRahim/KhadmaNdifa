package com.KhadmaNdifa.entites;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.KhedmaNdifa.ParentEntities.AuditModel;
import com.KhedmaNdifa.ParentEntities.EtatProjet;

import antlr.collections.List;
@Entity
public class Projet extends AuditModel {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
private String description;
private String detail;
private Date dateFin;
private double budjet;
private EtatProjet etat;
private double pourcentage;
@ManyToOne
@JoinColumn(name = "id_emploiyeur")
private AppUser emploiyeur;

@ManyToOne
@JoinColumn(name = "id_AceptedEmployee")
private AppUser aceptedEmployee;

public AppUser getAceptedEmployee() {
	return aceptedEmployee;
}

public void setAceptedEmployee(AppUser aceptedEmployee) {
	this.aceptedEmployee = aceptedEmployee;
}

@ManyToMany(fetch = FetchType.LAZY)
@JoinTable(name = "PROJET_EMPLOIYEE",
joinColumns = {
        @JoinColumn(name = "id_Projet", referencedColumnName = "iD",
                nullable = false, updatable = false)},
inverseJoinColumns = {
        @JoinColumn(name = "emploiyee_Id", referencedColumnName = "id",
                nullable = false, updatable = false)})
private java.util.List<AppUser> emploiyees;

public String getDetail() {
	return detail;
}

public void setDetail(String detail) {
	this.detail = detail;
}

private Date datePostilation;
//private String Description;



public Projet() {
	super();
}

public Projet(long iD, String description,String detail, AppUser createdBy, Date datePostilation, Date dateFin, double budjet,
		EtatProjet etat, double pourcentage, AppUser emploiyeur,
		java.util.List<AppUser> emploiyees ,AppUser aceptedEmployee) {
	super();
	this.id = iD;
	this.description = description;
	this.detail=detail;
	this.datePostilation = datePostilation;
	this.dateFin = dateFin;
	this.budjet = budjet;
	this.etat = etat;
	this.pourcentage = pourcentage;
	this.emploiyeur = emploiyeur;
	this.emploiyees = emploiyees;
	this.aceptedEmployee=aceptedEmployee;
}

public long getid() {
	return id;
}

public void setid(long iD) {
	this.id = iD;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}


public Date getDatePostilation() {
	return datePostilation;
}

public void setDatePostilation(Date datePostilation) {
	this.datePostilation = datePostilation;
}

public Date getDateFin() {
	return dateFin;
}

public void setDateFin(Date dateFin) {
	this.dateFin = dateFin;
}

public double getBudjet() {
	return budjet;
}

public void setBudjet(double budjet) {
	this.budjet = budjet;
}

public EtatProjet getEtat() {
	return etat;
}

public void setEtat(EtatProjet etat) {
	this.etat = etat;
}

public double getPourcentage() {
	return pourcentage;
}

public void setPourcentage(double pourcentage) {
	this.pourcentage = pourcentage;
}

public AppUser getEmploiyeur() {
	return emploiyeur;
}

public void setEmploiyeur(AppUser emploiyeur) {
	this.emploiyeur = emploiyeur;
}

public java.util.List<AppUser> getEmploiyees() {
	return emploiyees;
}

public void setEmploiyees(java.util.List<AppUser> emploiyees) {
	this.emploiyees = emploiyees;
}



}
