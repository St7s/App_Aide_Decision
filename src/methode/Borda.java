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
		int nbRow = donnees.length;
		int nbCol = donnees[0].length;

		int[] resultBorda = new int[nbRow];

		// les points ajoutés sont par exemple pour n candidat, le 1er aura n pts, le 2eme n-1
		for (int i = 0; i < nbRow; i++) {
			for (int j = 0; j < nbCol; j++) {
				resultBorda[donnees[i][j] - 1] += nbRow - i; // on ajoute les points
			}
		}

		return resultBorda;
	}

}
