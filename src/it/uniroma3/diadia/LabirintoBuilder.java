package it.uniroma3.diadia;



import java.util.*;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaMagica;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import java.util.HashMap;
import java.util.Map;

public class LabirintoBuilder {
    
    private Labirinto labirinto;
    
    private Map<String, Stanza> nome2stanza; 
   
    private Stanza ultimaStanzaAggiunta; 

    public LabirintoBuilder() {
        this.labirinto = new Labirinto();
        this.nome2stanza = new HashMap<>();
    }

    public LabirintoBuilder addStanza(String nome) {
        Stanza stanza = new Stanza(nome);
        this.nome2stanza.put(nome, stanza);
        this.ultimaStanzaAggiunta = stanza;
        return this; 
    }

    public LabirintoBuilder addStanzaIniziale(String nome) {
        this.addStanza(nome);
        
        this.labirinto.setStanzaIniziale(this.nome2stanza.get(nome));
        this.labirinto.setStanzaCorrente(this.nome2stanza.get(nome));
        return this;
    }

    public LabirintoBuilder addStanzaVincente(String nome) {
        this.addStanza(nome);
        this.labirinto.setStanzaVincente(this.nome2stanza.get(nome));
        return this;
    }
    
    
    public LabirintoBuilder addStanzaMagica(String nome, int sogliaMagica) {
        Stanza stanza = new StanzaMagica(nome, sogliaMagica);
        this.nome2stanza.put(nome, stanza);
        this.ultimaStanzaAggiunta = stanza;
        return this;
    }

    public LabirintoBuilder addAttrezzo(String nome, int peso) {
        if (this.ultimaStanzaAggiunta != null) {
            Attrezzo a = new Attrezzo(nome, peso);
            this.ultimaStanzaAggiunta.addAttrezzo(a);
        }
        return this;
    }

    public LabirintoBuilder addAdiacenza(String stanzaPartenza, String stanzaDestinazione, String direzione) {
        Stanza s1 = this.nome2stanza.get(stanzaPartenza);
        Stanza s2 = this.nome2stanza.get(stanzaDestinazione);
        
        if (s1 != null && s2 != null) {
            s1.impostaStanzaAdiacente(direzione, s2);
        }
        return this;
    }
    
    

    public Labirinto getLabirinto() {
        return this.labirinto;
    }
}