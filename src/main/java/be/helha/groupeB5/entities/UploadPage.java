package be.helha.groupeB5.entities;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

@Named
@ViewScoped
public class UploadPage implements Serializable {
	
	private Part uploadedFile;
	
	public byte[] uploadFile()
	{
		InputStream input=null;
		
		try {
			input=uploadedFile.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		byte[] image = null;
		
		try {
			image = IOUtils.toByteArray(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return image;
		
	}

	public Part getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(Part uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
	
	
}
