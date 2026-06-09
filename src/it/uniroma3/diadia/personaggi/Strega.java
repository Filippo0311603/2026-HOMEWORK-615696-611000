package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class Strega extends AbstractPersonaggio{

	private static final String MESSAGGIO_SE_NON_SALUTATA = "Hi Hi Hi, " +
			"con una mia magica azione, andrai in una stanza " +
			"con meno attrezzi!";
	private static final String MESSAGGIO_SE_SALUTA = "Oh, sarò buona, andrai in una stanza con più attrezzi...";
	
	private static final String MESSAGGIO_REGALO="Ah ah ah ah";
	
	private Borsa b;
	
	public Strega(String nome, String presentazione, Borsa borsa) {
		super(nome, presentazione);
		this.b=borsa;
		
		
	}
	@Override
	public String agisci(Partita partita) {
		String msg;
		int max=0;
		Stanza h=null;
		int min=1000000000;
		Stanza l=null;
		for(Stanza s : partita.getStanzaCorrente().getStanzeAdiacenti().values()) {
			if(s.getNumeroAttrezzi()>max) {
				max=s.getNumeroAttrezzi();
				h=s;
			}
			if(s.getNumeroAttrezzi()<min) {
				min=s.getNumeroAttrezzi();
				l=s;
			}

		}
		if (this.haSalutato()) {
			
			partita.setStanzaCorrente(h);
			msg=MESSAGGIO_SE_SALUTA;
			return msg;

		}
		partita.setStanzaCorrente(l);
		msg=MESSAGGIO_SE_NON_SALUTATA;
		return msg;
		
		
		
		
}
	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		
		b.addAttrezzo(attrezzo);
		return MESSAGGIO_REGALO;
	}
}
