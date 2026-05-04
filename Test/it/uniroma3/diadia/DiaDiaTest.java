package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DiaDiaTest {
	
	
	
	
	@Test
	void testVittoria() {
		String[] comandi= {"vai nord"};
		IOSimulator io= new IOSimulator(comandi);
		DiaDia d = new DiaDia(io);
		d.gioca();
		assertTrue(d.getPartita().vinta());
	}
	
	@Test
	void testPersa() {
		String[] comandi= {"vai sud"};
		IOSimulator io= new IOSimulator(comandi);
		DiaDia d = new DiaDia(io);
		d.getPartita().getGiocatore().setCfu(1);
		d.gioca();
		assertFalse(d.getPartita().giocatoreIsVivo());
	}
	
	@Test
	void testFinita() {
		String[] comandi= {"vai sud","fine"};
		IOSimulator io= new IOSimulator(comandi);
		DiaDia d = new DiaDia(io);
		d.gioca();
		assertTrue(d.getPartita().isFinita());
	}

}
