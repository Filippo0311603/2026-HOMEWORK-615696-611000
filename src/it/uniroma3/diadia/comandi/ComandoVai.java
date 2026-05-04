package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
	private String direzione;

	private static IOConsole io=new IOConsole();
	String vai = "vai";

	/**
	 * esecuzione del comando
	 */
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente= partita.getStanzaCorrente();
		Stanza prossimaStanza=null;
		if(direzione==null) {
			io.mostraMessaggio("Dove vuoi andare? Devi specificare la direzione");
			return;
		}
		prossimaStanza=stanzaCorrente.getStanzaAdiacente(this.direzione);
		if(prossimaStanza==null) {
			io.mostraMessaggio("Direzione inesistente");
			return;
		}
		partita.setStanzaCorrente(prossimaStanza);
		io.mostraMessaggio(partita.getStanzaCorrente().getNome());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
	}
	
	@Override
	public void setParametro(String parametro) {
		this.direzione=parametro;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return this.vai;
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.direzione;
	}
}
