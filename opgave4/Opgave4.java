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

//palindromen: reeks.length() - 1, is rechter karakter ergens instoppen en dan in charAt()

import java.util.*;

public class Opgave4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Voer een zin, woord of cijferreeks in: ");
		String invoer = scanner.nextLine();
		if(isGetallenReeks(invoer)) {
			System.out.println("Er is een getallen reeks ingevoerd\n");
			filterGetallenReeks(invoer);
		}
		else if(isZin(invoer)) {
			System.out.println("Er is een zin ingevoerd\n");
			filterZin(invoer);
		}
		else if(isWoord(invoer)) {
			System.out.println("Er is een woord ingevoerd\n");
			filterWoord(invoer);
		}
	}


	static boolean isGetallenReeks(String reeks) {
		boolean getallen = false;
		int getalCount = 0;
		int woordCount = 0;

		for(int i = 0; i < reeks.length(); i++) {
			if(reeks.charAt(i) > 47 && reeks.charAt(i) < 58) {
				getalCount++;
			} else if(reeks.charAt(i) > 64 && reeks.charAt(i) < 91) {
				woordCount++;
			} else if(reeks.charAt(i) > 96 && reeks.charAt(i) < 123) {
				woordCount++;
			}
		}
		if(getalCount > woordCount)
			getallen = true;

		return getallen;
	}


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


	static boolean isWoord(String reeks) {
		boolean woord = true;

		return woord;
	}


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

		System.out.println("Gefilterde invoer: ");
		System.out.println(reeks);
		return reeks;
	}


	static String filterZin(String reeks) {
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

		System.out.println("Gefilterde invoer: ");
		System.out.println(reeks);
		return reeks;
	}


	static String filterWoord(String reeks) {
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

		System.out.println("Gefilterde invoer: ");
		System.out.println(reeks);
		return reeks;
	}
}
