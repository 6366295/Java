/*
* Naam: Mike Trieu
* Studentennummer: 10105093 / 6366295
* Opleiding: Informatica
*
* Opdracht:
*  Functie 1: Ingevoerde seconden omzetten in uren, minuten, seconden
*  Functie 2: Ingevoerde integer omzetten naar ASCII karakter
*  Functie 3: Ingevoerde double gebruiken om oppervlakte en volume te berekenen
*  Functie 4: Uitkomst van deel 3 afronden om 3 decimalen
*/

import java.util.*;

public class Opgave2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Voer een geheel aantal seconden in:");
		int invoer = scanner.nextInt();

		/*
		* functie voor omzetten van seconden naar uren, minuten, seconden
		*/
		int uren = invoer / 3600;
		int restInvoer = invoer % 3600;
		int minuten = restInvoer / 60;
		int seconden = restInvoer % 60;

		System.out.println(" ");
		System.out.println("Het totaal aantal seconden komt overeen met:");
		System.out.println(uren + " uur " + minuten + " minuten " + seconden + " Seconden");
		System.out.println(" ");



		System.out.println("Geef een integer tussen 0 en 128:");
		int invoer2 = scanner.nextInt();

		/*
		* if-else functie om te kleine of te grote invoer te stoppen.
		* (char)invoer2 zet invoer om naar ASCII karakters.
		*/
		if(invoer2 < 0 | invoer2 > 128) {
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
		* if-else functie om te kleine of te grote invoer te stoppen.
		* functie om oppervlakte en volume te berekenen.
		*/
		if(invoer3 > 133.65 | invoer < -133.65) {
			System.out.println("Het ingevoerde getal is buiten bereik van dit programma");
		}
		else {
			double oppervlakte = 4 * Math.PI * invoer3 * invoer3;
			double teller = 4;
			double volume = teller / 3 * Math.PI * invoer3 * invoer3 * invoer3;
			System.out.println(" ");
			System.out.println("De oppervlakte is: " + oppervlakte);
			System.out.println(" ");
			System.out.println("De volume is: " + volume);
			System.out.println(" ");

			/*
			* functie om uitgerekende oppervlakte en volume met 3 decimalen af te ronden
			*/
			System.out.println("Afgerond op 3 decimalen krijgen we:");
			double oppervlakteTemp = Math.round(oppervlakte * 1000);
			double oppervlakteAfgerond = oppervlakteTemp / 1000;
			double volumeTemp = Math.round(volume * 1000);
			double volumeAfgerond = volumeTemp / 1000;
			System.out.println(" ");
			System.out.println("Oppervlakte: " + oppervlakteAfgerond);
			System.out.println("Volume: " + volumeAfgerond);
		}
	}
}
