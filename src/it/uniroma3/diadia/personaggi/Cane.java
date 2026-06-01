package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;

public class Cane extends AbstractPersonaggio {
	
	private static final String MESSAGGIO_ATTACCO="whof-whof";
	public Cane(String nome, String presentaz) {
		super(nome, presentaz);
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public String agisci(Partita partita) {
		
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		return MESSAGGIO_ATTACCO;
	}
}
