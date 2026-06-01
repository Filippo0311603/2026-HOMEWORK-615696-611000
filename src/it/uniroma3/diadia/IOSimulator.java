package it.uniroma3.diadia;

import java.util.HashMap;
import java.util.Map;

public class IOSimulator implements IO {

	private Map<Integer,String> righeDaLeggere; 
	private int indiceRigaLetta;     
	
	private Map<Integer,String> messaggiMostrati; 
	private int indiceMessaggioMostrato; 

	public IOSimulator(Map<Integer,String> righeDaLeggere) {
		this.righeDaLeggere = righeDaLeggere;
		this.indiceRigaLetta = 0;
		this.messaggiMostrati = new HashMap<Integer,String>();
		this.indiceMessaggioMostrato = 0;
	}

	@Override
	public void mostraMessaggio(String msg) {
		this.messaggiMostrati.put(this.indiceMessaggioMostrato,msg);
		this.indiceMessaggioMostrato++;
	}

	@Override
	public String leggiRiga() {
		String riga = this.righeDaLeggere.get(this.indiceRigaLetta);
		this.indiceRigaLetta++;
		return riga;
	}
	
	
	public Map<Integer,String> getMessaggiMostrati() {
		return this.messaggiMostrati;
	}
}
