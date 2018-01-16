package be.helha.groupeB5.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Participation implements Serializable {

	@Id
	@GeneratedValue
	private Integer idP;
	private float montant;
	private Date dateDon;
	@OneToOne(cascade=CascadeType.ALL)
	private Membre m;
	@OneToOne(cascade=CascadeType.ALL)
	private Evenement e;
	
	public Participation(float montant,Date dateDon,Membre m,Evenement e)
	{
		this.montant= montant;
		this.dateDon= dateDon;
		this.m = m;
		this.e = e;
	}

	public Participation() {}
	
	
	
	public Integer getIdP() {
		return idP;
	}

	public void setIdP(Integer idP) {
		this.idP = idP;
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

	public Membre getM() {
		return m;
	}

	public void setM(Membre m) {
		this.m = m;
	}

	public Evenement getE() {
		return e;
	}

	public void setE(Evenement e) {
		this.e = e;
	}
	

	public boolean equals(Object o)
	{
		if(o instanceof Participation){
			Participation p = (Participation) o;
			return this.m.equals(p.getM()) && this.e.equals(p.getE());
		}
		return false;
	}

	@Override
	public String toString() {
		return "Participation [montant=" + montant + ", dateDon=" + dateDon + ", m=" + m + ", e=" + e + "]";
	}

	
	
	
	
}
