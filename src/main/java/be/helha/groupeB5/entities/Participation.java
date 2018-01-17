package be.helha.groupeB5.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.eclipse.persistence.annotations.CascadeOnDelete;

@Entity
public class Participation implements Serializable {

	@Id
	@GeneratedValue
	private Integer idP;
	private String nomDonateur;
	private float montant;
	private Date dateDon;

	
	

	public Participation(String nomDonateur, float montant, Date dateDon) {
		super();
		this.nomDonateur = nomDonateur;
		this.montant = montant;
		this.dateDon = dateDon;
	}

	public Participation() {}



	public Integer getIdP() {
		return idP;
	}




	public void setIdP(Integer idP) {
		this.idP = idP;
	}




	public String getNomDonateur() {
		return nomDonateur;
	}




	public void setNomDonateur(String nomDonateur) {
		this.nomDonateur = nomDonateur;
	}




	public float getMontant() {
		return montant;
	}




	public void setMontant(float montant) {
		this.montant = montant;
	}




	public Date getDateDon() {
		return dateDon;
	}




	public void setDateDon(Date dateDon) {
		this.dateDon = dateDon;
	}




	public boolean equals(Object o)
	{
		if(o instanceof Participation){
			Participation p = (Participation) o;
			return this.idP ==p.getIdP();
		}
		return false;
	}

	@Override
	public String toString() {
		return "Participation [idP=" + idP + ", nomDonateur=" + nomDonateur + ", montant=" + montant + ", dateDon="
				+ dateDon + "]";
	}

	
}
