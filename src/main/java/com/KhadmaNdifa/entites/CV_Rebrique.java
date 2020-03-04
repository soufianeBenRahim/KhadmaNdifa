package com.KhadmaNdifa.entites;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.KhedmaNdifa.ParentEntities.AuditModel;
@Entity
@IdClass(CV_RebriqueID.class)
public class CV_Rebrique extends AuditModel{
	
@Id
private long idCV;
@Id
private long idRebrique;

private String valeurLookup;
private String valeur;

@ManyToOne
@JoinColumn(name = "idCV",updatable = false,insertable = false)
private CV cV;
@ManyToOne
@JoinColumn(name = "idRebrique",updatable = false , insertable = false)
private Rebruque rebruque;
}
