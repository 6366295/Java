/*
 * DNAMatch v1.0
 * author  :  Dr. Quakerjack. 
 * date    :  06-12-2011
 * version :  1.0 
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class Opgave9 {
	/*
	 * Main methode stond op verkeerde plek (Eind van het programma)
	 * exeCnsl(); verwijst naar methode voor user interface, maar deze code staat al in main
	 * exeCnsl(); methode verwijdert
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to DNA Matcher v1.0\n");

		database = new ArrayList<String>();

		boolean quit = false;

		/*
		 * Alle C == ... verandert naar C.equals(...), C == ... werkt niet omdat het dan verwijzingen vergelijkt
		 * else if functies vergelijkt met Hoofdletters, dus alle equals moeten in hoofdletters
		 * String A; A = ...; verkort naar String A = ...;
		 * Een elseif verandert naar else if
		 * while(!(quit = false)) verandert naar while(quit == false)
		 */
		do {
			System.out.print("console>");

			String A = readLine();
			String[] P = A.split("\\s");
			String C = P[0].toUpperCase();

			if(C.equals("HELP")) {
				helpUser();
			} else if(C.equals("QUIT")) {
				quit = true;
			} else if(C.equals("LIST")) {
				listDatabase();
			} else if(C.equals("ADD")) {
				if(P.length != 2 || !(P[1].matches("[A-Z]{6}")))
					System.out.println("Invoer formaat klopt niet");
				else
					addStringToDatabase(P[1]);
			} else if(C.equals("REMOVE")) {
				if(P.length != 2 || !(P[1].matches("[A-Z]{6}")))
					System.out.println("Invoer formaat klopt niet");
				else
					removeFromDatabase(P[1]);
			} else if(C.equals("COMPARE")) {
				if(P.length != 3)
					System.out.println("Invoer formaat klopt niet");
				else
					compare(P[1], P[2]);
			} else if(C.equals("RETRIEVE")) {
				if(P.length != 2 || !(P[1].matches("[A-Z]{6}")))
					System.out.println("Invoer formaat klopt niet");
				else
					showDatabase(P[1]);
			} else {
				System.out.println("Skipping...");
			}
		} while(quit == false);
	}

	public static ArrayList<String> database;

	/*
	 * Methode om een input in te lezen
	 *
	 * Hernoemt naar readLine
	 * functie returned geen string of kan er niet bij.
	 * String initialiseren in het begin en return die string
	 * vergeten } toegevoegd
	 */
	public static String readLine() {
		Scanner input = new Scanner(System.in);
		String line = "";
		if(input.hasNextLine()) {
			line = input.nextLine();
		} return line;
	}

	/*
	 * Methode voor het printen van alle commands van het programma
	 *
	 * Hernoemt naar helpUser
	 * Een void methode van gemaakt, omdat het niets nuttigs retoerneert (was eerst string methode)
	 * COMMANDS... uitgebreid
	 */
	public static void helpUser() {
		System.out.println("commands:");
		System.out.println("help");
		System.out.println("list");
		System.out.println("add [6 characters]");
		System.out.println("remove [6 characters]");
		System.out.println("compare [characters] [characters]");
		System.out.println("retrieve [6 characters]");
	}

	/*
	 * Methode voor het printen van een arrayList
	 *
	 * Hernoemt naar listDatabase
	 * System.out.println() verandert naar System.out.println(s), omdat het anders niets print
	 * System.out.println() na de foreach weggehaald, omdat het niks nuttigs print
	 * vergeten } toegevoegd
	 */
	public static void listDatabase() {
		for(String s : database) {
			System.out.println(s);
		}
	}

	/*
	 * Methode voor het toevoegen van een string in een arrayList
	 *
	 * Hernoemt naar addStringToDatabase
	 * database.put(i) verandert naar database.add(i), omdat put niet in arrayList zit
	 */
	public static void addStringToDatabase(String input) {
		database.add(input);
	}

	/* 
	 * Methode voor het verwijderen van een string uit een arrayList
	 *
	 * Hernoemt naar removeFromDatabase
	 * database.delete(i) verandert naar database.remove(i), omdat delete niet in arrayList zit
	 */
	public static void removeFromDatabase(String input) {
		database.remove(database.indexOf(input));
	}

	/* 
	 * Hernoemt naar compare
	 * System.out.prntln("Difference = " . mss(a, aa, true)); verbetert naar
	 *   System.out.println("Difference = " + mss(a, aa, true));
	 */
	public static void compare(String dna1, String dna2) {
		System.out.println("Difference = " + mss(dna1, dna2, true));
	}

	/*
	 * Methode om te berekenen hoeveel verschillen er zijn tussen 2 strings
	 * Gebruikt Levenshtein algoritme
	 *
	 * Levenshtein algoritme niet correct geimplementeerd:
	 *   int i = 1 verandert naar i = 0
	 *   d[i][0] = j; verandert naar d[i][0] = i; 
	 *   d[0][i] = j; verandert naar d[0][j] = j;
	 *   bij de for for loop de i en j omgedraaid, a en b omgedraaid
	 *   bij a.charAt... j verandert naar j - 1, != verandert naar ==
	 *   d[i-1][j - 1] - 1 verandert naar d[i-1][j] + 1 
	 * vergeten } toegevoegd
	 * ll, Il verandert naar l1
	 */
	public static int mss(String dna1, String dna2, boolean print) {
		int[][] matrix = new int[dna2.length() + 1][dna1.length() + 1];
		int i = 0, j = 0;

		for(;i<=dna2.length();i++)
			matrix[i][0] = i;
		for(;j<=dna1.length();j++)
			matrix[0][j] = j;

		for(i=1;i<=dna1.length();i++) {
			for(j=1;j<=dna2.length();j++) {
				if(dna1.charAt(i - 1) == dna2.charAt(j - 1)) {
					matrix[i][j] = matrix[i-1][j-1];
				} else {
					matrix[i][j] = min_3(matrix[i-1][j] + 1, matrix[i][j-1] + 1, matrix[i-1][j-1] + 1);
				}
			}
		}
		if(print) {
			for(int l1 = 0; l1 <= dna1.length(); l1++) {
				for(int l2 = 0; l2 <= dna2.length(); l2++) {
						System.out.print(matrix[l2][l1] + "  ");
				}
				System.out.println("\n");
			}
		}
		return matrix[dna2.length()][dna1.length()];
	}

	/*
	 * Methode die laagste integer retoerneert 
	 * a < b ? b < c ? a : c : b < c ? c : b; vervangen door Math.min(Math.min(a, b), c)
	 */
	private static int min_3(int a, int b, int c) {
		return Math.min(Math.min(a, b), c);
	}

	/*
	 * Methode om database te laten zien
	 *
	 * String[] sq = new String[database.length()] verandert naar String[] sq = new String[database.size()]
	 * int[] ds = new int[sq.length()]; verandert naar int[] ds = new int[sq.length];
	 * vergeten { en } toegevoegt
	 * ds[y - 1] = ds[x - 1]; verandert naar ds[y - 1] = ds[x];, omdat ander array out of bounds
	 */
	public static void showDatabase(String input) {
		String[] sq = new String[database.size()];
		database.toArray(sq);
		int r = 0;
		int[] ds = new int[sq.length];
		for(String s : database) {
			ds[r++] = mss(input, s, false);
		}
		for(int x = 0; x < sq.length; x++) {
			for(int y = 1; y < sq.length; y++) {
				if(ds[y - 1] > ds[y]) {
					int t1 = ds[y];
					String t2 = sq[y - 1];
					ds[y - 1] = ds[x];
					ds[x] = t1;
					sq[y - 1] = sq[y];
					sq[x] = t2;
				}
			}
		}
		System.out.println("Best matches: ");
		for(r = 0; r < Math.min(3, sq.length); r++) {
			System.out.println(ds[r] + "\t" + sq[r]);
		}
	}
}