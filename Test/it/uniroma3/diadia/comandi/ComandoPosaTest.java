package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.LabirintoBuilder;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;

public class ComandoPosaTest {
	ComandoPosa c=new ComandoPosa();
	Labirinto labirinto = new LabirintoBuilder()
			.addStanzaIniziale("LabCampusOne")
			.addStanzaVincente("Biblioteca")
			.addAdiacenza("LabCampusOne","Biblioteca","sud")
			.getLabirinto(); 
	Partita partita=new Partita(labirinto);
	Attrezzo a= new Attrezzo("Spada",3);
	
	@Test
	public void testUno() {
		partita.getGiocatore().getBorsa().addAttrezzo(a);
		c.setParametro(a.getNome());
		c.esegui(partita);
		assertEquals(a.getNome(),partita.getLabirinto().getStanzaCorrente().getAttrezzo("Spada").getNome());
		
	}
	
	@Test
	public void testDue() {
		c.esegui(partita);
		assertNull(partita.getStanzaCorrente().getAttrezzo("Spada"));
	}
	
	@Test
	public void testNome() {
		assertEquals("posa",c.getNome());
	}
	
	@Test
	public void testParametro() {
		c.setParametro("Spada");
		assertEquals("Spada",c.getParametro());
	}

}
