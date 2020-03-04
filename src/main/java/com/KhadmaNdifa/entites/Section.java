package com.KhadmaNdifa.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.KhedmaNdifa.ParentEntities.AuditModel;
@Entity
public class Section extends AuditModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long iDSection;
	private int NumOrder;
	private String description; 
}
