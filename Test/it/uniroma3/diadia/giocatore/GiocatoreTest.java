package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class GiocatoreTest {
	Giocatore g= new Giocatore();
	Attrezzo a= new Attrezzo("spada",8);
	Partita p= new Partita();
	
	@Test
	public void testAttrezzoAggiunto() {
		g.borsa.addAttrezzo(a);
		assertTrue(g.borsa.hasAttrezzo("spada"));
	}
	
	@Test
	public void testGiocatoreVincePartita() {
		p.giocatore.setCfu(0);
		assertTrue(p.isFinita());
	}
	
	@Test
	public void testCfu() {
		g.setCfu(50);
		assertEquals(50,g.getCfu());
	}

}
