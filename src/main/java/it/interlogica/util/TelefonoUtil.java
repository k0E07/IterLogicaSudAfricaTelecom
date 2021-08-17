package it.interlogica.util;

import it.interlogica.model.Telefono;

public class TelefonoUtil {

	public static String whatState(Telefono tel) {
		String risultato = null;
		boolean tuttiNumeri = areAllNumbers(tel.getSmsPhone());
		int lun = tel.getSmsPhone().length();
		if (tuttiNumeri && lun==11)
			risultato = "Okay";
		else
			risultato = "Wrong";
		tel.setRisultato(risultato);
		return risultato;
	}

	private static boolean areAllNumbers(String tel) {
		int n = tel.length();
		int i = 0;
		boolean wrong=false;
		for (; i < n; i++) {
			char c = tel.charAt(i);
			if (!NumeroUtil.isNumber(c)) {
				wrong=true;
				break;
			}
				
		}
		if (wrong)
			return false;
		return true;
	}

	public static void checkDeleted(Telefono tel) {
		String newSmsPhone = null;
		String smsPhone = tel.getSmsPhone();
		int lun = smsPhone.length();
		if (smsPhone.contains("DELETED")) {
			tel.setSmsPhone("");
//			System.out.println("---------------------------------------->>>>>>>>>>>");
//			int idxDEL = smsPhone.indexOf("_DELETED_");
//			System.out.println("idxDEL=" + idxDEL);
//			newSmsPhone = smsPhone.substring(idxDEL, lun);
//			tel.setSmsPhone(newSmsPhone);
		}
	}
}
