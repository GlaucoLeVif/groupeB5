package be.helha.groupeB5.entities;

import java.util.Date;

public class Evenement {

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
	
	
}
