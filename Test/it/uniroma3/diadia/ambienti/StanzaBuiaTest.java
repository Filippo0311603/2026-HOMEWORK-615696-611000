package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {
	Attrezzo a=new Attrezzo("lanterna",3);
	StanzaBuia stanza=new StanzaBuia("cella",a.getNome());
	Attrezzo b=new Attrezzo("ascia",3);
	
	@Test
	void test() {
		stanza.addAttrezzo(a);
		assertNotEquals("qui c'è buio pesto",stanza.getDescrizione());
	}

}
