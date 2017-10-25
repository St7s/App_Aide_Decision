package test.debug;

import methode.Borda;
import tools.Affichage;

public class TestBorda {

	public static void main(String[] args) {
		int[][] donnees = { { 3, 3, 3, 1 }, { 2, 2, 1, 3 }, { 1, 1, 2, 2 } };

		int nbCandidat = donnees.length;
		int nbVotant = donnees[0].length;

		Affichage.afficheDonnees(donnees);
		
		int[] res = Borda.calculBorda(donnees);
		
		Affichage.afficheResultatSimpleTab(res);

		

	}

}
