package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.LabirintoBuilder;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class GiocatoreTest {
	Giocatore g= new Giocatore();
	Attrezzo a= new Attrezzo("spada",8);
	Labirinto labirinto = new LabirintoBuilder()
			.addStanzaIniziale("LabCampusOne")
			.addStanzaVincente("Biblioteca")
			.addAdiacenza("LabCampusOne","Biblioteca","sud")
			.getLabirinto(); 
	Partita p= new Partita(labirinto);
	
	@Test
	public void testAttrezzoAggiunto() {
		g.getBorsa().addAttrezzo(a);
		assertTrue(g.getBorsa().hasAttrezzo("spada"));
	}
	
	@Test
	public void testGiocatoreVincePartita() {
		p.getGiocatore().setCfu(0);
		assertTrue(p.isFinita());
	}
	
	@Test
	public void testCfu() {
		g.setCfu(50);
		assertEquals(50,g.getCfu());
	}

}
