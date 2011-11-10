/*
 * Naam:		Mike Trieu
 * Studentennummer:	10105093 / 6366295
 * Studie:		Informatica
 *
 * Programma functie: 
 * - Het programma vraagt om een invoer(string).
 * - Het programma kijkt of de invoer een cijferreeks, zin of woord is.
 * 	- Een invoer is een cijferreeks, wanneer het meer cijfers dan letters telt.
 * 	- Een invoer is een zin, wanneer er spaties in voor komen.
 * 	- Een invoer is een woord, wanneer het geen cijferreeks en geen zin is.
 * - Het programma filtert de invoer op basis van of het een cijferreeks, zin of woord is.
 * - Het programma print de gefilterde invoer uit.
 * - Het programma kijkt of de gefilterde invoer een palindroom is of niet.
 * - Het programma print het resultaat en vraagt of de gebruiker het programma opnieuw wilt uitvoeren.
 *
 * - Gebruik: java Opgave4
 */

import java.util.*;

public class Opgave4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);

		String invoer, invoerOpnieuw;
		boolean opnieuw = false;

		System.out.print("Dit programma test of je invoer een palindroom is");

		do {
			System.out.print("\nVoer een zin, woord of cijferreeks in: ");
			invoer = scanner.nextLine();

			if(isGetallenReeks(invoer)) {
				System.out.println("\nEr is een cijferreeks ingevoerd\n");
				invoer = filterGetallenReeks(invoer);

				if(palindromenTest(invoer))
					System.out.println("\nDe ingevoerde cijferreeks is een palindroom");
				else
					System.out.println("\nDe ingevoerde cijferreeks is geen palindroom");
			}
			else if(isZin(invoer)) {
				System.out.println("\nEr is een zin ingevoerd\n");
				invoer = filterZinOfWoord(invoer);

				if(palindromenTest(invoer))
					System.out.println("\nDe ingevoerde zin is een palindroom");
				else
					System.out.println("\nDe ingevoerde zin is geen palindroom");
			}
			else {
				System.out.println("\nEr is een woord ingevoerd\n");
				invoer = filterZinOfWoord(invoer);

				if(palindromenTest(invoer))
					System.out.println("\nHet ingevoerde woord is een palindroom");
				else
					System.out.println("\nHet ingevoerde woord is geen palindroom");
			}
			System.out.print("\nWil je dit programma nog een keer uitvoeren? [y/n]: ");
			invoerOpnieuw = scanner2.next();

			if(invoerOpnieuw.toLowerCase().equals("y"))
				opnieuw = true;
			else
				opnieuw = false;
		} while(opnieuw == true);
	}


	/*
	 * De methode voor het testen of een invoer wel of niet een cijferreeks is
	 */
	static boolean isGetallenReeks(String reeks) {
		boolean getallen = false;
		int getalCount = 0, woordCount = 0;

		for(int i = 0; i < reeks.length(); i++) {
			if(reeks.charAt(i) > 47 && reeks.charAt(i) < 58)
				getalCount++;
			else if(reeks.charAt(i) > 64 && reeks.charAt(i) < 91)
				woordCount++;
			else if(reeks.charAt(i) > 96 && reeks.charAt(i) < 123)
				woordCount++;
		}

		if(getalCount > woordCount)
			getallen = true;

		return getallen;
	}


	/*
	 * De methode voor het testen of een invoer wel of niet een zin is
	 */
	static boolean isZin(String reeks) {
		boolean spatie = false;

		for(int i = 0; i < reeks.length(); i++) {
			if(reeks.charAt(i) == ' ') {
				spatie = true;
				break;
			}
		}
		return spatie;
	}


	/*
	 * De methode voor het filteren van de cijferreeks
	 * Alle tekens, behalve cijfers, worden eruit gefilterd
	 */
	static String filterGetallenReeks(String reeks) {
		for(int i = 0; i < reeks.length(); i++) {
			char temp = reeks.charAt(i);
			String temp2 = Character.toString(temp);

			if(reeks.charAt(i) > 31 && reeks.charAt(i) < 48)
				reeks = reeks.replace(temp2," ");
			else if(reeks.charAt(i) > 57 && reeks.charAt(i) < 127)
				reeks = reeks.replace(temp2," ");
		}

		for(int i = 0; i < reeks.length(); i++)
				reeks = reeks.replace(" ","");

		System.out.println("Gefilterde invoer: " + reeks);

		return reeks;
	}


	/*
	 * De methode voor het filteren van een zin of een woord
	 * Alle tekens, behalve letters, worden eruit gefilterd
	 */
	static String filterZinOfWoord(String reeks) {
		for(int i = 0; i < reeks.length(); i++) {
			char temp = reeks.charAt(i);
			String temp2 = Character.toString(temp);

			if(reeks.charAt(i) > 31 && reeks.charAt(i) < 65)
				reeks = reeks.replace(temp2," ");
			else if(reeks.charAt(i) > 90 && reeks.charAt(i) < 97)
				reeks = reeks.replace(temp2," ");
			else if(reeks.charAt(i) > 122 && reeks.charAt(i) < 127)
				reeks = reeks.replace(temp2," ");
		}

		for(int i = 0; i < reeks.length(); i++)
				reeks = reeks.replace(" ","");

		reeks = omzettenHoofdletter(reeks);

		System.out.println("Gefilterde invoer: " + reeks);

		return reeks;
	}


	/*
	 * De methode om hoofdletters om te zetten naar kleine letters
	 */
	static String omzettenHoofdletter(String reeks) {
		for(int i = 0; i < reeks.length(); i++) {
			if(reeks.charAt(i) > 64 && reeks.charAt(i) < 91)
				reeks = reeks.replace("A","a");
				reeks = reeks.replace("B","b");
				reeks = reeks.replace("C","c");
				reeks = reeks.replace("D","d");
				reeks = reeks.replace("E","e");
				reeks = reeks.replace("F","f");
				reeks = reeks.replace("G","g");
				reeks = reeks.replace("H","h");
				reeks = reeks.replace("I","i");
				reeks = reeks.replace("J","j");
				reeks = reeks.replace("K","k");
				reeks = reeks.replace("L","l");
				reeks = reeks.replace("M","m");
				reeks = reeks.replace("N","n");
				reeks = reeks.replace("O","o");
				reeks = reeks.replace("P","p");
				reeks = reeks.replace("Q","q");
				reeks = reeks.replace("R","r");
				reeks = reeks.replace("S","s");
				reeks = reeks.replace("T","t");
				reeks = reeks.replace("U","u");
				reeks = reeks.replace("V","v");
				reeks = reeks.replace("W","w");
				reeks = reeks.replace("X","x");
				reeks = reeks.replace("Y","y");
				reeks = reeks.replace("Z","z");
		}
		return reeks;
	}


	/*
	 * De methode voor het testen of een string wel of niet een palindroom is.
	 */
	static boolean palindromenTest(String reeks) {
		boolean palindroom = true;
		int j = reeks.length() - 1;

		for(int i = 0; i <= j; i++, j--) {
			if(reeks.charAt(i) != reeks.charAt(j))
				palindroom = false;
		}
		return palindroom;
	}
}
