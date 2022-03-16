package oppgave1;

public class Sorter {

	//A) 
	//	Løsning fra forelesning
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
	// Våres endrede versjon med litt flere sted, men tatt vekk else statementen så
	// den ikke returnere
	// Vi observerer at når vi tar vekk statementsene og gjør koden saktere så er
	// den fortsatt ikke raskere,
	// Dette pga stegene vi gjør med tabellen ved index - 1 og setter de til
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
// Bruker 14.4 sekunder på å sjekke gjennom 1 million tilfeldige tall.
// Løsningen fra forelesningen bruker 15.8 sekunder på å lete gjennom samme. Alt dette avhenger også av datakraft
// Men vi ser at det er raskere også sortere to elementer samtidig kontra kun en. Noe som gir mening. 
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