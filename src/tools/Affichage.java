package tools;

public class Affichage {

	public static void afficheDonnees(int[][] donnees) {
		for (int i = 0; i < donnees.length; i++) {
			for (int j = 0; j < donnees[0].length; j++) {
				System.out.print(donnees[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void afficheResultatSimpleTab(int[] tab) {
		System.out.println("______");
		for (int i = 0; i < tab.length; i++) {
			System.out.println("Candidat " + (i+1) + " : " + tab[i]);
		}
	}

}
