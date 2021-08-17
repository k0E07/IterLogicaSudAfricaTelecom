package com.mkyong.common.action;

import java.io.File;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import it.interlogica.model.Telefono;
import it.interlogica.util.FileUtil;
import it.interlogica.util.DataAccessLayer;
import it.interlogica.util.TelefonoUtil;

public class FileUploadAction extends ActionSupport{

	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;

	public String getFileUploadContentType() {
		return fileUploadContentType;
	}

	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}

	public String getFileUploadFileName() {
		return fileUploadFileName;
	}

	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}

	public File getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}

	@Override
	public String execute() throws Exception{
		System.out.println("execute()");
		if(getFileUpload()!=null) {
			ArrayList<Telefono> lista = FileUtil.leggiFile(this.getFileUpload());
			DataAccessLayer.pulisciTblTelefoniRis();
			DataAccessLayer.salvaTelefoni(lista);
			return SUCCESS;
		}
		//boolean esiste=this.getFileUpload().exists();
//		System.out.println(esiste);
//		JdbcUtil.openConnDb();
//		ArrayList<Telefono> lista = FileUtil.leggiFile(this.getFileUpload());
//		JdbcUtil.pulisciTblTelefoniRis();
//		JdbcUtil.salvaTelefoni(lista);
//		JdbcUtil.closeConnDb();
		//return SUCCESS;
//		return NONE;
		return INPUT;
	}
	
//	public String display() {
//		return NONE;
//	}
	
}