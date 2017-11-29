package test;

import java.io.File;
import java.util.Scanner;

public class Main {

	private static Scanner sc;

	public static String[] listerChoixFichier(File repertoire) {

		String[] listefichiers;
		int i;
		listefichiers = repertoire.list();

		System.out.print("0 - pour tous ");
		for (i = 0; i < listefichiers.length; i++) {
			System.out.print(" | " + (i + 1) + " - " + listefichiers[i]);
		}
		System.out.println();

		return listefichiers;
	}

	public static void main(String[] args) {
		String[] listFile = listerChoixFichier(new File("data"));
		int nbFile = listFile.length;

		sc = new Scanner(System.in);
		int choiceFile = -1;
		while (choiceFile == -1 || choiceFile > nbFile) {
			if (choiceFile > nbFile)
				System.out.println("Erreur, veuiller choisir un nombre compris entre 0 et " + nbFile + " pour : ");
			System.out.println("Quel fichier voulez vous ?");
			choiceFile = sc.nextInt();
		}

		if (choiceFile == 0)
			System.out.println("Vous avez choisi 'tous les fichiers'");
		else
			System.out.println("Vous avez choisi : " + listFile[choiceFile - 1]);

		System.out.println();
		String[] listMethod = listerChoixFichier(new File("src/methode"));
		int nbMethod = listMethod.length;

		int choiceMethod = -1;
		while (choiceMethod == -1 || choiceMethod > nbMethod) {
			if (choiceMethod > nbMethod)
				System.out.println("Erreur, veuiller choisir un nombre compris entre 0 et " + nbMethod + " pour : ");
			System.out.println("Quel méthode voulez vous éxecuter ?");
			choiceMethod = sc.nextInt();
		}

		if (choiceMethod == 0)
			System.out.println("Vous avez choisi 'toutes les méthodes'");
		else
			System.out.println("Vous avez choisi : " + listMethod[choiceMethod - 1]);

		// Todo executer et ecrire dans fichier avec la date

	}

}
