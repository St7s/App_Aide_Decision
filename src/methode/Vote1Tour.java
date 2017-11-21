package methode;
// TODO : 4_1

import java.util.Map;

import tools.Tri;

public class Vote1Tour {

	public static int[] calculVote1Tour(int[][] donnees) {

		int nbCandidat = donnees.length;
		int nbVotant = donnees[0].length;
		int[] resultVote1Tour = new int[nbCandidat];
		resultVote1Tour[0] = 0;
		System.out.println(nbVotant + "_" + nbCandidat);
		for (int j = 0; j < nbVotant; j++) {
			System.out.println("for" + j + "_" + donnees[0][j]);
			resultVote1Tour[donnees[0][j] - 1] += 1;
		}

		return resultVote1Tour;
	}

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
