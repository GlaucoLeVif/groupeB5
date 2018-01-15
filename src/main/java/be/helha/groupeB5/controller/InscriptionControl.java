package be.helha.groupeB5.controller;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class InscriptionControl {

	private String login, mdp, mail, prenom, nom, rue, ville, pays, nationalite, numeroGSM;
	private Date dateN;
	private int numRue, cp;
	private boolean isAdmin;
	
	public InscriptionControl() {}
}
