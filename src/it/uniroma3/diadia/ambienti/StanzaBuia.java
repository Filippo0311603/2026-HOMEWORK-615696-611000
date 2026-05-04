package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {
	
	private String attrezzoPerVedere;
	final private String MESSAGGIO_BUIO="qui c'è buio pesto";
	
	
	public StanzaBuia(String nome, String attrezzoPerVedere) {
		super(nome);
		this.attrezzoPerVedere=attrezzoPerVedere;
	}
	
	@Override
	public String getDescrizione() {
		if(super.hasAttrezzo(attrezzoPerVedere)) {
			return super.toString();
		}
		return this.MESSAGGIO_BUIO;
		
        
    }

}
