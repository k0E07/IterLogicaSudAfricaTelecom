package it.interlogica.util;

import it.interlogica.model.Telefono;

public class Converter {

	public static Telefono toTelefono(String linea) {
		Telefono tel = null;
		int saveI=0;
		boolean trovato=false;
		int n=linea.length();
		for(int i=0;i<n;i++) {
			char c=linea.charAt(i);
			if(c==';') {
				trovato=true;
				saveI=i;
				break;
			}
		}
		if(trovato) {
			String id=linea.substring(0,saveI);
			String sms=linea.substring(saveI+1,n);
			tel=new Telefono();
			tel.setId(id);
			tel.setSmsPhone(sms);
		}
		return tel;
	}
	
	
}
