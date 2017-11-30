package tools;

import java.util.Map;
import java.util.Map.Entry;

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
	public static String afficheClassement(int[] tab) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n______");
		sb.append("\nVoici la liste trié des candidats :");

		Map<Integer, Integer> map = Tri.toHashMap(tab);

		Map<Integer, Integer> hmap = Tri.sortByValues(map);
		int c = 1;
		int pos = 1;
		int lastValue = -1;
		for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
			if (lastValue != entry.getValue()) {
				pos = c;
				lastValue = entry.getValue();
			}
			sb.append("\n\t" + pos + "° Candidat n°" + (entry.getKey()) + " : " + entry.getValue());
			c++;
		}
		// on affiche
		System.out.println(sb.toString());
		// on retourne la chaine ecrite
		return sb.toString();
	}

	/**
	 * 
	 * @param tab
	 */
	public static String afficheGagnant(int[] tab) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n______");
		sb.append("\nVoici le ou les gagnants :");
		Map<Integer, Integer> map = Tri.toHashMap(tab);

		Map<Integer, Integer> hmap = Tri.sortByValues(map);

		Entry<Integer, Integer> entry2 = hmap.entrySet().iterator().next();
		int value = entry2.getValue(); // on prend le premier qui a donc le plus grand score

		// on cherche les ex-equo
		for (Entry<Integer, Integer> entry : hmap.entrySet()) {
			if (value == entry.getValue()) {
				sb.append("\nCandidat " + (entry.getKey()) + " : " + entry.getValue());
			} else {
				break;
			}
		}
		// on affiche
		System.out.println(sb.toString());
		// on retourne la chaine ecrite
		return sb.toString();
	}
}
