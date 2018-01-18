package be.helha.groupeB5.controller;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import be.helha.groupeB5.entities.Evenement;
import be.helha.groupeB5.entities.Image;
import be.helha.groupeB5.entities.MailGestion;
import be.helha.groupeB5.entities.Participation;
import be.helha.groupeB5.entities.UploadPage;
import be.helha.groupeB5.sessionejb.GestionEvenementEJB;
import be.helha.groupeB5.sessionejb.GestionMembreEJB;
import be.helha.groupeB5.sessionejb.GestionParticipationEJB;

@ManagedBean  
@SessionScoped
public class EvenementController {

	@EJB
	GestionEvenementEJB gestionEvenementEJB;
	@EJB
	GestionMembreEJB gestionMembreEJB;
	@EJB
	GestionParticipationEJB gestionParticipationEJB;
	
	private String titre, resume,lieu;
	private double objectif, recolte;
	private int etat;
	private Date dateEv;
	private Evenement event = new Evenement();
	private Set<Participation> parts = new HashSet<Participation>();
	private List<Evenement> lastEvents = new ArrayList<Evenement>();
	private List<Participation> lastParts = new ArrayList<Participation>();
	
	public List<Participation> getLastParts() {
		if(lastParts.size()<5) {
			List<Participation> tempList = gestionParticipationEJB.selectAll();
			for(int i = tempList.size()-1 ; i>tempList.size()-6;i--) {
				if(i<0 || tempList.get(0).equals(null)) {
					return lastParts;
				}
				lastParts.add(tempList.get(i));
			}
			return lastParts;
		}
		return lastParts;
	}


	public void setLastParts(List<Participation> lastParts) {
		this.lastParts = lastParts;
	}


	public List<Evenement> getLastEvents() {
		if(lastEvents.size()<5) {
			List<Evenement> tempList = gestionEvenementEJB.selectAll();
			for(int i = tempList.size()-1 ; i>tempList.size()-6;i--) {
				if(i<0) {
					return lastEvents;
				}
				lastEvents.add(tempList.get(i));
			}
			return lastEvents;
		}
		return lastEvents;
	}


	public void setLastEvents(List<Evenement> lastEvents) {
		this.lastEvents = lastEvents;
	}


	private byte[] image1;
	private File file1;
	private UploadPage up = new UploadPage();
	private MailGestion mailG = new MailGestion();
	
	public EvenementController() {}
	

	public List<Evenement> doAfficherEvenement() {
		System.out.println("doafficher");
		return gestionEvenementEJB.selectAll();
	}
	
	public void doModifierEvenement() {
		System.out.println(ConnexionController.getMembre().toString());
		gestionMembreEJB.UpdateMembre(ConnexionController.getMembre());
	}
	
	public void doSupprimerEvenement(Evenement e) {
		lastEvents.clear();
		ConnexionController.getMembre().removeEv(e);
		gestionMembreEJB.UpdateMembre(ConnexionController.getMembre());
		//return gestionEvenementEJB.deleteEvenement(e);
	}
	
	public Set<Participation> doAjouterParticipation() {
		lastParts.clear();
		return parts;
	}
	
	public String doDetails(Evenement e)
	{
		event = e;
		return "detailsEvenement.xhtml?faces-redirect=false";
	}
	
	public String doEvenement()
	{
		return "indexEvent.xhtml?faces-redirect=true";
	}
	
	
	public String doIndex()
	{
		return "index.xhtml?faces-redirect=true";
	}
	
	public void doAjouterPhoto(Evenement e)
	{
		List<Evenement> evs = ConnexionController.getMembre().getListEvent();
		System.out.println(evs);
		int pos = evs.indexOf(e);
		System.out.println(pos);
		ConnexionController.getMembre().getListEvent().get(pos).addImage(new Image(up.uploadFile()));
		doModifierEvenement();
	}
	
	public void doAjouterEvenement() {
		Image i1 = new Image(up.uploadFile());
		Evenement e = new Evenement(titre, resume, lieu, objectif, recolte,etat, dateEv);
		e.addImage(i1);
		
		System.out.println("stade1");
		Date d = new Date();
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			d = format.parse("05/02/1997");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println(ConnexionController.getMembre().toString());
		ConnexionController.getMembre().addEv(e);
		doModifierEvenement();
		sendEmail();
		
		
		
		//Evenement e = new Evenement("titre"+System.currentTimeMillis(), "resume1", null, 5000.00, 0, d);
		//System.out.println(e.toString());
		//return gestionEvenementEJB.addEvenement(e);
		//return null;
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

	public byte[] getImage1() {
		return image1;
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
	
	
	
	public String getLieu() {
		return lieu;
	}


	public void setLieu(String lieu) {
		this.lieu = lieu;
	}


	public int getEtat() {
		return etat;
	}


	public void setEtat(int etat) {
		this.etat = etat;
	}


	public Date getDateEv() {
		return dateEv;
	}
	public void setDateEv(Date dateEv) {
		this.dateEv = dateEv;
	}
	public Evenement getEvent() {
		return event;
	}
	public void setEvent(Evenement event) {
		this.event = event;
	}


	public File getFile1() {
		return file1;
	}


	public void setFile1(File file1) {
		this.file1 = file1;
	}


	public UploadPage getUp() {
		return up;
	}


	public void setUp(UploadPage up) {
		this.up = up;
	}
	
	
	public void sendEmail()
	{
		mailG.sendMail(ConnexionController.getMembre().getLogin(),titre,lieu);
	}
	
	public Set<Participation> getParts() {
		return parts;
	}
	public void setParts(Set<Participation> parts) {
		this.parts = parts;
	}
	
	
	
	
}
