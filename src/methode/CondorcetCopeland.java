package methode;

public class CondorcetCopeland extends Condorcet {

	/**
	 * Même constructeur que Condorcet
	 * @param donnees
	 */
	public CondorcetCopeland(int[][] donnees) {
		super(donnees);
	}
	
	/**
	 * Méthode spécifique exectutant condorcet de copeland
	 * @return
	 */
	public int[] calculCondorcetCopeland() {
		this.calculCondorcet(); // on calcule condorcet d'abord pour avoir les résultats
		int[] result = new int[super.nbRow];
		for (int i = 0; i < result.length; i++) {
			result[i] = super.nbWins[i] - super.nbLoses[i]; // nbWins - nbLoses
		}
		return result; // on retourne le résultat
	}

}
