package test.debug;

import methode.Condorcet;
import tools.Affichage;
import tools.CSVReader;

public class TestCondorcet {

	public static void main(String[] args) {

		int[][] donnees = CSVReader.giveMeTab("data/vote_4.csv", ",");

		Affichage.afficheDonnees(donnees);
		Condorcet condorcet = new Condorcet(donnees);

		int[] res = condorcet.calculCondorcet();
		
		Affichage.afficheClassement(res);
		Affichage.afficheGagnant(res);
		
		//[1 > 2, 3 > 1, 3 > 2, 3 > 4, 4 > 1, 4 > 2, 4 > 5, 5 > 1, 5 > 2, 5 > 3]
		//need 3 1 premier

	}

}
