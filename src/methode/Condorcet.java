package methode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelisation.Duel;

public class Condorcet {

	private List<Duel> listDuel;
	private int[][] donnees;

	/**
	 * 
	 */
	public Condorcet(int[][] donnees) {
		this.setListDuel(new ArrayList<Duel>());
		this.setDonnees(donnees);
	}

	/**
	 * 
	 * @param donnees
	 * @return
	 */
	public int[] calculCondorcet() {
		int nbRow = this.donnees.length;
		int nbCol = this.donnees[0].length;

		int[] result = new int[nbRow];

		int v1 = 0;
		int v2 = 0;
		for (int p1 = 0; p1 < nbRow - 1; p1++) { // premier element
			for (int p2 = p1 + 1; p2 < nbRow; p2++) { // deuxieme element
				for (int col = 0; col < nbCol; col++) {
					if (this.donnees[p1][col] > this.donnees[p2][col]) {
						v1++;
					} else if (this.donnees[p1][col] < this.donnees[p2][col]) {
						v2++;
					} // sinon rien
				}
				//System.out.println("(" + (p1 + 1) + " vs " + (p2 + 1) + ") [" + v1 + "-" + v2 + "]");
				if (v1 > v2) {
					this.getListDuel().add(new Duel(p1 + 1, p2 + 1));
				} else if (v1 < v2) {
					this.getListDuel().add(new Duel(p2 + 1, p1 + 1));
				} else { // sinon egalité
					System.out.println("egalité");
					Duel d = new Duel(p1 + 1, p2 + 1);
					d.setEgal(true);
					this.getListDuel().add(d);
				}
				v1 = 0;
				v2 = 0;
			}
		}
		
		System.out.println(this.getListDuel());
		Collections.sort(this.getListDuel(), Duel.COMPARATOR);		
		System.out.println(this.getListDuel());
		// TODO : faire méthode
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nbRow; i++) {
			map.put(i+1, 0);
		}

		return result; //useless ?
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
