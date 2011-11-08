/*
 * Naam:		Mike Trieu
 * Studentennummer:	10105093 / 6366295
 * Studie:		Informatica
 *
 * Programma functie: 
 *  Functie 1:
 *  - 
 *  Functie 2:
 *  - 
 *
 * - Gebruik: java Opgave4
 */

import java.util.*;

public class Opgave4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Voer een zin, woord of cijferreeks in: ");
		String invoer = scanner.next();

		boolean spatie = false;

		for(int i = 0; i < invoer.length(); i++) {
			if(invoer.charAt(i) == ' ') {
				spatie = true;
				break;
			}
		}
		if(spatie == true)
			System.out.println("trololol " + invoer);
	}
}
