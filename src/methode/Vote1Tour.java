package methode;

import java.util.Map;

import tools.Tri;

public class Vote1Tour {

	private Vote1Tour() {
	}

	public static int[] calculVote1Tour(int[][] donnees) {
		int nbCandidat = donnees.length;
		int nbVotant = donnees[0].length;
		int[] resultVote1Tour = new int[nbCandidat];
		resultVote1Tour[0] = 0;

		// on prend en charge que la 1ere ligne (les premiers choix des votants)
		// on lis la valeur de la premiere colonne et on rajoute 1 a la colonne corespondant au candidat dans le tableau
		// resultVote1Tour
		// puis on passe à la deuxieme colonne et ainsi de suite... .
		for (int j = 0; j < nbVotant; j++) {
			resultVote1Tour[donnees[0][j] - 1] += 1;
		}

		return resultVote1Tour;
	}

	/**
	 * methode permettant de classer les candidats dans un tableau selon vote 1 tour
	 * 
	 * @param tab
	 * @return
	 */
	public static int[] giveMeRank(int[] tab) {
		Map<Integer, Integer> map = Tri.toHashMap(tab);

		Map<Integer, Integer> hmap = Tri.sortByValues(map);

		int res[] = new int[tab.length];
		int c = 0;
		for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
			res[c] = entry.getKey();
			c++;
		}
		return res;
	}

}
