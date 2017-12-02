package test.debug;

import methode.Vote2Tours;
import tools.Affichage;
import tools.CSVReader;

public class TestVoteDeuxTours {
	public static void main(String[] args) {

		int[][] donnees = CSVReader.giveMeTab("data/vote_5.csv", ",");

		Affichage.afficheDonnees(donnees);

		int res = Vote2Tours.calculVote2Tours(donnees);

		System.out.println("Le candidat gagnant en vote à deux tours est : " + res);

	}
}
