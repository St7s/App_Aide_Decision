package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import methode.Borda;
import tools.Affichage;
import tools.CSVReader;

public class Main {

	private static Scanner sc;
	private static final String PATH_DATA = "data";
	private static final String PATH_OUTPUT = "resultatOutput";
	private static final String DEFAULT_SEPARATOR_CSV = ",";

	public static String[] listerChoixFichier(File repertoire) {

		String[] listefichiers;
		int i;
		listefichiers = repertoire.list();

		System.out.print("0 - pour tous ");
		for (i = 0; i < listefichiers.length; i++) {
			listefichiers[i].replace(".java", "");
			System.out.print(" | " + (i + 1) + " - " + listefichiers[i]);
		}
		System.out.println();

		return listefichiers;
	}

	public static void ecrireFichier(int[] res, String filename)
			throws FileNotFoundException, UnsupportedEncodingException {

		StringBuilder textOutPut = new StringBuilder();
		textOutPut.append(Affichage.afficheClassement(res));

		textOutPut.append(Affichage.afficheGagnant(res));

		PrintWriter writer = new PrintWriter(PATH_OUTPUT + File.separator + filename, "UTF-8");
		writer.println(textOutPut);
		writer.close();
	}

	public static String createDir() {
		String pattern = "dd.MM.yyyy-HH-mm-ss";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Date date = new Date();

		String res = format.format(new Date());

		File dir = new File(PATH_OUTPUT + File.separator + res);

		dir.mkdir();

		return res;
	}

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

		String[] listFile = listerChoixFichier(new File(PATH_DATA));
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
			System.out.println("Quelle méthode voulez vous  exécuter ?");
			choiceMethod = sc.nextInt();
		}

		if (choiceMethod == 0)
			System.out.println("Vous avez choisi 'toutes les méthodes'");
		else
			System.out.println("Vous avez choisi : " + listMethod[choiceMethod - 1]);

		// Todo executer et ecrire dans fichier avec la date

		// On cr�er un dossier
		String pathDir = createDir();

		if (choiceFile == 0) {
			// all
		} else {
			// listFile[choiceFile - 1]
		}

		if (choiceMethod == 0) {
			// all
		} else {
			switch (listMethod[choiceMethod - 1]) {
			case "Borda.java":
				if (choiceFile == 0) {
					for (String file : listFile) {
						execBorda(file, pathDir);
					}
				} else
					execBorda(listFile[choiceFile - 1], pathDir);
				break;

			default:
				System.out.println("other");
				break;
			}
		}
	}

	private static void execBorda(String fileNameSource, String dirToOutOut)
			throws FileNotFoundException, UnsupportedEncodingException {

		int[][] donnees = CSVReader.giveMeTab(PATH_DATA + File.separator + fileNameSource, DEFAULT_SEPARATOR_CSV);

		int[] res = Borda.calculBorda(donnees);

		ecrireFichier(res, dirToOutOut + File.separator + "borda_" + fileNameSource + ".txt");
	}

}
