package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {
	private static IOConsole io=new IOConsole();
	
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		io.mostraMessaggio("Il comando selezionato non è valido, per conoscere i comandi disponibili scrivi il comando aiuto");
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

}
