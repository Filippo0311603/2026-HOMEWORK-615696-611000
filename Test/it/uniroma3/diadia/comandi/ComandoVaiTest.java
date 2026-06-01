package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.LabirintoBuilder;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.ComandoVai;

public class ComandoVaiTest {
	Labirinto labirinto = new LabirintoBuilder()
			.addStanzaIniziale("LabCampusOne")
			.addStanzaVincente("Biblioteca")
			.addAdiacenza("LabCampusOne","Biblioteca","sud")
			.getLabirinto(); 
	Partita partita=new Partita(labirinto);
	ComandoVai comando= new ComandoVai();
	Stanza lab = new Stanza("LabCampusOne");
	Stanza biblioteca = new Stanza("Biblioteca");
	
	@Test
	public void testComandoEsegui() {
		comando.esegui(partita);
		assertEquals(lab.getNome(),partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testSetParametro() {
		comando.esegui(partita);
		comando.setParametro("sud");
		comando.esegui(partita);
		assertEquals(biblioteca.getNome(),partita.getStanzaCorrente().getNome());
		
	}

}
