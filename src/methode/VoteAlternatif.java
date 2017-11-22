package methode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import tools.Tri;

public class VoteAlternatif {
	private VoteAlternatif() {
	}

	// TODO : elimine le dernier à chaque tours,
	// les voix sont reportée
	// on verifie que le premier à le nombre absolu

	public static int[] calculVoteAlternatif(int[][] donnees) {

		int nbCandidat = donnees.length;
		int nbVotant = donnees[0].length;
		int[] result = new int[nbCandidat];

		List<Integer> listElimine = new ArrayList<>();

		for (int x = 0; x < nbCandidat; x++) {
			for (int j = 0; j < nbCandidat; j++) {
				result[j] = 0;
			}

			for (int j = 0; j < nbVotant; j++) {
				int n = 0;

				while (n < nbCandidat && listElimine.contains(new Integer(donnees[n][j]))) {
					n++;
				}

				if (n < nbCandidat)
					result[donnees[n][j] - 1] += 1;
				// sinon on ajoute pas

			}

			int majAbs = nbVotant / 2 + 1;
			for (int i = 0; i < result.length; i++) {
				if (result[i] >= majAbs)
					break;
			}

			int min = nbVotant + 1;
			int elimine = -1;
			for (int i = 0; i < result.length; i++) {
				if (!listElimine.contains(i + 1)) {
					if (result[i] < min) {
						min = result[i];
						elimine = i;
					}
				}
			}

			listElimine.add(elimine + 1);
		}

		//ici on donne juste des pseudo points aux elements pour faire un classement
		for (int j = 0; j < result.length; j++) {
			result[j] = 100+listElimine.indexOf(j + 1);
		}
		return result;
	}

	public static int[] giveMeRank(int[] tab) {
		Map<Integer, Integer> map = Tri.toHashMap(tab);

		Map<Integer, Integer> hmap = Tri.sortByValues(map);

		int[] res = new int[tab.length];
		int c = 0;
		for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
			res[c] = entry.getKey();
			c++;
		}
		return res;
	}

}
