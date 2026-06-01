package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando {
	private static IOConsole io=new IOConsole();
	String guarda = "guarda";
	
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		io.mostraMessaggio("In questo momento ti trovi nella stanza"+partita.getStanzaCorrente().toString());
		io.mostraMessaggio("Partita vinta:"+this.vintaONo(partita)+ "\nCFU totali giocatore:"+ partita.getGiocatore().getCfu());
	}

	
	
	public String vintaONo(Partita partita) {
		if(partita.isFinita()) {
			String si=new String("SI");
			return si;
		}
		else {
			String no=new String("NO");
			return no;
		}
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return this.guarda;
	}

	
}
