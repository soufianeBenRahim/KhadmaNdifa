package com.KhadmaNdifa.entites;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.KhedmaNdifa.ParentEntities.AuditModel;
import com.KhedmaNdifa.ParentEntities.Etatcivile;;

@Entity
public class CV  extends AuditModel{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ID;
	private String designationCV;
	public String getDesignationCV() {
		return designationCV;
	}
	public void setDesignationCV(String designationCV) {
		this.designationCV = designationCV;
	}
	private Etatcivile etatcivile;
	private String nom;
	private String prenom;
	private String adress;
  //  @ManyToMany(fetch = FetchType.EAGER)
	//private Collection<Experiance> experiances=new ArrayList<>();
   // @ManyToMany(fetch = FetchType.EAGER)
 //	private Collection<Compitance> compitances=new ArrayList<>();
    

	public CV() {
		super();
	}


	public CV(long iD, String designationCV, Etatcivile etatcivile, String nom, String prenom, String adress, String email,
		String tel, AppUser user) {
	super();
	ID = iD;
	this.designationCV = designationCV;
	this.etatcivile = etatcivile;
	this.nom = nom;
	this.prenom = prenom;
	this.adress = adress;
	this.email = email;
	Tel = tel;
	this.user = user;
}
	public AppUser getUser() {
		return user;
	}
	public void setUser(AppUser user) {
		this.user = user;
	}
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public Etatcivile getEtatcivile() {
		return etatcivile;
	}
	public void setEtatcivile(Etatcivile etatcivile) {
		this.etatcivile = etatcivile;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}

	private String email;
	private String Tel;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
	@JoinColumn(name="id_Emploiyee",nullable = false)
	private AppUser user;

}
