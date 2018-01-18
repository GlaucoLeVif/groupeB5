package be.helha.groupeB5.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import be.helha.groupeB5.entities.Membre;
import be.helha.groupeB5.entities.Participation;
import be.helha.groupeB5.sessionejb.GestionParticipationEJB;

@Named
@RequestScoped
public class ParticipationController {

	@EJB
	private GestionParticipationEJB gestionParticipationEJB;
	private String nomDonateur;
	private float montant;
	private Date dateDon;
	
	public ParticipationController() {}
	
	
	
	public List<Participation> doAfficherParticipation() {
		return gestionParticipationEJB.selectAll();
	}
	
	public Participation doAjouterParticipation() {
		Participation p = new Participation(nomDonateur, montant, dateDon);
		return gestionParticipationEJB.addParticipation(p);
	}
	
	public Participation doSupprimerParticipation(Participation p) {
		return gestionParticipationEJB.deleteParticipation(p);
	}
	
	public String afficherDateDuJour() {
		String format = "dd/MM/yyyy"; 

		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format ); 
		java.util.Date date = new java.util.Date(); 

		return formater.format(date);
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
	
	
	
	
	
	
}
