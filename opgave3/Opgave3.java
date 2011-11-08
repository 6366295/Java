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
 *  Functie 3:
 *  -
 *
 * - Gebruik: java Opgave3
 */

import java.util.*;

public class Opgave3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Geef een natuurlijk getal: ");

		if(input.hasNextInt()) {
			int lucasGetal = input.nextInt();
			lucasReeks(lucasGetal);
		} else {
			input.next();
			System.out.println("Dit is geen natuurlijk getal!\n");
		}
	}


	static void lucasReeks(int aantal) {
		int lucasEen, lucasTwee, lucasNieuw;

		lucasEen = 2;
		lucasTwee = 1;

		if(aantal == 2) {
			System.out.print("De eerste " + aantal + " Lucas-getallen: " + lucasEen + " " + lucasTwee);
		} else if(aantal == 1) {
			System.out.println("De eerste " + aantal + " Lucas-getallen: " + lucasEen);
		} else if(aantal < 1) {
			System.out.println("De eerste " + aantal + " Lucas-getallen: ");
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


	static double macht(int grondtal, int exp) {
		int grondtalNieuw, grondtalNieuw2;

		if(grondtal != 0 && exp > 0) {
			while(exp > 0) {
				grondtalNieuw = grondtal * grondtal;
				grondtalNieuw2 = grondtal * grondtalNieuw;

				exp--;
			}
		}
		return(grondtalNieuw2);
	}
}
