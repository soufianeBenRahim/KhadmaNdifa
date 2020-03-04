package com.KhadmaNdifa.entites;

import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.KhedmaNdifa.ParentEntities.AuditModel;;

@Entity
public class CV  extends AuditModel{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ID;
	@OneToOne
	@JoinColumn(name="id_Emploier")
	private Emploiyee emploiyee;
	@OneToMany(mappedBy = "cV")
	private Set<CV_Rebrique> cv_Rebriques;

}
