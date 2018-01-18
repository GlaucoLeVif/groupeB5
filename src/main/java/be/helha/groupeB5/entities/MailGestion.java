package be.helha.groupeB5.entities;

import java.io.Serializable;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;



import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class MailGestion implements Serializable {

	
	public void sendMail(String nomCreateur,String nomEv,String nomLieu)
	{	
		 		final String username = "servicemsfmail@gmail.com";
		        final String password = "msf123456";
		  
		 
		         Properties props = new Properties();
		         props.put("mail.smtp.auth", "true");
		         props.put("mail.smtp.starttls.enable", "true");
		         props.put("mail.smtp.host", "smtp.gmail.com");
		         props.put("mail.smtp.port", "587");
		 
		  
		         Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		        	 protected PasswordAuthentication getPasswordAuthentication() {
		        		 return new PasswordAuthentication(username,password);
		        	 }
		         });
		 
		         try {
		             Message message = new MimeMessage(session);
		             message.setFrom(new InternetAddress("alex.10101997@gmail.com"));
		             message.setRecipients(Message.RecipientType.TO,
		             InternetAddress.parse("alex.10101997@gmail.com"));
		             message.setSubject("Notif - Ajout d'un evenement - ");
		             message.setText("Un nouvel événement a été créé par "+nomCreateur+" au sujet de "+nomEv+" et se déroule à "+nomLieu+". \nPour gérer vos événements, rendez-vous sur le site dans la section gérer les événements : http://54.76.209.52:5080/groupeB5/");
		             Transport.send(message);
		 
		             System.out.println("Envoyé");
		 
		         } catch (MessagingException e) {
		             throw new RuntimeException(e);
		         }

/*
		final String username = "servicemsfmail@gmail.com";
        final String password = "msf123456";
  
		
		 
		
		        Properties props = new Properties();
		
		        props.put("mail.smtp.host", "smtp.gmail.com");
		
		        props.put("mail.smtp.socketFactory.port", "465");
		
		        props.put("mail.smtp.socketFactory.class",
		
		                "javax.net.ssl.SSLSocketFactory");
		
		        props.put("mail.smtp.auth", "true");
		
		        props.put("mail.smtp.port", "465");
		
		 
		
		        Session session = Session.getDefaultInstance(props,
		
		                new javax.mail.Authenticator() {
		
		                    protected PasswordAuthentication getPasswordAuthentication() {
		
		                       return new PasswordAuthentication(username,password);
		
		                    }
		
		                });
		
		 
		
		        try {
		
	
		
		            Message message = new MimeMessage(session);
		
		            message.setFrom(new InternetAddress("alex.10101997@gmail.com"));
		
		            message.setRecipients(Message.RecipientType.TO,
		
		                    InternetAddress.parse("alex.10101997@gmail.com"));
		
		            message.setSubject("Test JCG Example");
		
		            message.setText("Hi," +
		
		                    "This is a Test mail for JCG Example!");
		
		 
		
		            Transport.send(message);
		
		 
		
		            System.out.println("Mail sent succesfully!");
		
		 
		
		        } catch (MessagingException e) {
		
		           throw new RuntimeException(e);
		
		        }
*/

	}

}
