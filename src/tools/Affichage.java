package tools;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Affichage {

	/**
	 * 
	 */
	private Affichage() {

	}

	/**
	 * 
	 * @param donnees
	 */
	public static void afficheDonnees(int[][] donnees) {
		for (int i = 0; i < donnees.length; i++) {
			for (int j = 0; j < donnees[0].length; j++) {
				System.out.print(donnees[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * 
	 * @param tab
	 */
	public static void afficheClassement(int[] tab) {
		System.out.println("______");
		System.out.println("Voici la liste trié des candidats :");
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < tab.length; i++) {
			map.put(i + 1, tab[i]);
		}
		map.put(10, 5);
		map.put(11, 6000);

		map.put(12, 6458); //TODO : finir ce bug !!!!
		
		Map<Integer, Integer> sortedMap = Tri.sortMapByValue(map);
		int c = 1;
		int pos = 1;
		int lastValue = -1;
		for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
			System.out.println(lastValue);
			if(lastValue != entry.getValue()) {
				pos = c;
				lastValue = entry.getValue();
				
			}else {
				System.out.println("elese");
			}
			System.out.println(pos + "° Candidat " + (entry.getKey()) + " : " + entry.getValue());
			c++;
		}
	}

	/**
	 * 
	 * @param tab
	 */
	public static void afficheGagnant(int[] tab) {
		System.out.println("______");
		System.out.println("Voici le ou les gagnants :");
		Arrays.sort(tab);
		int c = tab.length - 1;
		int value = tab[c]; // on prend le dernier qui a donc le plus grand score

		while (c > 0 && tab[c] == value) {
			System.out.println("\t candidat " + (c + 1) + " : " + tab[c]);
			c--;
		}
	}

}
