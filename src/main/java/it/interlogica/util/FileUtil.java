package it.interlogica.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import it.interlogica.model.Telefono;

public class FileUtil {

	public static ArrayList<Telefono> leggiFile(File f) {
		ArrayList<Telefono> lista = new ArrayList<Telefono>();
		
		try {
			Scanner myReader = new Scanner(f);
			myReader.nextLine();
			myReader.nextLine();
			while (myReader.hasNextLine()) {
				String lineData = myReader.nextLine();
				System.out.println(lineData);
				Telefono tel = Converter.toTelefono(lineData);
				TelefonoUtil.checkDeleted(tel);
				System.out.println(tel.getId()+" "+tel.getSmsPhone());
				TelefonoUtil.whatState(tel);
				lista.add(tel);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		return lista;
	}
	
}
