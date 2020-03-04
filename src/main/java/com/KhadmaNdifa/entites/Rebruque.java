package com.KhadmaNdifa.entites;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import com.KhedmaNdifa.ParentEntities.AuditModel;
import com.KhedmaNdifa.ParentEntities.TypeRebriqueCV;

@Entity
public class Rebruque extends AuditModel{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private long iDRebruque;
	private int Numorder;
	@ManyToOne()
	@JoinColumn(name = "idSection")
	private Section sectionCV;
	private TypeRebriqueCV typeSection;
	@ManyToOne()
	@JoinColumn(name = "idLookup")
	private LookUpRebriqueCV lookup;
private String Value;
	@OneToMany(mappedBy = "rebruque")
	private Set<CV_Rebrique> CV_Rebriques;
}
