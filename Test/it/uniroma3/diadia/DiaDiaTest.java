package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;

class DiaDiaTest {
	
	
	
	
	@Test
	void testVittoria() {
		Map<Integer,String> comandi= new HashMap<Integer,String>();
		comandi.put(0,"vai nord");
		IOSimulator io= new IOSimulator(comandi);
		Labirinto labirinto = new LabirintoBuilder()
				.addStanzaIniziale("LabCampusOne")
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("LabCampusOne","Biblioteca","nord")
				.getLabirinto(); 
		DiaDia d = new DiaDia(labirinto,io);
		d.gioca();
		assertTrue(d.getPartita().vinta());
	}
//	
	@Test
	void testPersa() {
		Map<Integer,String> comandi= new HashMap<Integer,String>();
		comandi.put(0,"vai sud");
		IOSimulator io= new IOSimulator(comandi);
		Labirinto labirinto = new LabirintoBuilder()
				.addStanzaIniziale("LabCampusOne")
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("LabCampusOne","Biblioteca","sud")
				.getLabirinto(); 
		DiaDia d = new DiaDia(labirinto,io);
		d.getPartita().getGiocatore().setCfu(1);
		d.gioca();
		assertFalse(d.getPartita().giocatoreIsVivo());
	}
	
	@Test
	void testFinita() {
		Map<Integer,String> comandi= new HashMap<Integer,String>();
		comandi.put(0,"vai sud");
		comandi.put(1,"fine");
		IOSimulator io= new IOSimulator(comandi);
		Labirinto labirinto = new LabirintoBuilder()
				.addStanzaIniziale("LabCampusOne")
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("LabCampusOne","Biblioteca","nord")
				.getLabirinto(); 
		DiaDia d = new DiaDia(labirinto,io);
		d.gioca();
		assertTrue(d.getPartita().isFinita());
	}

}
