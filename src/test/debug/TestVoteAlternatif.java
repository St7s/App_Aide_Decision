package test.debug;

import methode.VoteAlternatif;
import tools.Affichage;
import tools.CSVReader;

public class TestVoteAlternatif {

	public static void main(String[] args) {

		int[][] donnees = CSVReader.giveMeTab("data/vote_8.csv", ",");

		Affichage.afficheDonnees(donnees);

		int[] res = VoteAlternatif.calculVoteAlternatif(donnees);

		Affichage.afficheClassement(res);

		Affichage.afficheGagnant(res);

	}

}
