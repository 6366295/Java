/*
 * Naam:		Mike Trieu
 * Studentennummer:	10105093 / 6366295
 * Studie:		Informatica
 *
 * Programma functie: 
 * - Het programma leest de voorkeurstemmen uit een file
 * - De file wordt omgezet naar een voorkeurtabel matrix
 * - Met behulp van voorkeurtabel wordt een kandidatentabel matrix gemaakt
 * - Met behulp van de kandidatentabel wordt degene die het minste stemmen heeft bepaald
 * - Het programma maakt nieuwe voorkeurtabel en kandidatentabel zonder degene die het
 *   minste aantal stemmen heeft gehaald
 * - De laatste 3 stappen worden herhaald totdat er een winnaar is
 * - Elke nieuwe voorkeurtabele en kandidatentabel wordt uitgeprint
 * 
 * Opmerkingen:
 * - Het verschuiven van matrix en het bepalen van de verliezer klopt niet helemaal
 *   - Een input met gelijkspel komt bijvoorbeeld niet uit op gelijkspel
 *   - In plaats van verschuiving alles wat eruit moest verandert naar 999
 * - Programma werkt traag doordat de code omslachtig is
 *
 * - Gebruik: java Opgave5 'filenaam.txt'
 */

import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Opgave5 {
	public static void main(String[] args) {
		if(args.length != 1) {
			System.err.println("Gebruik: java Opgave5 'filenaam'");
			return;
		}
		inlezenFile(args[0]);
	}



	/*
	 * Methode voor het inlezen van een txt file
	 * De ingelezen data wordt omgezet naar een matrix en print deze uit
	 */
	static boolean inlezenFile(String filenaam) {
		BufferedReader reader;

		int i, j, k, aantalkandidaten, aantalkiezers;

		i = 0;
		j = 0;
		k = 0;
		aantalkandidaten = 0;
		aantalkiezers = 0;

		try {
			reader = new BufferedReader(new FileReader(filenaam));
		} catch(FileNotFoundException fnf) {
			System.err.println("Error: " + fnf.getMessage());
			return false;
		}

		try {
			while(true) {
				String regel = reader.readLine();

				if(i == 0) {
					aantalkandidaten = Integer.parseInt(regel);
					i++;
				} else if(i == 4) {
					aantalkiezers = Integer.parseInt(regel);
					i++;
					break;
				}
				i++;
			}
		} catch(IOException ioe) {
			System.err.println("Error: " + ioe.getMessage());
			return false;
		}

		/*
		 * De code dat de data in een matrix zet
		 */
		char[] arrayRegel = new char[aantalkandidaten];
		char[][] stemmen = new char[aantalkiezers][aantalkandidaten];

		try {
			for(k = 0; k < aantalkiezers; k++) {
				String regel = reader.readLine();

				if(regel == null)
					break;

				if(i > 4 && i < aantalkiezers + 6) {
					for(int l = 0; l < regel.length(); l++)
						regel = regel.replace(" ","");

					arrayRegel = regel.toCharArray();
				}
				i++;

				for(j = 0; j < aantalkandidaten; j++)
					stemmen[k][j] = arrayRegel[j];
			}

			System.out.println("\nVoorkeurtabel:");
			System.out.println("------");
			System.out.println("123456");
			System.out.println("------");
			for(int x = 0; x < aantalkiezers; x++)
				System.out.println(stemmen[x]);
 
			for(int y = 1; y < aantalkandidaten; y++) {
				nieuwMatrix(stemmen);
			}
		} catch(IOException ioe) {
			System.err.println("Error: " + ioe.getMessage());
			return false;
		}
		return true;
	}


	/*
	 * Methode voor het maken van een kandidatentabel en print deze uit
	 */
	static int[][] kandidatentabel(char[][] matrix) {
		int a1 = 0, a2 = 0, a3 = 0, a4 = 0, a5 = 0, a6 = 0;
		int b1 = 0, b2 = 0, b3 = 0, b4 = 0, b5 = 0, b6 = 0;
		int c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0, c6 = 0;
		int d1 = 0, d2 = 0, d3 = 0, d4 = 0, d5 = 0, d6 = 0;
		int e1 = 0, e2 = 0, e3 = 0, e4 = 0, e5 = 0, e6 = 0;
		int f1 = 0, f2 = 0, f3 = 0, f4 = 0, f5 = 0, f6 = 0;

		for(int i = 0; i < matrix.length; i++)
			if(matrix[i][0] == 'A')
				a1++;
			else if(matrix[i][0] == 'B')
				b1++;
			else if(matrix[i][0] == 'C')
				c1++;
			else if(matrix[i][0] == 'D')
				d1++;
			else if(matrix[i][0] == 'E')
				e1++;
			else if(matrix[i][0] == 'F')
				f1++;
		for(int i = 0; i < matrix.length; i++)
			if(matrix[i][1] == 'A')
				a2++;
			else if(matrix[i][1] == 'B')
				b2++;
			else if(matrix[i][1] == 'C')
				c2++;
			else if(matrix[i][1] == 'D')
				d2++;
			else if(matrix[i][1] == 'E')
				e2++;
			else if(matrix[i][1] == 'F')
				f2++;
		for(int i = 0; i < matrix.length; i++)
			if(matrix[i][2] == 'A')
				a3++;
			else if(matrix[i][2] == 'B')
				b3++;
			else if(matrix[i][2] == 'C')
				c3++;
			else if(matrix[i][2] == 'D')
				d3++;
			else if(matrix[i][2] == 'E')
				e3++;
			else if(matrix[i][2] == 'F')
				f3++;
		for(int i = 0; i < matrix.length; i++)
			if(matrix[i][3] == 'A')
				a4++;
			else if(matrix[i][3] == 'B')
				b4++;
			else if(matrix[i][3] == 'C')
				c4++;
			else if(matrix[i][3] == 'D')
				d4++;
			else if(matrix[i][3] == 'E')
				e4++;
			else if(matrix[i][3] == 'F')
				f4++;
		for(int i = 0; i < matrix.length; i++)
			if(matrix[i][4] == 'A')
				a5++;
			else if(matrix[i][4] == 'B')
				b5++;
			else if(matrix[i][4] == 'C')
				c5++;
			else if(matrix[i][4] == 'D')
				d5++;
			else if(matrix[i][4] == 'E')
				e5++;
			else if(matrix[i][4] == 'F')
				f5++;
		for(int i = 0; i < matrix.length; i++)
			if(matrix[i][5] == 'A')
				a6++;
			else if(matrix[i][5] == 'B')
				b6++;
			else if(matrix[i][5] == 'C')
				c6++;
			else if(matrix[i][5] == 'D')
				d6++;
			else if(matrix[i][5] == 'E')
				e6++;
			else if(matrix[i][5] == 'F')
				f6++;

		if(a1 == matrix.length || a2 == matrix.length ||
		a3 == matrix.length || a4 == matrix.length ||
		a5 == matrix.length || a6 == matrix.length) {
			a1 = 999;
			a2 = 999;
			a3 = 999;
			a4 = 999;
			a5 = 999;
			a6 = 999;
		}

		if(b1 == matrix.length || b2 == matrix.length ||
		b3 == matrix.length || b4 == matrix.length ||
		b5 == matrix.length || b6 == matrix.length) {
			b1 = 999;
			b2 = 999;
			b3 = 999;
			b4 = 999;
			b5 = 999;
			b6 = 999;
		}	

		if(c1 == matrix.length || c2 == matrix.length ||
		c3 == matrix.length || c4 == matrix.length ||
		c5 == matrix.length || c6 == matrix.length) {
			c1 = 999;
			c2 = 999;
			c3 = 999;
			c4 = 999;
			c5 = 999;
			c6 = 999;
		}	

		if(d1 == matrix.length || d2 == matrix.length ||
		d3 == matrix.length || d4 == matrix.length ||
		d5 == matrix.length || d6 == matrix.length) {
			d1 = 999;
			d2 = 999;
			d3 = 999;
			d4 = 999;
			d5 = 999;
			d6 = 999;
		}	

		if(e1 == matrix.length || e2 == matrix.length ||
		e3 == matrix.length || e4 == matrix.length ||
		e5 == matrix.length || e6 == matrix.length) {
			e1 = 999;
			e2 = 999;
			e3 = 999;
			e4 = 999;
			e5 = 999;
			e6 = 999;
		}	

		if(f1 == matrix.length || f2 == matrix.length ||
		f3 == matrix.length || f4 == matrix.length ||
		f5 == matrix.length || f6 == matrix.length) {
			f1 = 999;
			f2 = 999;
			f3 = 999;
			f4 = 999;
			f5 = 999;
			f6 = 999;
		}		

		int[][] tabel = {
			{a1, b1, c1, d1, e1, f1},
			{a2, b2, c2, d2, e2, f2},
			{a3, b3, c3, d3, e3, f3},
			{a4, b4, c4, d4, e4, f4},
			{a5, b5, c5, d5, e5, f5},
			{a6, b6, c6, d6, e6, f6}
		};

		System.out.println("\nKandidatentabel:");
		System.out.println("  ----------------");
		System.out.println("  A  B  C  D  E  F");
		System.out.println("  ----------------");

		for(int j = 0; j < matrix[0].length; j++) {
			System.out.print(j + 1 + "|");
			for(int i = 0; i < matrix[0].length; i++)
				System.out.print(tabel[j][i] + "  ");

			System.out.println("");
		}
		return tabel;
	}



	/*
	 * Methode dat degene met het minste aantal stemmen bepaald en eruit haalt
	 * (klopt niet helemaal)
	 */
	static char verliezer(int[][] matrix) {
		char eruit = 0;
		int i = 0;
		int j = 0;		
		for(i = 0; i < matrix[0].length; i++) {
			do {
				if(matrix[i][0] < matrix[i][1] &&
				matrix[i][0] < matrix[i][2] &&
				matrix[i][0] < matrix[i][3] &&
				matrix[i][0] < matrix[i][4] &&
				matrix[i][0] < matrix[i][5]) {
					eruit = 'A';
					if(j > 0)
						j--;
				} else if(matrix[i][1] < matrix[i][0] &&
				matrix[i][1] < matrix[i][2] &&
				matrix[i][1] < matrix[i][3] &&
				matrix[i][1] < matrix[i][4] &&
				matrix[i][1] < matrix[i][5]) {
					eruit = 'B';
					if(j > 0)
						j--;
				} else if(matrix[i][2] < matrix[i][1] &&
				matrix[i][2] < matrix[i][0] &&
				matrix[i][2] < matrix[i][3] &&
				matrix[i][2] < matrix[i][4] &&
				matrix[i][2] < matrix[i][5]) {
					eruit = 'C';
					if(j > 0)
						j--;
				} else if(matrix[i][3] < matrix[i][1] &&
				matrix[i][3] < matrix[i][2] &&
				matrix[i][3] < matrix[i][0] &&
				matrix[i][3] < matrix[i][4] &&
				matrix[i][3] < matrix[i][5]) {
					eruit = 'D';
					if(j > 0)
						j--;
				} else if(matrix[i][4] < matrix[i][1] &&
				matrix[i][4] < matrix[i][2] &&
				matrix[i][4] < matrix[i][3] &&
				matrix[i][4] < matrix[i][0] &&
				matrix[i][4] < matrix[i][5]) {
					eruit = 'E';
					if(j > 0)
						j--;
				} else if(matrix[i][5] < matrix[i][1] &&
				matrix[i][5] < matrix[i][2] &&
				matrix[i][5] < matrix[i][3] &&
				matrix[i][5] < matrix[i][4] &&
				matrix[i][5] < matrix[i][0]) {
					eruit = 'F';
					if(j > 0)
						j--;
				} else if(eruit == 0) {
					j++;
				}
			} while(j > 0);
		}

		System.out.println("\nKandidaat " + eruit + " verliest\n");	

		return eruit;
	}



	/*
	 * Methode voor het maken van een nieuwe matrix en print deze uit
	 * Methode om de winnaar te bepalen
	 */
	static char[][] nieuwMatrix(char[][] matrix) {
		int[][] tabel = kandidatentabel(matrix);
		char eruit = verliezer(tabel);

		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length && j+1 < 6; j++) {
				if(matrix[i][j] == eruit) {
					matrix[i][j] = matrix[i][j+1];
					matrix[i][j+1] = eruit;
				}
			}
		}

		char[][] nieuw = new char[matrix.length][matrix[0].length - 1];

		for(int i = 0; i < matrix.length; i++)
			for(int j = 0; j < nieuw[0].length; j++)
				nieuw[i][j] = matrix[i][j];

		for(int x = 0; x < nieuw.length; x++)
			System.out.println(nieuw[x]);

		/*
		 * De code dat de winnaar bepaald
		 */
		int winnaar = 0;

		for(int x = 0; x < nieuw.length && x+1 < nieuw.length; x++) {
			if(nieuw[x][0] == nieuw[x+1][0])
				winnaar++;
		}
		
		if(winnaar == nieuw.length - 1) {
			System.out.println("\nwinnaar is kandidaat: " + eruit);
		}

		return matrix;
	}
}
