package be.helha.groupeB5.entities;

import java.io.Serializable;
import java.util.Base64;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Image implements Serializable {

	@Id
	@GeneratedValue
	private Integer idImg;
	@Lob
	private byte[] image;
	
	public Image(byte[] image) {
		super();
		this.image = image;
	}
	
	public Image() {}

	public Integer getIdImg() {
		return idImg;
	}

	public void setIdImg(Integer idImg) {
		this.idImg = idImg;
	}

	public String getImage() {
		byte barray[] = Base64.getEncoder().encode(image);
		return new String(barray);
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
	
}
