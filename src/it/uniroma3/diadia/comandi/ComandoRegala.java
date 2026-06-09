package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoRegala extends AbstractComando {

	String regala = "regala";
	private String messaggio;
	private IO io;
	private static final String MESSAGGIO_REGALO =

			"Ti ho regalato l'attrezzo:";
	
	private static final String MESSAGGIO_NON_REGALO="Non c'è nessuno a cui regalare qualcosa qui!";
	
	@Override
    public void setIo(IO io) {
        this.io = io;
    }
	
	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		personaggio = partita.getStanzaCorrente().getPersonaggio();
		String nomeAttrezzo=this.getParametro();
		if (personaggio!=null) {
			if(partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
				Attrezzo attrezzoDaRegalare = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
				partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
				this.messaggio=partita.getStanzaCorrente().getPersonaggio().riceviRegalo(attrezzoDaRegalare, partita);
				io.mostraMessaggio(this.messaggio);

			}
			else {
				io.mostraMessaggio("Non hai nessun attrezzo da regalare");
			}
			

		} 
		else io.mostraMessaggio(MESSAGGIO_NON_REGALO);
		
	}
	

	@Override
	public String getNome() {
		return this.regala;
	}

}
