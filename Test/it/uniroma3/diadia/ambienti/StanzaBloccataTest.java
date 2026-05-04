package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {
	Attrezzo pas= new Attrezzo("passepartout",2);
	String direzioneBloccata="nord";
	StanzaBloccata bloccata= new StanzaBloccata("doccia",direzioneBloccata,pas.getNome());
	Stanza a= new Stanza("negroni");
	Stanza b= new Stanza("negrone");
	Attrezzo gas= new Attrezzo("gas",2);
	
	@Test
	void testConAttrezzo() {
		bloccata.addAttrezzo(pas);
		bloccata.impostaStanzaAdiacente("nord",a);
		assertEquals("negroni",bloccata.getStanzaAdiacente("nord").getNome());
		
		
		
	}
	
	@Test
	void testSenzaAttrezzo() {
		bloccata.addAttrezzo(gas);
		bloccata.impostaStanzaAdiacente("nord",b);
		assertEquals(bloccata,bloccata.getStanzaAdiacente("nord"));
	}

}
