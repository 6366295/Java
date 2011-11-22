/*
 * Naam:		Mike Trieu
 * Studentennummer:	10105093 / 6366295
 * Studie:		Informatica
 *
 * Programma functie: 
 * - Simpel hotel-administratie systeem
 *  - De gasten kunnen inchecken door een voornaam en achternaam in te voeren
 *    - Als Alle kamers bezet zijn, wordt dit aangegeven
 *  - De eerste lege kamer wordt aangewezen aan de nieuwe gast
 *  - De gasten kunnen uitchecken door hun kamernummer in te voeren
 *    - Als een kamernummer wordt gegeven dat ongeldig of niet bezet is, wordt dit
 *     aangegeven
 *  - Het programma wordt beeindigd door 'Einde' te kiezen in het menu
 *
 * - Gebruik: java Opgave6
 */

import java.util.*;
import java.io.*;

public class Opgave6 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		Hotel hotel = new Hotel();

		boolean einde = false;
		int invoer;

		do {
			System.out.println("Menu: [1] Status Overzicht");
			System.out.println("      [2] Check-in");
			System.out.println("      [3] Check-out");
			System.out.println("      [4] Einde");

			System.out.print("Uw invoer: ");
			if(scanner.hasNextInt()) {
				invoer = scanner.nextInt();
				if(invoer < 1 || invoer > 4) {
					System.out.println
					("Ongeldige invoer!\n");
				} else if(invoer == 1) {
					hotel.overzicht();
				} else if(invoer == 2) {
					hotel.checkin();
				} else if(invoer == 3) {
					hotel.checkout();
				} else if(invoer == 4) {
					einde = true;
				}
			} else {
				System.out.println("Ongeldige invoer!\n");
				scanner.next();
			}
		} while(einde == false);
	}
}

/*
 * Klasse voor het maken van een hotel object
 * Beheert de kamers
 */
class Hotel {
	Scanner scanner = new Scanner(System.in);
	Kamer kamer1 = new Kamer();
	Kamer kamer2 = new Kamer();
	Kamer kamer3 = new Kamer();
	Kamer kamer4 = new Kamer();
	Gast gast = new Gast();

	int invoer;
	String voornaam, achternaam;

	/*
	 * methode dat een lijst met alle kamers en de bezetting van de kamers geeft
	 */
	void overzicht() {
		System.out.println("Kamer 1: " + kamer1.ruimte);
		System.out.println("Kamer 1: " + kamer2.ruimte);
		System.out.println("Kamer 1: " + kamer3.ruimte);
		System.out.println("Kamer 1: " + kamer4.ruimte + "\n");
	}

	/*
	 * methode om de gebruiker in te checken, mits er een kamer vrij is
	 */
	void checkin() {
		if(kamer1.ruimte != "Vrij" && kamer2.ruimte != "Vrij" &&
			kamer3.ruimte != "Vrij" && kamer4.ruimte != "Vrij") { 
			System.out.println
			("Er zijn momenteel helaas geen kamers vrij\n");
		} else {
			System.out.print("Voornaam nieuwe gast: ");
			if(scanner.hasNext()) {
				voornaam = scanner.next();
				gast.voornaam = voornaam;
			} else {
				System.out.println("Ongeldige invoer!\n");
				scanner.next();
			}

			System.out.print("Achternaam nieuwe gast: ");
			if(scanner.hasNext()) {
				achternaam = scanner.next();
				gast.achternaam = achternaam;
			} else {
				System.out.println("Ongeldige invoer!\n");
				scanner.next();
			}

			if(kamer1.ruimte == "Vrij") {
				kamer1.ruimte =
				gast.voornaam + " " + gast.achternaam;

				System.out.println
				("Gast " + kamer1.ruimte + " krijgt kamer 1\n");
			} else if(kamer2.ruimte == "Vrij") {
				kamer2.ruimte =
				gast.voornaam + " " + gast.achternaam;

				System.out.println
				("Gast " + kamer2.ruimte + " krijgt kamer 2\n");
			} else if(kamer3.ruimte == "Vrij") {
				kamer3.ruimte =
				gast.voornaam + " " + gast.achternaam;

				System.out.println
				("Gast " + kamer3.ruimte + " krijgt kamer 3\n");
			} else if(kamer4.ruimte == "Vrij") {
				kamer4.ruimte =
				gast.voornaam + " " + gast.achternaam;

				System.out.println
				("Gast " + kamer4.ruimte + " krijgt kamer 4\n");
			}
		}
	}

	/*
	 * methode om de gebruiker uit te checken, mits de kamer bezet is
	 */
	void checkout() {
		System.out.print("Kamernummer vertrekkende gast: ");
		if(scanner.hasNextInt()) {
			invoer = scanner.nextInt();
			if(invoer < 1 || invoer > 4) {
				System.out.println
				("Ongeldige invoer!\n");
			} else if(invoer == 1 && kamer1.ruimte != "Vrij") {
				System.out.println
				("\nGast " + kamer1.ruimte + " is uitgechecked\n");
				kamer1.ruimte = "Vrij";
			} else if(invoer == 2 && kamer2.ruimte != "Vrij") {
				System.out.println
				("\nGast " + kamer2.ruimte + " is uitgechecked\n");
				kamer2.ruimte = "Vrij";
			} else if(invoer == 3 && kamer3.ruimte != "Vrij") {
				System.out.println
				("\nGast " + kamer3.ruimte + " is uitgechecked\n");
				kamer3.ruimte = "Vrij";
			} else if(invoer == 4 && kamer4.ruimte != "Vrij") {
				System.out.println
				("\nGast " + kamer4.ruimte + " is uitgechecked\n");
				kamer4.ruimte = "Vrij";
			} else {
				System.out.println
				("\nNiemand is ingechecked in deze kamer\n");
			}
		} else {
			System.out.println("Ongeldige invoer!\n");
			scanner.next();
		}
	}
}

/*
 * Klasse voor het maken van een kamer object
 */
class Kamer {
	String ruimte;

	Kamer() {
		ruimte = "Vrij";
	}
}

/*
 * Klasse voor het maken van een gast object
 */
class Gast {
	String voornaam, achternaam;

	Gast() {
		voornaam = "";
		achternaam = "";
	}
}
