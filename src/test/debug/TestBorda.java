package test.debug;

import methode.Borda;
import tools.Affichage;
import tools.CSVReader;

public class TestBorda {

	public static void main(String[] args) {

		//vote_1 j'ai faux !!!! :/
		int[][] donnees = CSVReader.giveMeTab("data/vote_1.csv", ",");
		// int[][] donnees = { { 3, 3, 3, 1 }, { 2, 2, 1, 3 }, { 1, 1, 2, 2 } };

		Affichage.afficheDonnees(donnees);

		int[] res = Borda.calculBorda(donnees);

		Affichage.afficheClassement(res);

		Affichage.afficheGagnant(res);
	}

}
