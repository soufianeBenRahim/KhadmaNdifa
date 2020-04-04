package com.KhadmaNdifa.entites;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.KhedmaNdifa.ParentEntities.Gender;

@Entity
@DiscriminatorValue(value = "EUR")
public class Emploiyeur extends AppUser  {
private double Solde;
private String description;
public double getSolde() {
	return Solde;
}
public void setSolde(double solde) {
	Solde = solde;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

public Emploiyeur() {
	super();
}
public Emploiyeur(Long id, String username, String email, Gender gender, String password, boolean actived, double solde,
		String description) {
	super(id, username, email, gender, password, actived);
	Solde = solde;
	this.description = description;
}

}
