package methode;

import java.util.ArrayList;
import java.util.List;

import modelisation.Duel;

public class Condorcet {

	private List<Duel> listDuel;
	private int[][] donnees;
	protected int[] nbWins;
	protected int[] nbLoses;
	protected int nbRow;
	protected int nbCol;

	/**
	 * 
	 */
	public Condorcet(int[][] donnees) {
		this.setListDuel(new ArrayList<Duel>());
		this.setDonnees(donnees);
		this.nbLoses = new int[donnees.length];
		this.nbWins = new int[donnees.length];
		this.nbRow = this.donnees.length;
		this.nbCol = this.donnees[0].length;
	}

	/**
	 * 
	 * @param donnees
	 * @return
	 */
	public int[] calculCondorcet() {

		int v1 = 0;
		int v2 = 0;
		for (int p1 = 0; p1 < nbRow - 1; p1++) { // premier candidat
			for (int p2 = p1 + 1; p2 < nbRow; p2++) { // deuxieme candidat

				for (int col = 0; col < nbCol; col++) { // pour chaque colonne
					int search1 = -1;
					int search2 = -1;

					// on va chercher qui de p1 ou p2 est vot� plus haut que l'autre
					for (int i = 0; i < nbRow; i++) {
						if (search1 != -1 && search2 != -1)
							break;// on arrete
						if (this.donnees[i][col] == p1 + 1) {
							search1 = i;
						} else if (this.donnees[i][col] == p2 + 1) {
							search2 = i;
						} // sinon on continu � chercher
					}

					// on incremente la valeur de celui qui est vot� pour cette colonne
					if (search1 < search2) {
						v1++;
					} else if (search1 > search2) {
						v2++;
					} // sinon rien
				}

				// on ajoute dans notre liste de duels
				if (v1 > v2) {
					this.getListDuel().add(new Duel(p1 + 1, p2 + 1, false));
					this.nbLoses[p2]++;
					this.nbWins[p1]++;
				} else if (v1 < v2) {
					this.getListDuel().add(new Duel(p2 + 1, p1 + 1, false));
					this.nbLoses[p1]++;
					this.nbWins[p2]++;
				} else { // sinon egalité
					this.getListDuel().add(new Duel(p1 + 1, p2 + 1, true));
					System.out.println("égalité entre n°" + (p1 + 1) + " et n°" + (p2 + 1));
				}
				v1 = 0;
				v2 = 0;
			}
		}

		return nbWins;
	}

	/******************** GETTERS && SETTERS **********************/
	public List<Duel> getListDuel() {
		return listDuel;
	}

	public void setListDuel(List<Duel> listDuel) {
		this.listDuel = listDuel;
	}

	public int[][] getDonnees() {
		return donnees;
	}

	public void setDonnees(int[][] donnees) {
		this.donnees = donnees;
	}

}
