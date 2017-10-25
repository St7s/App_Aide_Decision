package test.debug;

import methode.Borda;
import tools.Affichage;
import tools.CSVReader;

public class TestBorda {

	public static void main(String[] args) {
		
		int[][] donnees = CSVReader.giveMeTab("data/vote_2.csv", ",");
		//int[][] donnees = { { 3, 3, 3, 1 }, { 2, 2, 1, 3 }, { 1, 1, 2, 2 } };

		Affichage.afficheDonnees(donnees);

		int[] res = Borda.calculBorda(donnees);

		Affichage.afficheResultatSimpleTab(res);

	}

}
