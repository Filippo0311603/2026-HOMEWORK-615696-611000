package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
	
	@Test
	public void TestGetContenutoRaggruppatoPerPeso() {
		Attrezzo f=new Attrezzo("libro",5);
		Attrezzo g=new Attrezzo("ps",5);
		Attrezzo h=new Attrezzo("piuma",4);
		Borsa b=new Borsa(30);
		b.addAttrezzo(f);
		b.addAttrezzo(g);
		b.addAttrezzo(h);
		Map<Integer,Set<Attrezzo>> ord=new HashMap<Integer,Set<Attrezzo>>();
		ord=b.getContenutoRaggruppatoPerPeso();
		Set<Attrezzo> set= new HashSet<Attrezzo>();
		set.add(f);
		set.add(g);
		Set<Attrezzo> set2= new HashSet<Attrezzo>();
		set2.add(h);
		
		assertEquals(ord.get(f.getPeso()),set);
		assertEquals(ord.get(h.getPeso()),set2);
		
	}
	
	

}
