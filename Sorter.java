package oppgave1;

public class Sorter {

	//A) 
	//	L�sning fra forelesning
	public static <T extends Comparable<? super T>> void sorteringVedInssetting(Integer[] tab, int n) {
		sorteringVedInssetting(tab, 0, n - 1);
	}
	
	public static <T extends Comparable<? super T>> void sorteringVedInssetting(T[] a, int start, int slutt) {
		for (int i = start + 1; i <= slutt; i++) {
			T temp = a[i];
			int j = i - 1;
			boolean ferdig = false;
			while (!ferdig && j >= 0) {
				if (temp.compareTo(a[j]) < 0) {
					a[j + 1] = a[j];
					j--;
				} else {
					ferdig = true;
				}
			}
			a[j+1] = temp;
		}
	}

	// A) 
	// V�res endrede versjon med litt flere sted, men tatt vekk else statementen s�
	// den ikke returnere
	// Vi observerer at n�r vi tar vekk statementsene og gj�r koden saktere s� er
	// den fortsatt ikke raskere,
	// Dette pga stegene vi gj�r med tabellen ved index - 1 og setter de til
	// forskjellige verdier.
	public static <T extends Comparable<? super T>> void sorteringVedInssetting(Integer[] tab, int n) {
		sorteringVedInssetting(tab, 0, n - 1);
	}

	public static <T extends Comparable<? super T>> void sorteringVedInssetting(T[] a, int start, int slutt) {
		for (int i = 1; i < a.length; i++) {
			int index = i;
			while (index > 0 && a[index - 1].compareTo(a[index]) > 0) {
				T temp = a[index];
				a[index] = a[index - 1];
				a[index - 1] = temp;
				index--;
			}

		}

	}

//	B)
// Bruker 14.4 sekunder p� � sjekke gjennom 1 million tilfeldige tall.
// L�sningen fra forelesningen bruker 15.8 sekunder p� � lete gjennom samme. Alt dette avhenger ogs� av datakraft
// Men vi ser at det er raskere ogs� sortere to elementer samtidig kontra kun en. Noe som gir mening. 
	public static <T extends Comparable<? super T>> void sorteringVedInssetting(Integer[] tab, int n) {
		sorteringVedInssetting(tab, 0, n - 1);
	}
	
	public static <T extends Comparable<? super T>> void sorteringVedInssetting(T[] a, int start, int slutt) {
		for (int i = start + 1; i < slutt; i++) {
			T min = a[i];
			T max = a[i + 1];
			
			if(min.compareTo(max) > 0) {
				min = a[i +1];
				max = a[i];
			}
			
			int j = i - 1;
			boolean ferdig = false;
			while (!ferdig && j >= 0) {
				if (max.compareTo(a[j]) < 0) {
					a[j + 1] = a[j]; 
					j--;
				} else {
					ferdig = true;
				}
			}
			a[j+1] = max;
		}
	}
}