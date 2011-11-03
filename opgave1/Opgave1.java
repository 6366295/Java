/*
 * Naam: Mike Trieu
 * Studentennummer: 10105093 / 6366295
 * Studie: Informatica
 *
 * Programma functie:
 * Dit programma telt n tot 0 bij elkaar op.
 * Wanneer een invoer wordt gegeven buiten het bereik, dan wordt dat aangegeven.
 */

public class Opgave1 {
	public static void main(String[] args) {
		/*
		 * Commandline invoer wordt verwerkt.
		 * De uitvoer wordt berekend door de functie som.
		 */
		int n = Integer.parseInt(args[0]);
		int nsom = som(n);
		System.out.println(nsom);
	}

	public static int som(int k) {
		if(k < 0)
			System.out.println("Dit programma werkt maar tot en met 0");
		if(k > 65535)
			System.out.println("Invoer getal is te groot voor dit programma");
		if(k == 0)
			return 0;

		int ksom = 1;
		while(k > 1) {
			ksom = ksom + k;
			k = k - 1;
		}
		return ksom;
	}
}