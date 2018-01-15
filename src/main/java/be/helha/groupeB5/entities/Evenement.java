package be.helha.groupeB5.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Evenement implements Serializable {

	@Id
	@GeneratedValue
	private Integer idEv;
	private String titre, resume, urlImage;
	private double objectif, recolte;
	private Date dateEv;
	
	public Evenement(String titre, String resume, String urlImage, double objectif, double recolte, Date dateEv) {
		super();
		this.titre = titre;
		this.resume = resume;
		this.urlImage = urlImage;
		this.objectif = objectif;
		this.recolte = recolte;
		this.dateEv = dateEv;
	}
	
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

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
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
	
	
	
	public String toString() {
		return idEv + " : "+titre+" | "+resume;
	}
	
	
}
