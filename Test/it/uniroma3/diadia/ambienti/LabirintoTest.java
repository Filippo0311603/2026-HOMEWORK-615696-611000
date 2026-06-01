package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.LabirintoBuilder;
import it.uniroma3.diadia.Partita;

public class LabirintoTest {
	
	Labirinto labirinto = new LabirintoBuilder()
			.addStanzaIniziale("LabCampusOne")
			.addStanzaVincente("Biblioteca")
			.addAdiacenza("LabCampusOne","Biblioteca","sud")
			.getLabirinto(); 
	
	Stanza laboratorio = new Stanza("LabCampusOne");
	Stanza biblioteca = new Stanza("Biblioteca");
	
	Partita p =new Partita(labirinto);
	
	@Test
	public void testSetStanzaCorrente() {
		assertEquals("LabCampusOne",labirinto.getStanzaCorrente().getNome());
		labirinto.setStanzaCorrente(biblioteca);
		assertEquals("Biblioteca",labirinto.getStanzaCorrente().getNome());
		
	}
	
	@Test
	public void testSetStanzaVincente() {
		p.getLabirinto().setStanzaCorrente(p.getLabirinto().getStanzaVincente());
		assertTrue(p.isFinita());
		assertEquals("Biblioteca",p.getLabirinto().getStanzaCorrente().getNome());
		
	}
	
	@Test
	public void testStanzaAdiacente() {
		labirinto.getStanzaCorrente().impostaStanzaAdiacente("sud", biblioteca);
		assertEquals(biblioteca,labirinto.getStanzaCorrente().getStanzaAdiacente("sud"));
	}
	
	
	
	

}
