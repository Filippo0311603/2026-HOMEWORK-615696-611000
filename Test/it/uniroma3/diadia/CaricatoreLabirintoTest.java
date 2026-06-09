package it.uniroma3.diadia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.StringReader;
import org.junit.Test;
import it.uniroma3.diadia.ambienti.Labirinto;

public class CaricatoreLabirintoTest {

	@Test
	public void testMonolocale() throws FormatoFileNonValidoException {
		// Fixture: un labirinto con una sola stanza, senza uscite o attrezzi
		String labirintoMonolocale = 
				"Stanze: N10\n" +
				"Inizio: N10\n" +
				"Vincente: N10\n" +
				"Attrezzi:\n" +
				"Uscite:\n";

		CaricatoreLabirinto caricatore = new CaricatoreLabirinto(new StringReader(labirintoMonolocale));
		caricatore.carica();
		Labirinto lab = caricatore.getLabirinto();

		// Verifichiamo che la stanza iniziale e vincente siano state lette correttamente
		assertEquals("N10", lab.getStanzaCorrente().getNome());
		assertEquals("N10", lab.getStanzaVincente().getNome());
	}

	@Test
	public void testBilocale() throws FormatoFileNonValidoException {
		// Fixture: un labirinto con due stanze collegate
		String labirintoBilocale = 
				"Stanze: N10, Biblioteca\n" +
				"Inizio: N10\n" +
				"Vincente: Biblioteca\n" +
				"Attrezzi:\n" +
				"Uscite: N10 nord Biblioteca, Biblioteca sud N10\n";

		CaricatoreLabirinto caricatore = new CaricatoreLabirinto(new StringReader(labirintoBilocale));
		caricatore.carica();
		Labirinto lab = caricatore.getLabirinto();

		assertEquals("N10", lab.getStanzaCorrente().getNome());
		assertEquals("Biblioteca", lab.getStanzaVincente().getNome());
		
		// Verifichiamo l'adiacenza
		assertEquals("Biblioteca", lab.getStanzaCorrente().getStanzaAdiacente("nord").getNome());
	}

	@Test
	public void testTrilocaleConAttrezzi() throws FormatoFileNonValidoException {
		// Fixture: il labirinto di esempio della consegna
		String labirintoCompleto = 
				"Stanze: N10, Biblioteca, N11\n" +
				"Inizio: N10\n" +
				"Vincente: N11\n" +
				"Attrezzi: martello 10 Biblioteca, pinza 2 N10, osso 5 N10\n" +
				"Uscite: N10 nord Biblioteca, Biblioteca sud N10, Biblioteca est N11\n";

		CaricatoreLabirinto caricatore = new CaricatoreLabirinto(new StringReader(labirintoCompleto));
		caricatore.carica();
		Labirinto lab = caricatore.getLabirinto();

		// Verifiche sulle stanze
		assertEquals("N10", lab.getStanzaCorrente().getNome());
		assertEquals("N11", lab.getStanzaVincente().getNome());
		
		// Verifiche sugli attrezzi posati correttamente
		assertTrue(lab.getStanzaCorrente().hasAttrezzo("pinza"));
		assertTrue(lab.getStanzaCorrente().hasAttrezzo("osso"));
		
		// Verifiche uscite
		assertEquals("Biblioteca", lab.getStanzaCorrente().getStanzaAdiacente("nord").getNome());
		assertTrue(lab.getStanzaCorrente().getStanzaAdiacente("nord").hasAttrezzo("martello"));
	}
}
