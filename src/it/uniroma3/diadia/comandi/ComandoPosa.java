package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	private static IOConsole io=new IOConsole();
	private String attrezzoDaPosare;
	String posa = "posa";
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		this.posa(this.attrezzoDaPosare, partita);

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.attrezzoDaPosare=parametro;
	}
	
	public void posa(String attrezzo,Partita partita) {
		
		if(attrezzo!=null && partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo)) {
			Attrezzo a= partita.getGiocatore().getBorsa().getAttrezzo(attrezzo);
			partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo);
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(a);
			io.mostraMessaggio("Ho posato l'attrezzo " + a.getNome());
		}
		else {
			io.mostraMessaggio("Non ho posato niente perche non è presente quell'attrezzo in borsa");
		}
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return this.posa;
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.attrezzoDaPosare;
		
	}

}
