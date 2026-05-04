package it.uniroma3.diadia;


import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;


/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	

	private Partita partita;
	private static IO io;

	public DiaDia(IO io) {
		this.partita = new Partita();
		this.io=io;
	}

	public void gioca() {
		String istruzione; 
		//Scanner scannerDiLinee;

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		//scannerDiLinee = new Scanner(System.in);		
		do		
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}
	
	/*public void prendi(String attrezzo) {
		if(attrezzo!= null && partita.labirinto.getStanzaCorrente().hasAttrezzo(attrezzo)) {
			Attrezzo a=partita.labirinto.getStanzaCorrente().getAttrezzo(attrezzo);
			partita.labirinto.getStanzaCorrente().removeAttrezzo(attrezzo);
			partita.giocatore.borsa.addAttrezzo(a);
			io.mostraMessaggio("Ho preso l'attrezzo "+ a.getNome());
		}
		else {
			io.mostraMessaggio("Non ho preso niente perche non è presente quell'attrezzo nella stanza");
		}
	}+/
	
	/*public void posa(String attrezzo) {
		if(attrezzo!=null && partita.giocatore.borsa.hasAttrezzo(attrezzo)) {
			Attrezzo a= partita.giocatore.borsa.getAttrezzo(attrezzo);
			partita.giocatore.borsa.removeAttrezzo(attrezzo);
			partita.labirinto.getStanzaCorrente().addAttrezzo(a);
			io.mostraMessaggio("Ho posato l'attrezzo" + a.getNome());
		}
		else {
			io.mostraMessaggio("Non ho posato niente perche non è presente quell'attrezzo in borsa");
		}
	}*/


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())

		io.mostraMessaggio("Hai vinto!");
		if (!this.partita.giocatoreIsVivo())

			io.mostraMessaggio("Hai esaurito i CFU...");

		return this.partita.isFinita();
		}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	/*private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		System.out.println();
	}*/

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			io.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu);
		}
		io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	/*private void fine() {
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}*/
	
	public Partita getPartita() {
		return this.partita;
	}

	public static void main(String[] argc) {
		IO io = new IOConsole();
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
	}
}