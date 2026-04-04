package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	Borsa b = new Borsa();
	Attrezzo a = new Attrezzo("spada",8);
	Attrezzo b1 = new Attrezzo("ascia",7);
	Attrezzo c = new Attrezzo("martello",6);
	Attrezzo d = new Attrezzo("scudo",5);
	Attrezzo e = new Attrezzo("coltello",2);
	
	
	@Test
	public void testAggiuntaAttrezzo() {
		assertTrue(b.addAttrezzo(a));
	}
	
	@Test
	public void testverificaAttrezzoPresente() {
		b.addAttrezzo(a);
		b.addAttrezzo(e);
		assertEquals("spada",b.getAttrezzo(a.getNome()).getNome());
		assertTrue(b.hasAttrezzo("coltello"));
	}
	
	@Test
	public void testRimozioneAttrezzo() {
		b.addAttrezzo(a);
		b.addAttrezzo(e);
		assertTrue(b.hasAttrezzo("coltello"));
		b.removeAttrezzo("coltello");
		assertFalse(b.hasAttrezzo("coltello"));
		
	}
	
	

}
