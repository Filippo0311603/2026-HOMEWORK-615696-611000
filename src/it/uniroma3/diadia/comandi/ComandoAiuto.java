package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
	static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi","posa","guarda"};
	private static IOConsole io=new IOConsole();
	String aiuto = "aiuto";
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		System.out.println();

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return this.aiuto;
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

}
