package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.LabirintoBuilder;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaMagicaTest {
	StanzaMagica magica=new StanzaMagica("Magica");
	Labirinto labirinto = new LabirintoBuilder()
			.addStanzaIniziale("LabCampusOne")
			.addStanzaVincente("Biblioteca")
			.addAdiacenza("LabCampusOne","Biblioteca","sud")
			.getLabirinto(); 
	Partita p= new Partita(labirinto);
	Attrezzo a = new Attrezzo("ascia",4);
	Attrezzo b = new Attrezzo("spada",4);
	Attrezzo c= new Attrezzo("coltello",2);
	Attrezzo d= new Attrezzo("scudo",2);
	
	
	@Test
	void test() {
		magica.addAttrezzo(a);
		magica.addAttrezzo(b);
		magica.addAttrezzo(c);
		magica.addAttrezzo(d);
		
		assertEquals("oducs",magica.getAttrezzo("oducs").getNome());
		assertEquals(4,magica.getAttrezzo("oducs").getPeso());
		
		
	}

}
