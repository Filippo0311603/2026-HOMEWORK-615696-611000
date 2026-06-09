package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio {
	
	private static final String MESSAGGIO_ATTACCO="whof-whof";
	private static final String CIBO_PREFERITO="osso";
	private static final String MESSAGGIO_REGALO = "Il cane mangia felice e lascia cadere un oggetto dalla bocca!";
	
	private Attrezzo attrezzo;
	
	public Cane(String nome, String presentaz,Attrezzo a) {
		super(nome, presentaz);
		this.attrezzo=a;
	}

	

	@Override
	public String agisci(Partita partita) {
		
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		return MESSAGGIO_ATTACCO;
	}



	@Override
	public String riceviRegalo(Attrezzo regalo, Partita partita) {
		
		if (regalo.getNome().equals(CIBO_PREFERITO)) {
			
			if (this.attrezzo != null) {
				partita.getStanzaCorrente().addAttrezzo(this.attrezzo);
				this.attrezzo = null;
			}
			return MESSAGGIO_REGALO;
		} else {
			
			return this.agisci(partita);
		}
	}
}
