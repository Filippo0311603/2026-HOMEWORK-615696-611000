package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.Configurazione;

public class Giocatore {
	
	private Borsa borsa;
	//static final private int CFU_INIZIALI = 20;
	private int cfu;
	
	
	public Giocatore() {
		this.cfu = Configurazione.getCFU();
		this.borsa=new Borsa();
		
	}
	
	
	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}
	public Borsa getBorsa() {
		return this.borsa;
	}
	
	
}
