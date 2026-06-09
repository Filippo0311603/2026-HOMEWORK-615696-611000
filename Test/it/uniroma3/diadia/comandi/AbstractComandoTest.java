package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class AbstractComandoTest {

	private AbstractComando comando;

	
	private class ComandoFake extends AbstractComando {
		
		@Override
		public void esegui(Partita partita) {
			
		}

		@Override
		public String getNome() {
			return "fake";
		}

		@Override
		public void setIo(IO io) {
			// TODO Auto-generated method stub
			
		}
	}

	@BeforeEach
	public void setUp() {
		
		this.comando = new ComandoFake();
	}

	@Test
	public void testGetParametroInizialmenteNull() {
		assertNull(this.comando.getParametro(), "All'inizio il parametro deve essere null");
	}

	@Test
	public void testSetEGetParametro() {
		this.comando.setParametro("nord");
		assertEquals("nord", this.comando.getParametro(), "Il parametro restituito non è quello impostato");
	}
}
