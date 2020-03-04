package com.KhadmaNdifa.entites;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

@Entity
@DiscriminatorValue(value = "EE")
public class Emploiyee extends AppUser {
private double tarifhoraire;
private String resume; 
@ManyToMany(mappedBy = "emploiyees",fetch = FetchType.LAZY)
private Set<PROJET> projets;
}
