/*
 * Naam:		Mike Trieu
 * Studentennummer:	10105093 / 6366295
 * Studie:		Informatica
 *
 * Programma functie:
 * - Dit programma maakt verzameling met random gehele getallen
 * - Op de verzamelingen kunnen verzamelingoperaties toegepast worden
 * - De data in de verzamelingen bestaan uit gehele getallen tussen de 1 en 100
 * - Elementen mogen niet meerdere keren voorkomen in een verzameling
 * - De verzamelingoperaties dat dit programma kan:
 *   - deelverzamelingVan
 *   - doorsnede
 *   - vereniging
 *   - complement
 *
 * - Gebruik: java Opgave7
 */

import java.util.*;
import java.io.*;

public class Opgave7 {
	public static void main(String[] args) throws IOException {
		Verzameling A = new Verzameling(20, 3);
		System.out.println("Verzameling A:\n" + A + "\n");
		Verzameling B = new Verzameling(20, 4);
		System.out.println("Verzameling B:\n" + B + "\n");

		System.out.println("A deelverzamling van B?: " + A.deelverzamelingVan(B) + "\n");

		Verzameling C = A.doorsnede(B);
		System.out.println("Doorsnede van A en B:\n" + C + "\n");

		Verzameling D = A.vereniging(B);
		System.out.println("Vereniging van A en B:\n" + D + "\n");

		Verzameling E = A.complement();
		System.out.println("Complement van A:\n" + E + "\n");

		Verzameling F = A.vereniging(B).complement();
		System.out.println("(A vereniging B)^c:\n" + F + "\n");

		Verzameling G = A.complement().doorsnede(B.complement());
		System.out.println("A^c doorsnede B^c:\n" + G + "\n");

		System.out.print("De eerste wet van De Morgan is ");
		System.out.println((F.deelverzamelingVan(G) && G.deelverzamelingVan(F)));
	}
}

/*
 * Klasse Verzameling:
 * In deze klasse wordt met een randomgenerator een verzameling met random nummers gemaakt
 * Daarnaast worden in deze klasse doorsnede, verenigingen, complementen van verzamelingen uitgevoerd
 */
class Verzameling {
	private int[] elementen, randomArray, temporaryArray, verenigingArray, doorsnedeArray,
	complementArray, universum;

	private int aantal, k;

	Verzameling(int aantal, int seed) {
		elementen = new int[aantal];
		randomArray = new int[100];

		Random randomGenerator = new Random(seed);

		for(int i = 0; i < 100; i++)
			randomArray[i] = i + 1;

		for(int i = 0; i < aantal; i++) {
			int random = randomGenerator.nextInt(100);

			if(randomArray[random] == 0) {
				i--;
			} else {
				elementen[i] = randomArray[random];
				randomArray[random] = 0;
			}
		}
	}


	Verzameling(int[] elementen) {
		this.elementen = elementen;
	}


	/*
	 * Functie deelverzamelingVan:
	 * Deze functie kijkt of de ene verzameling een deelverzameling is van
	 * een andere verzameling
	 */
	boolean deelverzamelingVan(Verzameling V) {
		boolean deelverzameling = false;

		for(int i = 0; i < elementen.length; i++) {
			for(int j = 0; j < V.elementen.length; j++) {
				if(elementen[i] == V.elementen[j]) {
					deelverzameling = true;
					break;
				} else {
					deelverzameling = false;
				}
			}
			if(!deelverzameling){
				return false;
			}
		}
		return deelverzameling;
	}


	/*
	 * Functie doorsnede:
	 * Deze functie geeft de doorsnede van twee verzamelingen
	 */
	Verzameling doorsnede(Verzameling V) {
		for(int i = 0; i < elementen.length; i++)
			for(int j = 0; j < elementen.length; j++)
				if(elementen[i] == V.elementen[j])
					aantal++;

		doorsnedeArray = new int[aantal];
		
		for(int i = 0; i < elementen.length; i++) {
			for(int j = 0; j < elementen.length; j++) {
				if(elementen[i] == V.elementen[j]) {
					doorsnedeArray[k] = elementen[i];
					k++;
				}
			}
		}
		return new Verzameling(doorsnedeArray);
	}


	/*
	 * Functie vereniging:
	 * Deze functie verenigt twee arrays.
	 * Elementen mogen maar een keer voorkomen in de verenigde verzameling
	 */
	Verzameling vereniging(Verzameling V) {
		int dubbel = 0, l = 0;

		temporaryArray = new int[V.elementen.length];

		for(int i = 0; i < elementen.length; i++)
			for(int j = 0; j < elementen.length; j++)
				if(elementen[i] == V.elementen[j])
					dubbel++;

		int[] elementenDubbel = new int[dubbel];

		for(int i = 0; i < elementen.length; i++) {
			for(int j = 0; j < elementen.length; j++) {
				if(elementen[i] == V.elementen[j]) {
					elementenDubbel[l] = elementen[i];
					l++;
				}
			}
		}

		for(int i = 0; i < temporaryArray.length; i++)
			temporaryArray[i] = V.elementen[i];
		
		for(int k = 0; k < elementenDubbel.length; k++)
			for(int i = 0; i < temporaryArray.length; i++)
				if(elementenDubbel[k] == temporaryArray[i])
					temporaryArray[i] = 0;

		verenigingArray = new int[elementen.length + V.elementen.length - elementenDubbel.length];

		for(int i = 0; i < elementen.length; i++)
			verenigingArray[i] = elementen[i];
		
		for(int i = elementen.length, j = 0; i < verenigingArray.length; i++, j++) {
			if(temporaryArray[j] == 0)
				i--;
			else
				verenigingArray[i] = V.elementen[j];
		}
		return new Verzameling(verenigingArray);
	}


	/*
	 * Functie complement:
	 * Deze functie geeft het complement weer van een verzameling
	 */
	Verzameling complement() {
		universum = new int[100];
		complementArray = new int[universum.length - elementen.length];
		
		for(int i = 0; i < 100; i++)
			universum[i] = i + 1;
		
		for(int i = 0; i < 100; i++)
			for(int j = 0; j < elementen.length; j++)
				if(universum[i] == elementen[j])
					universum[i] = 0;
		
		for(int i = 0, j = 0; i < complementArray.length; i++, j++) {
			if(universum[j] == 0)
				i--;
			else
				complementArray[i] = universum [j];
		}
		return new Verzameling(complementArray);
	}


	/*
	 * Functie toString:
	 * Deze functie zet arrays om naar strings
	 */
	public String toString() {
		String s = "";

		for(int i = 0; i < elementen.length; i++)
			s = s + elementen[i] + " ";

		return s;
	}
}