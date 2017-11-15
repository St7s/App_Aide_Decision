package test.debug;

import methode.Condorcet;
import tools.Affichage;
import tools.CSVReader;

public class TestCondorcet {

	public static void main(String[] args) {

		int[][] donnees = CSVReader.giveMeTab("data/vote_4.csv", ",");

		Affichage.afficheDonnees(donnees);
		Condorcet condorcet = new Condorcet(donnees);

		condorcet.calculCondorcet();

		System.out.println(condorcet.getListDuel());

	}

}
