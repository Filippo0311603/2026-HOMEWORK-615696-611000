package it.uniroma3.diadia;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configurazione {

	private static final String NOME_FILE = "diadia.properties";
	private static Properties costanti = null;

	
	private static void carica() {
		costanti = new Properties();
		try {
			
			InputStream input = Configurazione.class.getClassLoader().getResourceAsStream(NOME_FILE);
			if (input != null) {
				costanti.load(input);
			} else {
				System.err.println("File " + NOME_FILE + " non trovato!");
			}
		} catch (IOException e) {
			System.err.println("Errore nella lettura del file properties.");
		}
	}

	public static int getCFU() {
		if (costanti == null) {
			carica();
		}
		
		return Integer.parseInt(costanti.getProperty("cfu_iniziali"));
	}

	public static int getPesoMaxBorsa() {
		if (costanti == null) {
			carica();
		}
		return Integer.parseInt(costanti.getProperty("peso_max_borsa"));
	}
}