package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando {
	
	private IO io;
	String aiuto = "aiuto";
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		for(String s : listaComandi) 
			io.mostraMessaggio(s+" ");
		System.out.println();

	}
	
	@Override
    public void setIo(IO io) {
        this.io = io;
    }


	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return this.aiuto;
	}

}
