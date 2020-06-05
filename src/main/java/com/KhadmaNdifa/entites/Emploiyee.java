package com.KhadmaNdifa.entites;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import com.KhedmaNdifa.ParentEntities.Gender;

@Entity
@DiscriminatorValue(value = "EE")
public class Emploiyee extends AppUser {
private double tarifhoraire;
private String resume; 
public double getTarifhoraire() {
	return tarifhoraire;
}
public void setTarifhoraire(double tarifhoraire) {
	this.tarifhoraire = tarifhoraire;
}

public Emploiyee() {
	super();
}
public Emploiyee(Long id, String username, String email, Gender gender, String password, boolean actived,
		double tarifhoraire, String resume) {
	super(id, username, email, gender, password, actived);
	this.tarifhoraire = tarifhoraire;
	this.resume = resume;
}
public String getResume() {
	return resume;
}
public void setResume(String resume) {
	this.resume = resume;
}

}
