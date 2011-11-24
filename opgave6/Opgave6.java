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
		Hotel hotel = new Hotel(4);

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
					System.out.println("Ongeldige invoer!\n");
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
	Gast gast = new Gast();
	Kamer kamer[];

	String voornaam, achternaam;
	int invoer, bezet = 0;

	/*
	 * Constructor die de kamers maakt
	 */
	Hotel(int kamers){
		kamer = new Kamer[kamers];

		for(int i = 0; i < kamers; i++){
			kamer[i] = new Kamer(i);
		}
        }

	/*
	 * methode dat een lijst met alle kamers en de bezetting van de kamers geeft
	 */
	void overzicht() {
		for(int i = 0; i < kamer.length; i++) {
			System.out.println("Kamer " + kamer[i].kamernummer + ": " +
			kamer[i].voornaam + " " +  kamer[i].achternaam);
		}
		System.out.println("");
	}

	/*
	 * methode om de gebruiker in te checken, mits er een kamer vrij is
	 */
	void checkin() {
		if(bezet == kamer.length){
			System.out.println("Er zijn momenteel helaas geen kamers vrij\n");
		} else {
			for(int i = 0; i < kamer.length; i++) {
				if(kamer[i].ruimte == true) {
					System.out.print("Voornaam nieuwe gast: ");
					if(scanner.hasNext()) {
						voornaam = scanner.next();
						kamer[i].voornaam = voornaam;
						break;
					} else {
						System.out.println("Ongeldige invoer!\n");
						scanner.next();
					}
				}
			}

			for(int i = 0; i < kamer.length; i++) {
				if(kamer[i].ruimte == true) {
					System.out.print("Achternaam nieuwe gast: ");
					if(scanner.hasNext()) {
						achternaam = scanner.next();
						kamer[i].achternaam = achternaam;
						break;
					} else {
						System.out.println("Ongeldige invoer!\n");
						scanner.next();
					}
				}
			}

			for(int i = 0; i < kamer.length; i++) {
				if(kamer[i].ruimte == true) {
					System.out.println
					("Gast " + kamer[i].voornaam + " " + kamer[i].achternaam +
					" krijgt kamer " + kamer[i].kamernummer);
					kamer[i].ruimte = false;
					bezet++;
					break;
				}
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
			if(invoer < 0 || invoer > 3) {
				System.out.println ("Ongeldige invoer!\n");
			} else {
				for(int i = 0; i < kamer.length; i++) {
					if(invoer == i && kamer[i].ruimte == false) {
						bezet--;
						System.out.println
						("\nGast " + kamer[i].voornaam + " " + kamer[i].achternaam +
						 " is uitgechecked\n");

						kamer[i].ruimte = true;
						kamer[i].voornaam = "Vrij";
						kamer[i].achternaam = "";
						bezet--;
						break;
					} else if(invoer == i && kamer[i].ruimte == true) {
						System.out.println("\nNiemand is ingechecked in deze kamer\n");
						break;
					}
				}
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
	Gast gast = new Gast();

	boolean ruimte;
	int kamernummer = 0;
	String voornaam, achternaam;

	Kamer(int nummer) {
		ruimte = true;
		kamernummer = nummer;
		voornaam = gast.voornaam;
		achternaam = gast.achternaam;
	}
}

/*
 * Klasse voor het maken van een gast object
 */
class Gast {
	String voornaam, achternaam;

	Gast() {
		voornaam = "Vrij";
		achternaam = "";
	}
}
