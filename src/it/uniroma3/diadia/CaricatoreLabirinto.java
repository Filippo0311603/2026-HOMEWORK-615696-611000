package it.uniroma3.diadia;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.giocatore.Borsa;

public class CaricatoreLabirinto {

	
	private static final String STANZE_MARKER = "Stanze:";             
	private static final String STANZE_BUIE_MARKER = "StanzeBuie:";
	private static final String STANZE_BLOCCATE_MARKER = "StanzeBloccate:";
	private static final String STANZE_MAGICHE_MARKER = "StanzeMagiche:";
	private static final String STANZA_INIZIALE_MARKER = "Inizio:";    
	private static final String STANZA_VINCENTE_MARKER = "Vincente:";  
	private static final String ATTREZZI_MARKER = "Attrezzi:";
	private static final String PERSONAGGI_MARKER = "Personaggi:";
	private static final String USCITE_MARKER = "Uscite:";

	private LineNumberReader reader;
	private Labirinto.LabirintoBuilder builder;

	
	public CaricatoreLabirinto(String nomeFile) throws FileNotFoundException {
		this.reader = new LineNumberReader(new FileReader(nomeFile));
		this.builder = Labirinto.newBuilder();
	}

	
	public CaricatoreLabirinto(StringReader stringReader) {
		this.reader = new LineNumberReader(stringReader);
		this.builder = Labirinto.newBuilder();
	}

	
	public void carica() throws FormatoFileNonValidoException {
		try {
			String riga;
			
			while ((riga = this.reader.readLine()) != null) {
				riga = riga.trim(); 
				
				
				if (riga.isEmpty() || riga.startsWith("#")) {
					continue; 
				}
				
				
				if (riga.startsWith(STANZE_MARKER)) leggiECreaStanze(riga);
				else if (riga.startsWith(STANZE_BUIE_MARKER)) leggiECreaStanzeBuie(riga);
				else if (riga.startsWith(STANZE_BLOCCATE_MARKER)) leggiECreaStanzeBloccate(riga);
				else if (riga.startsWith(STANZE_MAGICHE_MARKER)) leggiECreaStanzeMagiche(riga);
				else if (riga.startsWith(STANZA_INIZIALE_MARKER)) leggiIniziale(riga);
				else if (riga.startsWith(STANZA_VINCENTE_MARKER)) leggiVincente(riga);
				else if (riga.startsWith(ATTREZZI_MARKER)) leggiECollocaAttrezzi(riga);
				else if (riga.startsWith(PERSONAGGI_MARKER)) leggiECollocaPersonaggi(riga);
				else if (riga.startsWith(USCITE_MARKER)) leggiEImpostaUscite(riga);
				else throw new FormatoFileNonValidoException("Marcatore non riconosciuto alla riga " + this.reader.getLineNumber());
			}
		} catch (IOException e) {
			throw new FormatoFileNonValidoException("Errore durante la lettura del file alla riga " + this.reader.getLineNumber());
		} finally {
			try {
				if (this.reader != null) {
					this.reader.close(); 
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void leggiECreaStanze(String riga) {
		String nomiStanze = riga.substring(STANZE_MARKER.length());
		for(String nomeStanza : separaStringheAlleVirgole(nomiStanze)) {
			this.builder.addStanza(nomeStanza);
		}
	}

	private void leggiECreaStanzeBuie(String riga) {
		String specifiche = riga.substring(STANZE_BUIE_MARKER.length());
		for(String spec : separaStringheAlleVirgole(specifiche)) {
			try (Scanner sc = new Scanner(spec)) {
				if (sc.hasNext()) {
					String nomeStanza = sc.next();
					String attrezzoLuminoso = sc.next();
					this.builder.addStanzaBuia(nomeStanza, attrezzoLuminoso);
				}
			}
		}
	}

	private void leggiECreaStanzeBloccate(String riga) {
		String specifiche = riga.substring(STANZE_BLOCCATE_MARKER.length());
		for(String spec : separaStringheAlleVirgole(specifiche)) {
			try (Scanner sc = new Scanner(spec)) {
				if (sc.hasNext()) {
					String nomeStanza = sc.next();
					String direzioneBloccata = sc.next();
					String attrezzoSbloccante = sc.next();
					this.builder.addStanzaBloccata(nomeStanza, direzioneBloccata, attrezzoSbloccante);
				}
			}
		}
	}

	private void leggiECreaStanzeMagiche(String riga) {
		String specifiche = riga.substring(STANZE_MAGICHE_MARKER.length());
		for(String spec : separaStringheAlleVirgole(specifiche)) {
			try (Scanner sc = new Scanner(spec)) {
				if (sc.hasNext()) {
					String nomeStanza = sc.next();
					int soglia = Integer.parseInt(sc.next());
					this.builder.addStanzaMagica(nomeStanza, soglia);
				}
			}
		}
	}

	private void leggiIniziale(String riga) {
		String nomeStanza = riga.substring(STANZA_INIZIALE_MARKER.length()).trim();
		this.builder.addStanzaIniziale(nomeStanza);
	}

	private void leggiVincente(String riga) {
		String nomeStanza = riga.substring(STANZA_VINCENTE_MARKER.length()).trim();
		this.builder.addStanzaVincente(nomeStanza);
	}

	private void leggiECollocaAttrezzi(String riga) throws FormatoFileNonValidoException {
		String specifiche = riga.substring(ATTREZZI_MARKER.length());
		for(String spec : separaStringheAlleVirgole(specifiche)) {
			try (Scanner sc = new Scanner(spec)) {
				if (sc.hasNext()) {
					String nomeAttrezzo = sc.next();
					int peso = Integer.parseInt(sc.next());
					String nomeStanza = sc.next();
					this.builder.addAttrezzo(nomeStanza, nomeAttrezzo, peso);
				}
			} catch (NumberFormatException e) {
				throw new FormatoFileNonValidoException("Peso non numerico rilevato per un attrezzo alla riga " + this.reader.getLineNumber());
			}
		}
	}

	private void leggiEImpostaUscite(String riga) {
		String specifiche = riga.substring(USCITE_MARKER.length());
		for(String spec : separaStringheAlleVirgole(specifiche)) {
			try (Scanner sc = new Scanner(spec)) {
				if (sc.hasNext()) {
					String da = sc.next();
					String dir = sc.next();
					String a = sc.next();
					this.builder.addAdiacenza(da, a, dir);
				}
			}
		}
	}

	private void leggiECollocaPersonaggi(String riga) {
		String specifiche = riga.substring(PERSONAGGI_MARKER.length());
		for(String spec : separaStringheAlleVirgole(specifiche)) {
			try (Scanner sc = new Scanner(spec)) {
				
				if (sc.hasNext()) {
					String tipo = sc.next(); 
					
					if (!sc.hasNext()) continue; 
					String nomeStanza = sc.next();
					
					if (!sc.hasNext()) continue;
					String nomePersonaggio = sc.next();
					
					if (!sc.hasNext()) continue;
					
					String presentazione = sc.next().replace("_", " "); 
					
					
					String nomeAttrezzo = sc.hasNext() ? sc.next() : null; 
					
					
					if (tipo.equalsIgnoreCase("Mago")) {
						this.builder.addMago(nomeStanza, nomePersonaggio, presentazione, nomeAttrezzo);
					} else if (tipo.equalsIgnoreCase("Cane")) {
						this.builder.addCane(nomeStanza, nomePersonaggio, presentazione, nomeAttrezzo);
					} else if (tipo.equalsIgnoreCase("Strega")) {
						this.builder.addStrega(nomeStanza, nomePersonaggio, presentazione,new Borsa());
					}
				}
			}
		}
	}

	
	private List<String> separaStringheAlleVirgole(String string) {
		List<String> result = new LinkedList<>();
		Scanner scanner = new Scanner(string);
		scanner.useDelimiter(",");
		try (Scanner scannerDiParole = scanner) {
			while(scannerDiParole.hasNext()) {
				result.add(scannerDiParole.next().trim()); 
			}
		}
		return result;
	}

	
	public Labirinto getLabirinto() { 
		return this.builder.getLabirinto(); 
	}
}