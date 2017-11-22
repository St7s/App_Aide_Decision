package methode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import modelisation.Duel;

public class Condorcet {

	private List<Duel> listDuel;
	private int[][] donnees;
	private int[] nbWins;
	private int[] nbLoses;
	private int nbRow;
	private int nbCol;

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
		for (int p1 = 0; p1 < nbRow - 1; p1++) { // premier element
			for (int p2 = p1 + 1; p2 < nbRow; p2++) { // deuxieme element

				for (int col = 0; col < nbCol; col++) { // pour chaque colonne
					int search1 = -1;
					int search2 = -1;
					
					// on va chercher qui de p1 ou p2 est voté plus haut que l'autre
					for (int i = 0; i < nbRow; i++) {
						if (search1 != -1 && search2 != -1)
							break;// on arrete
						if (this.donnees[i][col] == p1 + 1) {
							search1 = i;
						} else if (this.donnees[i][col] == p2 + 1) {
							search2 = i;
						} // sinon on continu à chercher
					}

					// on incremente la valeur de celui qui est voté pour cette colonne
					if (search1 < search2) {
						v1++;
					} else if (search1 > search2) {
						v2++;
					} // sinon rien
				}

				//on ajoute dans notre liste de duels
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
				}
				v1 = 0;
				v2 = 0;
			}
		}

		// System.out.println(this.getListDuel());
		//Collections.sort(this.getListDuel(), Duel.COMPARATOR); // on trie
		// System.out.println(this.getListDuel());

		return nbWins;
	}
	
	
	public int[] calculCondorcetCopeland() {
		this.calculCondorcet(); // on calcule condorcet d'abord
		int[] result = new int[nbRow];
		for (int i = 0; i < result.length; i++) {
			result[i] = this.nbWins[i] - this.nbLoses[i]; // nbWins - nbLoses
		}
		return result; // on retourne le résultat
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
