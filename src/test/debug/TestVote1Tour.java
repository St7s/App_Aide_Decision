package test.debug;

import java.util.Arrays;

import methode.Vote1Tour;
import tools.Affichage;
import tools.CSVReader;

public class TestVote1Tour {
	
	public static void main(String[] args) {

		int[][] donnees = CSVReader.giveMeTab("data/vote_1.csv", ",");
		
		
		Affichage.afficheDonnees(donnees);

		int[] res = Vote1Tour.calculVote1Tour(donnees);

		Affichage.afficheClassement(res);

		Affichage.afficheGagnant(res);
		
		int[] tabTest = Vote1Tour.giveMeRank(res);
		for (int i = 0; i < tabTest.length; i++) {
			System.out.println(tabTest[i]);
		}
	}

}
