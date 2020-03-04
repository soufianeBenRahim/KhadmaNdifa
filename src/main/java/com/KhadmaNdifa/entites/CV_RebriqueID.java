package com.KhadmaNdifa.entites;

import java.io.Serializable;


public class CV_RebriqueID implements Serializable{
	private long idCV;
	private long idRebrique;
	
	public int hashCode() {
		  return (int)(idCV + idRebrique);
		 }

		 public boolean equals(Object object) {
		  if (object instanceof CV_RebriqueID) {
			  CV_RebriqueID otherId = (CV_RebriqueID) object;
		  }
		  return false;
		 }

}
