package methode;

import java.util.Arrays;

public class Borda {

	public static int[] calculBorda(int[][] donnees) {
		int nbCandidat = donnees.length;
		int nbVotant = donnees[0].length;

		int[] resultBorda = new int[nbCandidat];

		for (int i = 0; i < nbCandidat; i++) {
			for (int j = 0; j < nbVotant; j++) {
				resultBorda[donnees[i][j] - 1] += nbCandidat - i;
			}
		}

		return resultBorda;
	}

}
