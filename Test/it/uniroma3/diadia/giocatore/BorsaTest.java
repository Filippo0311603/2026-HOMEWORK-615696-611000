package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	Borsa b = new Borsa(50);
	Attrezzo a = new Attrezzo("spada",8);
	Attrezzo b1 = new Attrezzo("ascia",7);
	Attrezzo c = new Attrezzo("martello",6);
	Attrezzo d = new Attrezzo("scudo",5);
	Attrezzo e = new Attrezzo("coltello",2);
	
	
	@Test
	public void testAggiuntaAttrezzo() {
		assertTrue(b.addAttrezzo(a));
	}
	
	@Test
	public void testverificaAttrezzoPresente() {
		b.addAttrezzo(a);
		b.addAttrezzo(e);
		assertEquals("spada",b.getAttrezzo(a.getNome()).getNome());
		assertTrue(b.hasAttrezzo("coltello"));
	}
	
	@Test
	public void testRimozioneAttrezzo() {
		b.addAttrezzo(a);
		b.addAttrezzo(e);
		assertTrue(b.hasAttrezzo("coltello"));
		b.removeAttrezzo("coltello");
		assertFalse(b.hasAttrezzo("coltello"));
		
	}
	
	@Test
	public void verificaContenutoOrdinatoPerPeso() {
		b.addAttrezzo(a);
		b.addAttrezzo(b1);
		b.addAttrezzo(c);
		b.addAttrezzo(d);
		b.addAttrezzo(e);
		List<Attrezzo> listaord= new ArrayList<Attrezzo>();
		listaord=b.getContenutoOrdinatoPerPeso();
		assertEquals(e,listaord.get(0));
		assertEquals(d,listaord.get(1));
		assertEquals(c,listaord.get(2));
		assertEquals(b1,listaord.get(3));
		assertEquals(a,listaord.get(4));
		
		
	}
	
	@Test
	public void TestgetContenutoOrdinatoPerNome() {
		b.addAttrezzo(a);
		b.addAttrezzo(b1);
		SortedSet<Attrezzo> ordi= new TreeSet<Attrezzo>();
		ordi=b.getContenutoOrdinatoPerNome();
		Iterator<Attrezzo> g= ordi.iterator();
		assertTrue(g.hasNext());
		assertEquals(b1,g.next());
		assertTrue(g.hasNext());
		assertEquals(a,g.next());
		
		
		
	}
	
	

}
