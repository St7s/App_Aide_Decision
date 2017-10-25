package test.debug;

import methode.Borda;

public class TestBorda {

	public static void main(String[] args) {
		int[][] tabCSV = { { 3, 3, 3, 1 }, { 2, 2, 1, 3 }, { 1, 1, 2, 2 } };

		int nbCandidat = tabCSV.length;
		int nbVotant = tabCSV[0].length;

		int[] res = Borda.calculBorda(tabCSV);

		for (int i = 0; i < nbCandidat; i++) {
			for (int j = 0; j < nbVotant; j++) {
				System.out.print(tabCSV[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("______");
		for (int i = 0; i < nbCandidat; i++) {
			System.out.println(res[i]);
		}
	}

}
