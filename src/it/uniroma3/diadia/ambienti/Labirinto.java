package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.CaricatoreLabirinto;
import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;

public class Labirinto {

	private Stanza stanzaCorrente; 
	private Stanza stanzaVincente;

	// Costruttore vuoto di default (se serve per il builder)
	public Labirinto() {
	}

	// NUOVO COSTRUTTORE CHE LEGGE DA FILE
	public Labirinto(String nomeFile) throws FileNotFoundException, FormatoFileNonValidoException {
		CaricatoreLabirinto caricatore = new CaricatoreLabirinto(nomeFile);
		caricatore.carica(); // Legge tutto il file ed esegue i comandi del builder

		// Estraiamo il labirinto costruito e settiamo le stanze
		Labirinto labirintoCostruito = caricatore.getLabirinto();
		this.stanzaCorrente = labirintoCostruito.getStanzaCorrente();
		this.stanzaVincente = labirintoCostruito.getStanzaVincente();
	}

	public static LabirintoBuilder newBuilder() {
		return new LabirintoBuilder();
	}

	public static class LabirintoBuilder {

		private Labirinto labirinto;

		private Map<String, Stanza> nome2stanza; 

		private Stanza ultimaStanzaAggiunta; 

		public LabirintoBuilder() {
			this.labirinto = new Labirinto();
			this.nome2stanza = new HashMap<>();
		}

		public LabirintoBuilder addStanza(String nome) {
			Stanza stanza = new Stanza(nome);
			this.nome2stanza.put(nome, stanza);
			this.ultimaStanzaAggiunta = stanza;
			return this; 
		}

		public LabirintoBuilder addStanzaIniziale(String nome) {
			this.addStanza(nome);

			this.labirinto.setStanzaIniziale(this.nome2stanza.get(nome));
			this.labirinto.setStanzaCorrente(this.nome2stanza.get(nome));
			return this;
		}

		public LabirintoBuilder addStanzaVincente(String nome) {
			this.addStanza(nome);
			this.labirinto.setStanzaVincente(this.nome2stanza.get(nome));
			return this;
		}


		public LabirintoBuilder addStanzaMagica(String nome, int sogliaMagica) {
			Stanza stanza = new StanzaMagica(nome, sogliaMagica);
			this.nome2stanza.put(nome, stanza);
			this.ultimaStanzaAggiunta = stanza;
			return this;
		}

		public LabirintoBuilder addAttrezzo(String nome, int peso) {
			if (this.ultimaStanzaAggiunta != null) {
				Attrezzo a = new Attrezzo(nome, peso);
				this.ultimaStanzaAggiunta.addAttrezzo(a);
			}
			return this;
		}

		// Nuovo metodo per inserire l'attrezzo in una stanza specifica chiamata per nome
		public LabirintoBuilder addAttrezzo(String nomeStanza, String nomeAttrezzo, int peso) {
			Stanza stanza = this.nome2stanza.get(nomeStanza);
			if (stanza != null) {
				Attrezzo a = new Attrezzo(nomeAttrezzo, peso);
				stanza.addAttrezzo(a);
			}
			return this;
		}

		public LabirintoBuilder addAdiacenza(String stanzaPartenza, String stanzaDestinazione, String direzione) {
			Stanza s1 = this.nome2stanza.get(stanzaPartenza);
			Stanza s2 = this.nome2stanza.get(stanzaDestinazione);

			if (s1 != null && s2 != null) {
				s1.impostaStanzaAdiacente(direzione, s2);
			}
			return this;
		}

		public LabirintoBuilder addStanzaBuia(String nome, String attrezzoLuminoso) {
			Stanza stanza = new StanzaBuia(nome, attrezzoLuminoso);
			this.nome2stanza.put(nome, stanza);
			this.ultimaStanzaAggiunta = stanza;
			return this;
		}

		public LabirintoBuilder addStanzaBloccata(String nome, String direzioneBloccata, String attrezzoSbloccante) {
			Stanza stanza = new StanzaBloccata(nome, direzioneBloccata, attrezzoSbloccante);
			this.nome2stanza.put(nome, stanza);
			this.ultimaStanzaAggiunta = stanza;
			return this;
		}

		// Metodi per i Personaggi
		public LabirintoBuilder addMago(String nomeStanza, String nome, String presentazione, String nomeAttrezzo) {
			Stanza stanza = this.nome2stanza.get(nomeStanza);
			if (stanza != null) {
				Attrezzo bacchetta = new Attrezzo(nomeAttrezzo, 4); // Peso base a scelta
				stanza.setPersonaggio(new Mago(nome, presentazione, bacchetta));
			}
			return this;
		}

		public LabirintoBuilder addCane(String nomeStanza, String nome, String presentazione, String cibo) {
			Stanza stanza = this.nome2stanza.get(nomeStanza);
			if (stanza != null) {
				Attrezzo tesoroCane = new Attrezzo(cibo, 2);
				stanza.setPersonaggio(new Cane(nome, presentazione, tesoroCane));
			}
			return this;
		}

		public LabirintoBuilder addStrega(String nomeStanza, String nome, String presentazione,Borsa borsa) {
			Stanza stanza = this.nome2stanza.get(nomeStanza);

			if (stanza != null) {
				Borsa borsaDellaStrega = new Borsa();
				stanza.setPersonaggio(new Strega(nome, presentazione,borsaDellaStrega));
			}
			return this;
		}



		public Labirinto getLabirinto() {
			return this.labirinto;
		}
	}

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}

	public void setStanzaIniziale(Stanza stanzaIniziale) {
		this.stanzaCorrente = stanzaIniziale;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
}