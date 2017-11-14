package test.debug;

import methode.Borda;
import methode.Condorcet;
import tools.Affichage;
import tools.CSVReader;

public class TestCondorcet {

	public static void main(String[] args) {

		int[][] donnees = CSVReader.giveMeTab("data/vote_3.csv", ",");
		// int[][] donnees = { { 3, 3, 3, 1 }, { 2, 2, 1, 3 }, { 1, 1, 2, 2 } };

		Affichage.afficheDonnees(donnees);
		Condorcet condorcet = new Condorcet(donnees);

		condorcet.calculCondorcet();
		
		System.out.println(condorcet.getListDuel());
		
		

		
	}

}
