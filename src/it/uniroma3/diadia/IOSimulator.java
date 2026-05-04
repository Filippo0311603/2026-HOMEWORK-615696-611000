package it.uniroma3.diadia;


public class IOSimulator implements IO {

	private String[] righeDaLeggere; 
	private int indiceRigaLetta;     
	
	private String[] messaggiMostrati; 
	private int indiceMessaggioMostrato; 

	public IOSimulator(String[] righeDaLeggere) {
		this.righeDaLeggere = righeDaLeggere;
		this.indiceRigaLetta = 0;
		this.messaggiMostrati = new String[1000];
		this.indiceMessaggioMostrato = 0;
	}

	@Override
	public void mostraMessaggio(String msg) {
		this.messaggiMostrati[this.indiceMessaggioMostrato] = msg;
		this.indiceMessaggioMostrato++;
	}

	@Override
	public String leggiRiga() {
		String riga = this.righeDaLeggere[this.indiceRigaLetta];
		this.indiceRigaLetta++;
		return riga;
	}
	
	
	public String[] getMessaggiMostrati() {
		return this.messaggiMostrati;
	}
}
