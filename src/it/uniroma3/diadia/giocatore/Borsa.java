package it.uniroma3.diadia.giocatore;
import java.util.*;

import it.uniroma3.diadia.attrezzi.Attrezzo;



public class Borsa {
	
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Map <String,Attrezzo> attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	private int pesoAttualeBorsa;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<String,Attrezzo>();
		this.numeroAttrezzi = 0;
		this.pesoAttualeBorsa=0;
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		this.attrezzi.put(attrezzo.getNome(), attrezzo);
		this.pesoAttualeBorsa+=attrezzo.getPeso();
		this.numeroAttrezzi++;
		return true;
	}
	
	public int getPesoMax() {
		return pesoMax;
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = this.attrezzi.get(nomeAttrezzo);
		if(a==null) {
			return null;
		}
		return a;
	}

	public int getPeso() {

		return this.pesoAttualeBorsa;
	}
	
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}
	
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a=this.attrezzi.remove(nomeAttrezzo);
		
		
		if(a==null) {
			throw new NullPointerException("prova1");
		}
		this.pesoAttualeBorsa-=a.getPeso();
		return a;
	}
	
	public String toString() {
	    StringBuilder s = new StringBuilder();

	    if (!this.isEmpty()) {
	        s.append("Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
	        
	        // Scorri direttamente i valori (gli Attrezzi) contenuti nella mappa
	        for (Attrezzo a : this.attrezzi.values()) {
	            s.append(a.toString() + " ");
	        }
	    }
	    else {
	        s.append("Borsa vuota");
	    }
	    
	    return s.toString();
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		List<Attrezzo> lista=new ArrayList<Attrezzo>();
		lista.addAll(this.attrezzi.values());
		Collections.sort(lista);
		return lista;
		
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		SortedSet<Attrezzo> ord=new TreeSet<Attrezzo>(new Comparator<Attrezzo>() {
			@Override
			public int compare(Attrezzo a1, Attrezzo a2) {
				return a1.getNome().compareTo(a2.getNome());
			}
		});
		
		ord.addAll(this.attrezzi.values());
		return ord;
			
		
		
	}
	
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		
		Map<Integer,Set<Attrezzo>> mappa= new HashMap<Integer,Set<Attrezzo>>();
		for(Attrezzo a: this.attrezzi.values()) {
			if(a!=null) {
				if(mappa.containsKey(a.getPeso())) {
					mappa.get(a.getPeso()).add(a);
				}
				else {
					Set<Attrezzo> set= new HashSet<Attrezzo>();
					set.add(a);
					mappa.put(a.getPeso(),set);
				}
			}
		}
		return mappa;
	}
}