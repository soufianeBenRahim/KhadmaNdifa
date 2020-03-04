package com.KhadmaNdifa.entites;

import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.MapKeyColumn;

@Entity
public class LookUpRebriqueCV {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long IDLookupSection;
	private String name;
	 	@ElementCollection
	    @MapKeyColumn(name="name")
	    @Column(name="value")
	 	@CollectionTable(name="Lookup_attributes")
	private Map<String,String> Values; 

}
