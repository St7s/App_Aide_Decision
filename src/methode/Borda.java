package methode;

public class Borda {
	
	/**
	 * 
	 */
	private Borda() {
	}

	/**
	 * 
	 * @param donnees
	 * @return
	 */
	public static int[] calculBorda(int[][] donnees) {
		int nbCandidat = donnees.length;
		int nbVotant = donnees[0].length;

		int[] resultBorda = new int[nbCandidat];

		// les points ajoutés sont par exemple pour n candidat, le 1er aura n pts, le 2eme n-1
		for (int i = 0; i < nbCandidat; i++) {
			for (int j = 0; j < nbVotant; j++) {
				resultBorda[donnees[i][j] - 1] += nbCandidat - i; // on ajoute les points
			}
		}

		return resultBorda;
	}

}
