package com.mkyong.common.action;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import it.interlogica.model.Telefono;
import it.interlogica.util.DataAccessLayer;

public class RisultatoAction extends ActionSupport {

	private List<Telefono> listaTel;
	
	public List<Telefono> getListaTel() {
		return listaTel;
	}

	public void setListaTel(List<Telefono> listaTel) {
		this.listaTel = listaTel;
	}

	@Override
	public String execute() throws Exception {
		List<Telefono> lista = DataAccessLayer.leggiRisultato();
		this.setListaTel(lista);
		return SUCCESS;
	}


}