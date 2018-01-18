package be.helha.groupeB5.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Membre implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idMembre;
	private String login, mdp, mail, prenom, nom, rue,numRue, ville, pays, nationalite, numGSM;
	private Date dateN;
	private int cp;
	private boolean isAdmin;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Evenement> listEvent = new ArrayList<Evenement>();

	public Membre(String login, String mdp, String mail, String prenom, String nom, String rue, String ville,
			String pays, String nationalite, String numGSM, Date dateN, String numRue, int cp, boolean isAdmin,List<Evenement> listEvent) {
		super();
		this.login = login;
		this.mdp = mdp;
		this.mail = mail;
		this.prenom = prenom;
		this.nom = nom;
		this.rue = rue;
		this.ville = ville;
		this.pays = pays;
		this.nationalite = nationalite;
		this.numGSM = numGSM;
		this.dateN = dateN;
		this.numRue = numRue;
		this.cp = cp;
		this.isAdmin = isAdmin;
		this.listEvent = listEvent;
	}
	
	public Membre() {
		
	}
	
	

	public Integer getIdMembre() {
		return idMembre;
	}

	public void setIdMembre(Integer idMembre) {
		this.idMembre = idMembre;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getNumGSM() {
		return numGSM;
	}

	public void setNumGSM(String numGSM) {
		this.numGSM = numGSM;
	}

	public Date getDateN() {
		return dateN;
	}

	public void setDateN(Date dateN) {
		this.dateN = dateN;
	}

	public String getNumRue() {
		return numRue;
	}

	public void setNumRue(String numRue) {
		this.numRue = numRue;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	

	public List<Evenement> getListEvent() {
		return listEvent;
	}

	public void setListEvent(List<Evenement> listEvent) {
		this.listEvent = listEvent;
	}

	public boolean equals(Object o)
	{
		if(o instanceof Membre){
			Membre m = (Membre) o;
			return this.login.equals(m.login);
		}
		return false;
	}

	@Override
	public String toString() {
		return "Membre [idMembre=" + idMembre + ", login=" + login + ", mdp=" + mdp + ", mail=" + mail + ", prenom="
				+ prenom + ", nom=" + nom + ", rue=" + rue + ", ville=" + ville + ", pays=" + pays + ", nationalite="
				+ nationalite + ", numeroGSM=" + numGSM + ", dateN=" + dateN + ", numRue=" + numRue + ", cp=" + cp
				+ ", isAdmin=" + isAdmin + "]";
	}


	
	
	
	
}
