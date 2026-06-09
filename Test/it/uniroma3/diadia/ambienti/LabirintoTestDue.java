package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LabirintoTestDue {

	@Test
	public void testCostruzioneLabirintoConNuovoBuilder() {
		// ARRANGEMENT & ACT
		// Usiamo il factory method e la sintassi concatenata ("Method Chaining")
		Labirinto lab = Labirinto.newBuilder()
				.addStanzaIniziale("Atrio")
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.addAttrezzo("Atrio", "osso", 2)
				.getLabirinto();
		
		// ASSERT
		assertNotNull("Il labirinto non dovrebbe essere null", lab);
		
		// Verifichiamo le stanze
		assertEquals("Atrio", lab.getStanzaCorrente().getNome());
		assertEquals("Biblioteca", lab.getStanzaVincente().getNome());
		
		// Verifichiamo i collegamenti
		assertEquals("Biblioteca", lab.getStanzaCorrente().getStanzaAdiacente("nord").getNome());
		
		// Verifichiamo gli attrezzi
		assertEquals(true, lab.getStanzaCorrente().hasAttrezzo("osso"));
	}
}
