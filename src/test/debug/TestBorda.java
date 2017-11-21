package test.debug;

import methode.Borda;
import tools.Affichage;
import tools.CSVReader;

public class TestBorda {

	public static void main(String[] args) {

		int[][] donnees = CSVReader.giveMeTab("data/vote_2.csv", ",");

		Affichage.afficheDonnees(donnees);

		int[] res = Borda.calculBorda(donnees);

		Affichage.afficheClassement(res);

		Affichage.afficheGagnant(res);
	}

}
