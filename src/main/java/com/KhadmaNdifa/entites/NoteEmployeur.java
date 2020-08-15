package com.KhadmaNdifa.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;

import com.KhedmaNdifa.ParentEntities.AuditModel;
@Entity
public class NoteEmployeur extends AuditModel {
@javax.persistence.Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long Id;


public NoteEmployeur() {
	super();
}
public NoteEmployeur(long id, @Max(5) int note, Projet projet, AppUser emploiyee) {
	super();
	Id = id;
	this.note = note;
	this.projet = projet;
	this.emploiyee = emploiyee;
}
public long getId() {
	return Id;
}
public void setId(long id) {
	Id = id;
}
public int getNote() {
	return note;
}
public void setNote(int note) {
	this.note = note;
}
public Projet getProjet() {
	return projet;
}
public void setProjet(Projet projet) {
	this.projet = projet;
}
public AppUser getEmploiyee() {
	return emploiyee;
}
public void setEmploiyee(AppUser emploiyee) {
	this.emploiyee = emploiyee;
}
@Max(value = 5)
private int note;
@OneToOne
private Projet projet;
@ManyToOne
@JoinColumn(name="id_Emploiyee")
private AppUser emploiyee;
}
