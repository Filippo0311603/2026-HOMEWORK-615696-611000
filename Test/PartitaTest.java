import static org.junit.Assert.*;

import org.junit.Test;

public class PartitaTest {
	Partita p = new Partita();
	Labirinto l= new Labirinto();
	Stanza atrio = new Stanza("Atrio");
	Stanza biblioteca = new Stanza("Biblioteca");
	
	@Test
	public void testVinta() {
		p.labirinto.setStanzaCorrente(p.labirinto.getStanzaVincente());
		assertTrue(p.isFinita());
		
	}
	
	@Test
	public void testNonVinta() {
		p.labirinto.setStanzaCorrente(atrio);
		assertFalse(p.isFinita());
		
	}
	
	@Test
	public void testIsFinita() {
		p.giocatore.setCfu(0);
		assertTrue(p.isFinita());
	}
	
	

}
