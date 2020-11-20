package com.KhadmaNdifa.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.KhedmaNdifa.ParentEntities.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class DemandeRealisation extends AuditModel{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String detailDemmande;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_Projet")
	private Projet projet;
	@ManyToOne
	@JoinColumn(name = "id_demandeur")
	private AppUser demandeur; 

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDetailDemmande() {
		return detailDemmande;
	}
	public void setDetailDemmande(String detailDemmande) {
		this.detailDemmande = detailDemmande;
	}
	public Projet getProjet() {
		return projet;
	}
	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	public AppUser getDemandeur() {
		return demandeur;
	}
	public void setDemandeur(AppUser demandeur) {
		this.demandeur = demandeur;
	}
	public DemandeRealisation( String detailDemmande, Projet projet,AppUser demandeur) {
		super();
		this.detailDemmande = detailDemmande;
		this.projet = projet;
		this.demandeur=demandeur;
	}
	public DemandeRealisation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
