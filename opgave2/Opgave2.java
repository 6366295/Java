/*
* Naam: Mike Trieu
* Studentennummer: 10105093 / 6366295
* Opleiding: Informatica
*/

import java.util.*;

public class Opgave2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Voer een geheel aantal seconden in:");
		int seconden = scanner.nextInt();

		int uren = seconden / 3600;
		int restSeconden = seconden % 3600;
		int minuten = restSeconden / 60;
		int restSeconden2 = restSeconden % 60;

		System.out.println(" ");
		System.out.println("Het totaal aantal seconden komt overeen met:");
		System.out.println(uren + " uur " + minuten + " minuten " + restSeconden2 + " Seconden");
		System.out.println(" ");


		System.out.println(" ");
		System.out.println("Geef een integer tussen 0 en 128:");
		System.out.println(" ");
		int input = scanner.nextInt();

		if(input < 0 | input > 128) {
			System.out.println("Dit is geen integer tussen 0 en 128");
		}
		else {
			System.out.println("Het corresponderende ASCII karakter is: " + (char)input);
		}
		System.out.println(" ");


		System.out.println("Geef de straal van een bol (een double):");
		double input2 = scanner.nextDouble();

		double oppervlakte = 4 * Math.PI * input2 * input2;
		double a = 4;
		double b = 3;
		double volume = a / b * Math.PI * input2 * input2 * input2;
		System.out.println(" ");
		System.out.println("De oppervlakte is: " + oppervlakte);
		System.out.println(" ");
		System.out.println("De volume is: " + volume);
		System.out.println(" ");


		System.out.println("Afgerond op 3 decimalen krijgen we:");
		double oppervlakteTemp = Math.round(oppervlakte * 1000);
		double oppervlakte2 = oppervlakteTemp / 1000;
		double volumeTemp = Math.round(volume * 1000);
		double volume2 = volumeTemp / 1000;
		System.out.println(" ");
		System.out.println("Oppervlakte: " + oppervlakte2);
		System.out.println("Volume: " + volume2);
	}
}
