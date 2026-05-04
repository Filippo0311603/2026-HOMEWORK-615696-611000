package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.ComandoVai;

public class ComandoVaiTest {
	Partita partita=new Partita();
	ComandoVai comando= new ComandoVai();
	Stanza atrio = new Stanza("Atrio");
	Stanza biblioteca = new Stanza("Biblioteca");
	
	@Test
	public void testComandoEsegui() {
		comando.esegui(partita);
		assertEquals(atrio.getNome(),partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testSetParametro() {
		comando.esegui(partita);
		comando.setParametro("nord");
		comando.esegui(partita);
		assertEquals(biblioteca.getNome(),partita.getStanzaCorrente().getNome());
		
	}

}
