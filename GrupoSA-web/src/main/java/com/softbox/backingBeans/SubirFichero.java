/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.backingBeans;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.Part;

/**
 *
 * @author migue
 */
@Named(value = "subirFichero")
@RequestScoped
public class SubirFichero {
	private Part uploadedFile;
	private String folder = "C:\\files\\docs";

	public Part getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(Part uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	
	public void saveFile(Long idSocio){
		
		try (InputStream input = uploadedFile.getInputStream()) {
			String fileName = uploadedFile.getSubmittedFileName();
                        folder+="\\SC_"+idSocio.toString();
                        Path path = Paths.get(folder);
                        Files.createDirectories(path);
                        File file = new File(folder, fileName);
                        Files.copy(input, file.toPath());
	    }
	    catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
