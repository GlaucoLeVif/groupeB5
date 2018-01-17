package be.helha.groupeB5.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

import be.helha.groupeB5.entities.Evenement;
import be.helha.groupeB5.entities.Membre;
import be.helha.groupeB5.sessionejb.GestionEvenementEJB;

@Named
@RequestScoped
public class EvenementController {

	@EJB
	GestionEvenementEJB gestionEvenementEJB;
	private String titre, resume;
	private double objectif, recolte;
	private Date dateEv;
	private Evenement event = new Evenement();
	
	private byte[] image1;
	private File file1;
	
	public EvenementController() {}
	

	public List<Evenement> doAfficherEvenement() {
		return gestionEvenementEJB.selectAll();
	}
	
	public Membre doModifierEvenement() {
		return null;
	}
	
	public Evenement doSupprimerEvenement(Evenement e) {
		return gestionEvenementEJB.deleteEvenement(e);
	}
	
	public String doDetails(Evenement e )
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
	
	
	public void aaa() {
		System.out.println("test");
	}
	
	public Evenement doAjouterEvenement() {
		/*convertImage();
		Evenement e = new Evenement(titre, resume, image1, objectif, recolte, dateEv);
		System.out.println(e.getImage1());*/
		System.out.println("stade1");
		Date d = new Date();
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			d = format.parse("05/02/1997");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Evenement e = new Evenement("titre"+System.currentTimeMillis(), "resume1", null, 5000.00, 0, d);
		//System.out.println(e.toString());
		return gestionEvenementEJB.addEvenement(e);
		//return null;
	}
	
	public void convertImage()
	{
		
		
		//init array with file length
		//image1 = new byte[(int) file1.length()]; // ca bug ici
/*
		FileInputStream fis;
		try {
			fis = new FileInputStream(file1);
			fis.read(image1);
			fis.close();
			System.out.println("réussi !");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //read file into bytes[]
		
		System.out.println("Je passe");*/
		
		/*
		InputStream input = file1.getInputStream();
		byte[] image = IOUtils.toByteArray(input); // Apache commons IO.
		someEntity.setImage(image);*/
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
	
	
	
	
	
	
}
