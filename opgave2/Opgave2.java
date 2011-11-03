/*
 * Naam:		Mike Trieu
 * Studentennummer:	10105093 / 6366295
 * Studie:		Informatica
 *
 * Programma functie: 
 *  Functie 1:
 *  - Het programma vraagt om een invoer van een geheel aantal seconden.
 *  - De invoer wordt omgezet naar uren, minuten en seconden.
 *  Functie 2:
 *  - Het programma vraagt om een invoer (integer) van 0 tot en met 128.
 *  - Het programma zet de integer om naar een ASCII karakter.
 *  - Wanneer de invoer onder de 0 of boven de 128 is, dan wordt dat aangegeven.
 *  Functie 3:
 *  - Het programma vraagt om een straal (double) en berekent dan de oppervlakte en volume van een bol.
 *  Functie 4:
 *  - Het programma rondt de uitkomst van oppervlakte en volume van functie 3 af op 3 decimalen.
 *
 * - Gebruik: java Opgave2
 */

import java.util.*;

public class Opgave2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Voer een geheel aantal seconden in:");
		int invoer = scanner.nextInt();

		/*
		 * De functie voor het omzetten van seconden naar uren, minuten, seconden.
		 */
		int uren, minuten, seconden, restInvoer;

		uren = invoer / 3600;
		restInvoer = invoer % 3600;
		minuten = restInvoer / 60;
		seconden = restInvoer % 60;

		System.out.println(" ");
		System.out.println("Het totaal aantal seconden komt overeen met:");
		System.out.println(uren + " uur " + minuten + " minuten " + seconden + " Seconden");
		System.out.println(" ");




		System.out.println("Geef een integer tussen 0 en 128:");
		int invoer2 = scanner.nextInt();

		/*
		 * De functie om integer om te zetten naar ASCII karakters.
		 */
		if(invoer2 < 0 || invoer2 > 127) {
			System.out.println(" ");
			System.out.println("Dit is geen integer tussen 0 en 128");
		}
		else {
			System.out.println(" ");
			System.out.println("Het corresponderende ASCII karakter is: " + (char)invoer2);
		}
		System.out.println(" ");




		System.out.println("Geef de straal van een bol (een double):");
		double invoer3 = scanner.nextDouble();

		/*
		 * De functie om oppervlakte en volume van een bol te berekenen.
		 */
		double oppervlakte, volume;

		oppervlakte = 4.0 * Math.PI * (invoer3 * invoer3);
		volume = (4.0 / 3.0) * Math.PI * (invoer3 * invoer3 * invoer3);

		System.out.println(" ");
		System.out.println("De oppervlakte is: " + oppervlakte);
		System.out.println("De volume is: " + volume);
		System.out.println(" ");

		/*
		 * De functie om de uitgerekende oppervlakte en volume op 3 decimalen af te ronden
		 */
		double oppervlakteTemp, oppervlakteAfgerond, volumeTemp, volumeAfgerond;

		oppervlakteTemp = Math.round(oppervlakte * 1000);
		oppervlakteAfgerond = oppervlakteTemp / 1000;
		volumeTemp = Math.round(volume * 1000);
		volumeAfgerond = volumeTemp / 1000;

		System.out.println("Afgerond op 3 decimalen krijgen we:");
		System.out.println(" ");
		System.out.println("Oppervlakte: " + oppervlakteAfgerond);
		System.out.println("Volume: " + volumeAfgerond);
	}
}
