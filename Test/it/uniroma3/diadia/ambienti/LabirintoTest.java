package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.Partita;

public class LabirintoTest {
	
	Labirinto l= new Labirinto();
	Stanza aulaN11 = new Stanza("Aula N11");
	Stanza aulaN10 = new Stanza("Aula N10");
	Stanza laboratorio = new Stanza("Laboratorio Campus");
	Stanza biblioteca = new Stanza("Biblioteca");
	
	Partita p =new Partita();
	
	@Test
	public void testSetStanzaCorrente() {
		assertEquals("Atrio",l.getStanzaCorrente().getNome());
		l.setStanzaCorrente(laboratorio);
		assertEquals("Laboratorio Campus",l.getStanzaCorrente().getNome());
		
	}
	
	@Test
	public void testSetStanzaVincente() {
		p.getLabirinto().setStanzaCorrente(p.getLabirinto().getStanzaVincente());
		assertTrue(p.isFinita());
		assertEquals("Biblioteca",p.getLabirinto().getStanzaCorrente().getNome());
		
	}
	
	@Test
	public void testStanzaAdiacente() {
		l.getStanzaCorrente().impostaStanzaAdiacente("sud", biblioteca);
		assertEquals(biblioteca,l.getStanzaCorrente().getStanzaAdiacente("sud"));
	}
	
	
	
	

}
