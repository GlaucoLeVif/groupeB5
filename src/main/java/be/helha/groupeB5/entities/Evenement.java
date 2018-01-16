package be.helha.groupeB5.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;


@Entity
public class Evenement implements Serializable {

	@Id
	@GeneratedValue
	private Integer idEv;
	private String titre, resume;
	private double objectif, recolte;
	private Date dateEv;
	@Lob
	private byte[] image1;
	
	public Evenement(String titre, String resume, byte[] image1, double objectif, double recolte, Date dateEv) {
		super();
		this.titre = titre;
		this.resume = resume;
		this.image1 = image1;
		this.objectif = objectif;
		this.recolte = recolte;
		this.dateEv = dateEv;
	}
	
	public Evenement() {}
	
	public Integer getIdEv() {
		return idEv;
	}
	public void setIdEv(Integer id) {
		this.idEv = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}


	public String getImage1() {
		//byte barray[] = Base64.getEncoder().encode(image1);
		return new String(image1);
	}

	public void setImage1(byte[] image1) {
		this.image1 = image1;
	}

	public double getObjectif() {
		return objectif;
	}

	public void setObjectif(double objectif) {
		this.objectif = objectif;
	}

	public double getRecolte() {
		return recolte;
	}

	public void setRecolte(double recolte) {
		this.recolte = recolte;
	}

	public Date getDateEv() {
		return dateEv;
	}

	public void setDateEv(Date dateEv) {
		this.dateEv = dateEv;
	}
	

	public boolean equals(Object o)
	{
		if(o instanceof Evenement){
			Evenement e = (Evenement) o;
			return this.idEv.equals(e.idEv) ;
		}
		return false;
	}
/*
	@Override
	public String toString() {
		return "Evenement [idEv=" + idEv + ", titre=" + titre + ", resume=" + resume 
				+ ", objectif=" + objectif + ", recolte=" + recolte + ", dateEv=" + dateEv + "]";
	}*/

	@Override
	public String toString() {
		return "Evenement [idEv=" + idEv + ", titre=" + titre + ", resume=" + resume + ", objectif=" + objectif
				+ ", recolte=" + recolte + ", dateEv=" + dateEv +  "]";
	}
	
	
	
	
	
	
	
}
