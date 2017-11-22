package test.debug;

import methode.Condorcet;
import tools.Affichage;
import tools.CSVReader;

public class TestCondorcet {

	public static void main(String[] args) {

		int[][] donnees = CSVReader.giveMeTab("data/vote_2.csv", ",");

		Affichage.afficheDonnees(donnees);
		Condorcet condorcet = new Condorcet(donnees);

		int[] res = condorcet.calculCondorcet();

		Affichage.afficheClassement(res);
		Affichage.afficheGagnant(res);

	}

}
