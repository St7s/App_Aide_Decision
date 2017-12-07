package test.debug;


import methode.CondorcetCopeland;
import tools.Affichage;
import tools.CSVReader;

public class TestCondorcetCopeland {

	public static void main(String[] args) {

		int[][] donnees = CSVReader.giveMeTab("data/vote_8.csv", ",");

		Affichage.afficheDonnees(donnees);
		CondorcetCopeland condorcetCopeland = new CondorcetCopeland(donnees);

		int[] res = condorcetCopeland.calculCondorcetCopeland();

		Affichage.afficheClassement(res);

		Affichage.afficheGagnant(res);

	}

}
