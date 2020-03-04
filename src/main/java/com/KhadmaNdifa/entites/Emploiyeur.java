package com.KhadmaNdifa.entites;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "EUR")
public class Emploiyeur extends AppUser  {
private double Solde;
private String description;
}
