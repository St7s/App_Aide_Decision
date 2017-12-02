package test.debug;

import methode.Vote1Tour;
import tools.Affichage;
import tools.CSVReader;

public class TestVoteUnTour {

	public static void main(String[] args) {

		int[][] donnees = CSVReader.giveMeTab("data/vote_1.csv", ",");
		
		Affichage.afficheDonnees(donnees);

		int[] res = Vote1Tour.calculVote1Tour(donnees);

		Affichage.afficheClassement(res);

		Affichage.afficheGagnant(res);
		
	}
}
