package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPrendi;

class ComandoPrendiTest {

	ComandoPrendi c=new ComandoPrendi();
	Partita partita=new Partita();
	Attrezzo a= new Attrezzo("Spada",3);
	
	@Test
	public void testUno() {
		partita.getStanzaCorrente().addAttrezzo(a);
		c.setParametro(a.getNome());
		c.esegui(partita);
		assertEquals(a.getNome(),partita.getGiocatore().getBorsa().getAttrezzo("Spada").getNome());
		
	}
	
	@Test
	public void testDue() {
		c.esegui(partita);
		assertNull(partita.getGiocatore().getBorsa().getAttrezzo("Spada"));
	}

}
