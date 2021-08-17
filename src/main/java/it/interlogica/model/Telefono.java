package it.interlogica.model;

public class Telefono {
	private String id = null;
	private String smsPhone = null;
	private String risultato = null; // Okay, Wrong, Corretto

	public Telefono() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSmsPhone() {
		return smsPhone;
	}

	public void setSmsPhone(String smsPhone) {
		this.smsPhone = smsPhone;
	}

	public String getRisultato() {
		return risultato;
	}

	public void setRisultato(String risultato) {
		this.risultato = risultato;
	}

}
