package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.Attrezzo;



public class Labirinto {
	
	
	private Stanza stanzaCorrente; 
	private Stanza stanzaVincente;
	
	
	public Labirinto() {
		
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

	/**
	 * Metodo usato dal Builder per impostare la stanza da raggiungere
	 * per vincere la partita
	 */
	
	
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
}