package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
	private static IOConsole io=new IOConsole();
	String prendi = "prendi";
	private String attrezzoDaPrendere;
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		this.prendi(attrezzoDaPrendere, partita);

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.attrezzoDaPrendere=parametro;

	}
	
	public void prendi(String attrezzo, Partita partita) {
		if(attrezzo!= null && partita.getLabirinto().getStanzaCorrente().hasAttrezzo(attrezzo)) {
			Attrezzo a=partita.getLabirinto().getStanzaCorrente().getAttrezzo(attrezzo);
			partita.getLabirinto().getStanzaCorrente().removeAttrezzo(attrezzo);
			partita.getGiocatore().getBorsa().addAttrezzo(a);
			io.mostraMessaggio("Ho preso l'attrezzo "+ a.getNome());
		}
		else {
			io.mostraMessaggio("Non ho preso niente perche non è presente quell'attrezzo nella stanza");
		}
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return this.prendi;
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.attrezzoDaPrendere;
	}
}
