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
 * - Gebruik: java Opgave3
 */

import java.util.*;

public class Opgave3 {
	public static void main(String[] args) {
		Scanner invoer = new Scanner(System.in);

		boolean opnieuw = false;
		String antwoord;

		do {
			System.out.print("Geef een natuurlijk getal: ");
			if(invoer.hasNextInt()) {
				int lucasGetal = invoer.nextInt();
				lucasReeks(lucasGetal);

				System.out.print("\nNogmaals? [y/n]: ");
				if(invoer.hasNext()) {
					antwoord = invoer.next();
					if(antwoord.toLowerCase().equals("y"))
						opnieuw = true;
					else
						opnieuw = false;
				}
			} else {
				invoer.next();
				System.out.println("Dit is geen natuurlijk getal!");
				opnieuw = true;
			}
		} while(opnieuw == true);



		System.out.println("\nWe gaan nu machtsverheffen");
		do {
			System.out.print("Geef een integer (het grondtal): ");
			if(invoer.hasNextInt()) {
				int grondtal2 = invoer.nextInt();

				System.out.print("Geef een integer (het exponent): ");
					if(invoer.hasNextInt()) {
						int exp2 = invoer.nextInt();
						macht(grondtal2, exp2);

						System.out.print("Nogmaals? [y/n]: ");
						if(invoer.hasNext()) {
						antwoord = invoer.next();
							if(antwoord.toLowerCase().equals("y"))
								opnieuw = true;
							else
								opnieuw = false;
						}
					} else {
						invoer.next();
						System.out.println("Dit is geen integer!");
						opnieuw = true;
					}


			} else {
				invoer.next();
				System.out.println("Dit is geen integer!");
				opnieuw = true;
			}
		} while(opnieuw == true);
	}


	/*
	 *
	 *
	 *
	 */
	static void lucasReeks(int aantal) {
		int lucasEen, lucasTwee, lucasNieuw;

		lucasEen = 2;
		lucasTwee = 1;

		if(aantal == 2) {
			System.out.print("De eerste " + aantal + " Lucas-getallen: " + lucasEen + " " + lucasTwee);
		} else if(aantal == 1) {
			System.out.print("De eerste " + aantal + " Lucas-getallen: " + lucasEen);
		} else if(aantal < 1) {
			System.out.print("De eerste 0 Lucas-getallen: ");
		} else {
			System.out.print("De eerste " + aantal + " Lucas-getallen: " + lucasEen + " " + lucasTwee + " ");
			do {
				lucasNieuw = lucasTwee + lucasEen;
				lucasEen = lucasTwee;
				lucasTwee = lucasNieuw;

				System.out.print(lucasNieuw + " ");

				aantal--;
			} while(aantal > 2);
		}
	}



	/*
	 *
	 *
	 *
	 */
	static double macht(int grondtal, int exp) {
		double uitkomstTemp, uitkomst;

		uitkomst = 1.0;
		uitkomstTemp = 1.0;

		if(grondtal != 0 && exp > 0) {
			while(exp > 0) {
				uitkomst = grondtal * uitkomst;

				exp--;
			}
			System.out.println("De uitkomst van " + grondtal + " tot-de-macht " + exp + " is: " + uitkomst);
		} else if(grondtal != 0 && exp < 0) {
			while(exp < 0) {
				uitkomstTemp = grondtal * uitkomstTemp;
				uitkomst = 1.0 / uitkomstTemp;

				exp++;
			}
			System.out.println("De uitkomst van " + grondtal + " tot-de-macht " + exp + " is: " + uitkomst);
		} else if(grondtal != 0 && exp == 0) {
			System.out.println("De uitkomst van " + grondtal + " tot-de-macht " + exp + " is: 1.0");
		} else if(grondtal == 0 && exp > 0) {
			System.out.println("De uitkomst van " + grondtal + " tot-de-macht " + exp + " is: 0.0");
		} else {
			System.out.println("De uitkomst van " + grondtal + " tot-de-macht " + exp + " is: Ongedefineerd");
		}
		return uitkomst;
	}
}
