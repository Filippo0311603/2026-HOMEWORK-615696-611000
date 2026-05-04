package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {
	
	private String direzioneBloccata;
	private String attrezzoSbloccante;
	
	
	public StanzaBloccata(String nome,String direzioneBloccata,String attrezzoSbloccante) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.attrezzoSbloccante = attrezzoSbloccante;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
        Stanza stanza = null;
		for(int i=0; i<super.getDirezioni().length; i++)
        	if (super.getDirezioni()[i].equals(direzione)) {
        		if(direzione.equals(direzioneBloccata) && super.hasAttrezzo(attrezzoSbloccante)) {
        			stanza = super.getStanzaAdiacente(direzione);
        		}
        		else if(direzione.equals(direzioneBloccata) && !super.hasAttrezzo(attrezzoSbloccante)) {
        			stanza=this;
        		}
        		else {
        			stanza = super.getStanzaAdiacente(direzione);
        		}
        	}
        		
        return stanza;
	}
	
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(attrezzoSbloccante)) {
			return "Nella stanza è presente l'attrezzo:"+ this.attrezzoSbloccante + "quindi ti è permesso andare nella direzione bloccata:" + this.direzioneBloccata + "nella stanza "+ this.getStanzaAdiacente(this.direzioneBloccata).toString();
		}
		return "Nella stanza non è presente l'attrezzo:"+ this.attrezzoSbloccante + "quindi non ti è permesso andare nella direzione bloccata:" + this.direzioneBloccata + "nella stanza "+ this.getStanzaAdiacente(this.direzioneBloccata).toString();
		
        
    }
}
