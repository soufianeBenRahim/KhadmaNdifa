package com.KhadmaNdifa.entites;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.KhedmaNdifa.ParentEntities.AuditModel;
import com.KhedmaNdifa.ParentEntities.EtatProjet;
@Entity
public class PROJET extends AuditModel {
@Id
private long iD;
private String description;
@ManyToOne
@JoinColumn(name = "idUser")
private AppUser createdBy;
private Date datePostilation;
//private String Description;

private Date dateFin;
private double budjet;
private EtatProjet etat;
private double pourcentage;
@ManyToOne
@JoinColumn(name = "id_emploiyeur")
private Emploiyeur emploiyeur;

@ManyToMany(fetch = FetchType.LAZY)
@JoinTable(name = "PROJET_EMPLOIYEE",
joinColumns = {
        @JoinColumn(name = "id_Projet", referencedColumnName = "iD",
                nullable = false, updatable = false)},
inverseJoinColumns = {
        @JoinColumn(name = "emploiyee_Id", referencedColumnName = "id",
                nullable = false, updatable = false)})
private Set<Emploiyee> emploiyees;

}
