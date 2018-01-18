package be.helha.groupeB5.entities;

import java.security.Key;

public class MembreConnecte {
	
	private Membre m;
	private String token;
	private Key key;
	
	private static MembreConnecte instance=null;
	
	public static MembreConnecte getInstance() {
		if(instance==null) {
			instance = new MembreConnecte();
		}
		return instance;
	}
	
	private MembreConnecte(Membre m, String token, Key key) {
		this.m = m;
		this.token = token;
		this.key = key;
	}
	
	private MembreConnecte() {
	}
	
	public Membre getM() {
		return m;
	}
	public void setM(Membre m) {
		this.m = m;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Key getKey() {
		return key;
	}
	public void setKey(Key key) {
		this.key = key;
	}
}
