package methode;

import java.util.ArrayList;
import java.util.List;

public class VoteAlternatif {
	private VoteAlternatif() {
	}

	// TODO : symplifier code pour faire Coombs
	public static int[] calculVoteAlternatif(int[][] donnees) {

		int nbCandidat = donnees.length;
		int nbVotant = donnees[0].length;
		int[] result = new int[nbCandidat];

		int winWithAbs = -1;

		List<Integer> listElimine = new ArrayList<>();

		for (int x = 0; x < nbCandidat; x++) {
			for (int j = 0; j < nbCandidat; j++) {
				result[j] = 0; // on remet � 0 les scores
			}

			// on cherche pour chaque votant, quel candidat sera vot� en fonction des candidat deja elimin�
			for (int j = 0; j < nbVotant; j++) {
				int n = 0;
				while (n < nbCandidat && listElimine.contains(donnees[n][j])) {
					n++;
				}

				if (n < nbCandidat)
					result[donnees[n][j] - 1] += 1;
				// sinon on ajoute pas
			}

			// on cherche si un candidat gagne par l'absolu
			int majAbs = nbVotant / 2 + 1;
			for (int i = 0; i < result.length; i++) {
				if (result[i] >= majAbs) {
					winWithAbs = i;
					break;
				}
			}
			if (winWithAbs != -1)
				break;

			// on elimine celui qui a le plus petit score
			int min = nbVotant + 1;
			int elimine = -1;
			for (int i = 0; i < result.length; i++) {
				if (!listElimine.contains(i + 1) && result[i] < min) {
					min = result[i];
					elimine = i;
				}
			}
			listElimine.add(elimine + 1);
		}

		// ici on donne juste des pseudo points aux elements pour faire un classement
		for (int j = 0; j < result.length; j++) {
			result[j] = 100 - listElimine.indexOf(j + 1);
		}

		result[winWithAbs]++;

		return result;
	}

}
