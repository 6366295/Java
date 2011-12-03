/*
 * Naam:		Mike Trieu
 * Studentennummer:	10105093 / 6366295
 * Studie:		Informatica
 *
 * Programma functie:
 * - Het programma vraagt een (geboorte)datum en een interval van 2 jaren
 *  - Invoer niet volgens het programma formaat wordt niet geaccepteerd
 *  - Ingevoerde datum dat niet bestaat wordt niet geaccepteerd
 *  - Ingevoerde interval waarbij het begin jaar groter is dan eind jaar wordt 
 *    niet geaccepteerd
 * - Het programma geeft dan op welke dag van de week die datum valt
 * - Daarna bepaalt het programma in welke jaren tussen het gegeven interval
 *   dezelfde datum op dezelfde dag van de week valt
 *
 * - Gebruik: java Opgave8
 */

import java.util.*;
import java.io.*;

public class Opgave8 {
	/*
	 * Methode voor interactie met gebruiker
	 * Split de invoer naar een array 
	 */
	public static void main(String[] args) throws IOException {
		Scanner invoer = new Scanner(System.in);

		boolean incorrect;
		String invoerVerjaardag, invoerInterval;
		String[] arrayVerjaardag, arrayInterval;
		int jaarInterval1, jaarInterval2;
		int dag = 0, maand = 0, jaar = 0;

		System.out.println
		("Dit programma werkt accuraat vanaf 15 October 1582");

		do {
			System.out.print("Geef en verjaardag (dd-mm-jjjj): ");

			invoerVerjaardag = invoer.next();

			if(patroonVerjaardag(invoerVerjaardag)) {
				arrayVerjaardag = invoerVerjaardag.split("-");

				dag = Integer.parseInt(arrayVerjaardag[0]);
				maand = Integer.parseInt(arrayVerjaardag[1]);
				jaar = Integer.parseInt(arrayVerjaardag[2]);

				if(datum(dag, maand, jaar)) {
					System.out.println
					("Je verjaardag is op een " +
					weekdag(dag, maand, jaar) + "\n");

					incorrect = false;
				} else {
					System.out.println
					("Je ingevoerde datum bestaat niet\n");

					incorrect = true;
				}
			} else {
				System.out.println
				("Je invoer formaat is niet goed\n");

				incorrect = true;
			}
		} while(incorrect == true);

		do {
			System.out.print("Geef en interval (jjjj-jjjj): ");

			invoerInterval = invoer.next();

			if(patroonInterval(invoerInterval)) {
				arrayInterval = invoerInterval.split("-");

				jaarInterval1 = Integer.parseInt(arrayInterval[0]);
				jaarInterval2 = Integer.parseInt(arrayInterval[1]);

				if(jaarInterval1 < jaarInterval2) {
					zelfdeWeekdag(jaarInterval1, jaarInterval2,
					dag, maand, weekdag(dag, maand, jaar));

					incorrect = false;
				} else {
					System.out.println("Je ingevoerde begin jaar"
					+ " is kleiner of gelijk aan eind jaar\n");

					incorrect = true;
				}
			} else {
				System.out.println("Je invoer formaat is niet goed\n");
				incorrect = true;
			}
		} while(incorrect == true);
	}

	/*
	 * Methode om invoer te vergelijken met een reguliere expressie 
	 */
	static boolean patroonVerjaardag(String invoer) {
		return invoer.matches("[0-9]{2}-[0-9]{2}-[0-9]{4}");
	}

	/*
	 * Methode om invoer te vergelijken met een reguliere expressie 
	 */
	static boolean patroonInterval(String invoer) {
		return invoer.matches("[0-9]{4}-[0-9]{4}");
	}

	/*
	 * Methode om te kijken of ingevoerde jaar een schikkeljaar is
	 */
	static boolean schrikkelJaar(int jaar) {
		boolean schrikkel;
		
		if(jaar % 4 == 0)
			schrikkel = true;
		else if(jaar % 100 == 0)
			schrikkel = true;
		else if(jaar % 400 == 0)
					schrikkel = true;
		else
			schrikkel = false;
		
		return schrikkel;
	}

	/*
	 * Methode om te kijken of ingevoerde datum bestaat
	 */
	static boolean datum(int dag, int maand, int jaar) {
		boolean bestaat;

		if((maand == 1 || maand == 3 || maand == 5 || maand == 7 || maand == 8 ||
		maand == 10|| maand == 12) && (dag > 31 || dag < 1))
			bestaat = false;
		else if((maand == 4 || maand == 6 || maand == 9 || maand == 11) &&
		(dag > 30 || dag < 1))
			bestaat = false;
		else if(schrikkelJaar(jaar) && (dag > 29 || dag < 1))
			bestaat = false;
		else if(!schrikkelJaar(jaar) && (dag > 28 || dag < 1))
			bestaat = false;
		else if(maand > 12 || maand < 1)
			bestaat = false;
		else
			bestaat = true;

		return bestaat;
	}

	/*
	 * Methode om een maand nummer om te zetten naar een bijbehorende maand naam 
	 */
	static String maandToString(int maand) {
		String maandString = "";
		if(maand == 1)
			maandString = "januari";
		else if(maand == 2)
			maandString = "februari";
		else if(maand == 3)
			maandString = "maart";
		else if(maand == 4)
			maandString = "april";
		else if(maand == 5)
			maandString = "mei";
		else if(maand == 6)
			maandString = "juni";
		else if(maand == 7)
			maandString = "juli";
		else if(maand == 8)
			maandString = "augustus";
		else if(maand == 9)
			maandString = "september";
		else if(maand == 10)
			maandString = "october";
		else if(maand == 11)
			maandString = "november";
		else if(maand == 12)
			maandString = "december";

		return maandString;
	}

	/*
	 * Methode voor het berekenen welke dag van de week een ingevoerde datum is
	 * Algoritme komt van Sakamoto's Methode van Tomohiko Sakamoto
	 * Bron: http://en.wikipedia.org/wiki/Weekday_determination
	 */
	static String weekdag(int dag, int maand, int jaar) {
		String dagVanDeWeek = "";
		int getallenArray[] = {0,3,2,5,0,3,5,1,4,6,2,4};
		int uitkomst;

		if(maand < 3)
			jaar--;

		uitkomst = (jaar + jaar/4 - jaar/100 + jaar/400 +
		getallenArray[maand - 1] + dag) % 7;

		if(uitkomst == 0)
			dagVanDeWeek = "zondag";
		else if(uitkomst == 1)
			dagVanDeWeek = "maandag";
		else if(uitkomst == 2)
			dagVanDeWeek = "dinsdag";
		else if(uitkomst == 3)
			dagVanDeWeek = "woensdag";
		else if(uitkomst == 4)
			dagVanDeWeek = "donderdag";
		else if(uitkomst == 5)
			dagVanDeWeek = "vrijdag";
		else if(uitkomst == 6)
			dagVanDeWeek = "zaterdag";

		return dagVanDeWeek;
	}

	/*
	 * Methode voor het berekenen welke jaren je verjaardag op dezelfde dag van de week valt
	 */
	static void zelfdeWeekdag
	(int jaarBegin, int jaarEind, int dag, int maand, String dagVanDeWeek) {
		System.out.println(dag + " " + maandToString(maand) +
		" is een " + dagVanDeWeek + " in de volgende jaren:");

		for(int i = jaarBegin; i <= jaarEind; i++)
			if(weekdag(dag, maand, i) == dagVanDeWeek) {
				if(!schrikkelJaar(i) && maand == 2 && dag == 29)
					System.out.print("");
				else
					System.out.print(i + " ");
			}
	}
}
