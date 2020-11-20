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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.KhedmaNdifa.ParentEntities.AuditModel;
import com.KhedmaNdifa.ParentEntities.EtatProjet;
import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@OneToOne
	@JoinColumn(name = "id_AcceptedDemande")
	private DemandeRealisation acceptedDemande;

	@OneToMany(mappedBy = "projet")
	private java.util.List<DemandeRealisation> demandeRealisations;

	private Date datePostilation;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
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

	public DemandeRealisation getAcceptedDemande() {
		return acceptedDemande;
	}

	public void setAcceptedDemande(DemandeRealisation acceptedDemande) {
		this.acceptedDemande = acceptedDemande;
	}

	public java.util.List<DemandeRealisation> getDemandeRealisations() {
		return demandeRealisations;
	}

	public void setDemandeRealisations(java.util.List<DemandeRealisation> demandeRealisations) {
		this.demandeRealisations = demandeRealisations;
	}

	public Date getDatePostilation() {
		return datePostilation;
	}

	public void setDatePostilation(Date datePostilation) {
		this.datePostilation = datePostilation;
	}

	public Projet(String description, String detail, Date dateFin, double budjet, EtatProjet etat, double pourcentage,
			AppUser emploiyeur, DemandeRealisation acceptedDemande,
			java.util.List<DemandeRealisation> demandeRealisations, Date datePostilation) {
		super();
		this.description = description;
		this.detail = detail;
		this.dateFin = dateFin;
		this.budjet = budjet;
		this.etat = etat;
		this.pourcentage = pourcentage;
		this.emploiyeur = emploiyeur;
		this.acceptedDemande = acceptedDemande;
		this.demandeRealisations = demandeRealisations;
		this.datePostilation = datePostilation;
	}

	public Projet() {
		super();
		// TODO Auto-generated constructor stub
	}

}
