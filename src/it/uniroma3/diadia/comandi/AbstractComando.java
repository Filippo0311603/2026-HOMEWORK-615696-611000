package it.uniroma3.diadia.comandi;

import java.util.LinkedList;
import java.util.List;

import it.uniroma3.diadia.Partita;

public abstract class AbstractComando implements Comando {

	private String parametro;

	protected static List<String> listaComandi=new LinkedList<String>();
	
	private static final String[] COMANDI_DEL_GIOCO = { "Vai", "Aiuto", "Fine", "Guarda", "Prendi", "Posa" };

	// BLOCCO STATICO AGGIORNATO
		static {
			for (String nome : COMANDI_DEL_GIOCO) {
				try {
					// Componiamo il percorso della classe
					String percorsoClasse = "it.uniroma3.diadia.comandi.Comando" + nome;
					
					// La riflessione ora è isolata nel suo try-catch personale
					Class.forName(percorsoClasse).getDeclaredConstructor().newInstance();
					
				} catch (Exception e) {
					// TEMPORANEO: Ti mostra in console quale comando sta fallendo e perché!
					System.err.println("Errore nel caricamento di: Comando" + nome);
					e.printStackTrace();
				}
			}
		}
	
	public AbstractComando() {
		String nomeClasse = this.getClass().getSimpleName();

		if (nomeClasse.startsWith("Comando") && !nomeClasse.equals("ComandoNonValido")) {
			String d = nomeClasse.substring(7).toLowerCase();

			if (!listaComandi.contains(d)) {
				listaComandi.add(d);
			}
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.parametro=parametro;
	}

	@Override
	public String getParametro() {
		return this.parametro;
	}

	@Override
	public abstract void esegui(Partita partita);

	@Override
	public abstract String getNome();
}
