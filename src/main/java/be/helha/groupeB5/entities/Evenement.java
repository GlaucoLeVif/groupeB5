package be.helha.groupeB5.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;



@Entity
public class Evenement implements Serializable {

	@Id
	@GeneratedValue
	private Integer idEv;
	private String titre, resume,lieu;
	private double objectif, recolte;
	private int etat;
	private Date dateEv;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,orphanRemoval=true)
	private List<Image> images;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,orphanRemoval=true)
	private List<Participation> parts;
	
	
	
	public Evenement(String titre, String resume, String lieu, double objectif, double recolte, int etat,
			Date dateEv) {
		super();
		this.titre = titre;
		this.resume = resume;
		this.lieu = lieu;
		this.objectif = objectif;
		this.recolte = recolte;
		this.etat = etat;
		this.dateEv = dateEv;
		this.images = new ArrayList<>();
		this.parts = new ArrayList<>();
	}

	public Evenement() {}
	
	public int getSize() {
		System.out.println("size ="+images.size());
		return images.size();
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

	public String getImage(int num)
	{
		/*if(images.size()>num)
		{
			int index = 0;
		    for(Image element : images){
		      if(index == num){
		        return element.getImage();
		      }
		      index++;
		    }
		}*/
		return images.get(num).getImage();
	}
	

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public List<Participation> getParts() {
		return parts;
	}

	public void setParts(List<Participation> parts) {
		this.parts = parts;
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
	
	

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	
	public void addImage(Image img)
	{
		System.out.println("ajout dans ev");
		images.add(img);
	}
	
	public void removeImage(Image img)
	{
		images.remove(img);
	}
	
	public void addPart(Participation p)
	{
		parts.add(p);
	}
	
	public void removePart(Participation p)
	{
		parts.remove(p);
	}

	public boolean equals(Object o)
	{
		if(o instanceof Evenement){
			Evenement e = (Evenement) o;
			return this.idEv.equals(e.idEv) ;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Evenement [idEv=" + idEv + ", etat=" + etat + ", titre=" + titre + ", resume=" + resume + ", lieu="
				+ lieu + ", objectif=" + objectif + ", recolte=" + recolte + ", dateEv=" + dateEv + "]";
	}


	
	
	
	
	
	
	
}
