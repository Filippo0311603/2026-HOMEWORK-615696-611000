import static org.junit.Assert.*;

import org.junit.Test;

public class StanzaTest {
	
	
	Stanza s1=new Stanza("Bagno");
	Attrezzo a1= new Attrezzo("Martello",8);
	Attrezzo a2= new Attrezzo("Spada",8);
	Attrezzo a3= new Attrezzo("Coltello",8);
	Attrezzo a4= new Attrezzo("Ascia",8);
	
	boolean b=s1.addAttrezzo(a1);
	boolean b2=s1.addAttrezzo(a2);
	boolean b3=s1.addAttrezzo(a3);
	boolean b4=s1.addAttrezzo(a4);
	@Test
	public void test() {
		assertTrue(b);
	}
	
	@Test
	public void test2() {
		assertEquals(4,s1.getNumeroAttrezzi());
	}
	
	@Test
	public void test3() {
		assertEquals(4,s1.getNumeroAttrezzi());
		boolean b2=s1.removeAttrezzo(a1.getNome());
		assertEquals(3,s1.getNumeroAttrezzi());
	}

}
