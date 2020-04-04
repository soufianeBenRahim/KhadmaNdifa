package com.KhadmaNdifa.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.KhedmaNdifa.ParentEntities.AuditModel;

@Entity
public class Experiance extends AuditModel {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long ID;
		private String Description;
		private String Organisation;
		private int anneeDebut;
		private int MoisDebut;
		private int anneeFin;
		private int MoisFin;
		private boolean curent;
		@ManyToOne
		@JoinColumn(name = "id_Cv")
		private CV cv;
		public long getID() {
			return ID;
		}
		public void setID(long iD) {
			ID = iD;
		}
		public String getDescription() {
			return Description;
		}
		public void setDescription(String description) {
			Description = description;
		}
		public String getOrganisation() {
			return Organisation;
		}
		public void setOrganisation(String organistaion) {
			Organisation = organistaion;
		}
		public int getAnneeDebut() {
			return anneeDebut;
		}
		public void setAnneeDebut(int anneeDebut) {
			this.anneeDebut = anneeDebut;
		}
		public int getMoisDebut() {
			return MoisDebut;
		}
		public void setMoisDebut(int moisDebut) {
			MoisDebut = moisDebut;
		}
		public int getAnneeFin() {
			return anneeFin;
		}
		public void setAnneeFin(int anneeFin) {
			this.anneeFin = anneeFin;
		}
		public int getMoisFin() {
			return MoisFin;
		}
		public void setMoisFin(int moisFin) {
			MoisFin = moisFin;
		}
		public boolean isCurent() {
			return curent;
		}
		public void setCurent(boolean curent) {
			this.curent = curent;
		}
		public CV getCv() {
			return cv;
		}
		public void setCv(CV cv) {
			this.cv = cv;
		}
		public Experiance(long iD, String description, String organistaion, int anneeDebut, int moisDebut, int anneeFin,
				int moisFin, boolean curent, CV cv) {
			super();
			ID = iD;
			Description = description;
			Organisation = organistaion;
			this.anneeDebut = anneeDebut;
			MoisDebut = moisDebut;
			this.anneeFin = anneeFin;
			MoisFin = moisFin;
			this.curent = curent;
			this.cv = cv;
		}
		public Experiance() {
			super();
		}
		
}
