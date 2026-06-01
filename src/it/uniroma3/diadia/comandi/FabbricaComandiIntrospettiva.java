package it.uniroma3.diadia.comandi;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class FabbricaComandiIntrospettiva implements FabbricaDiComandi {
	
	public Comando costruisciComando(String istruzione) throws Exception {
		Scanner scannerDiParole = new Scanner(istruzione); // es. ‘vai sud’
		String nomeComando = null; // es. ‘vai’
		String parametro = null; // es. ‘sud’
		Comando comando = null;
		
		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next();
		
		if (nomeComando == null) {
			comando = new ComandoNonValido();
		} else {
			StringBuilder nomeClasse = new StringBuilder("it.uniroma3.diadia.comandi.Comando");
			nomeClasse.append( Character.toUpperCase(nomeComando.charAt(0)) );
			nomeClasse.append( nomeComando.substring(1) ) ;
			
			
			try {
				comando = (Comando)Class.forName(nomeClasse.toString()).getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				
				comando = new ComandoNonValido();
			}
		}
		
		comando.setParametro(parametro);
		return comando;
	}
}
