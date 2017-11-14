package tools;

import java.util.Arrays;

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
	public static void afficheResultatSimpleTab(int[] tab) {
		System.out.println("______");
		System.out.println("Voici la liste trié des candidats :");
		Arrays.sort(tab);
		for (int i = tab.length - 1; i >= 0; i--) {
			System.out.println("Candidat " + (i + 1) + " : " + tab[i]);
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
