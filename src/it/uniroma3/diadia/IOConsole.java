package it.uniroma3.diadia;

import java.util.Scanner;

public class IOConsole implements IO {

	// 1. Dichiariamo lo Scanner come attributo d'istanza della classe
	private Scanner scannerDiLinee;

	// 2. Nel costruttore lo inizializziamo UNA VOLTA SOLA
	public IOConsole() {
		this.scannerDiLinee = new Scanner(System.in);
	}

	@Override
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}

	@Override
	public String leggiRiga() {
		// 3. Usiamo lo scanner della classe senza ricrearlo con "new"
		String riga = this.scannerDiLinee.nextLine();
		
		// 4. CANCELLATO il .close()! La tastiera deve rimanere sempre aperta
		return riga;
	}
}
