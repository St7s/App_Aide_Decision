package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import methode.Borda;
import methode.Condorcet;
import methode.CondorcetCopeland;
import methode.Vote1Tour;
import methode.Vote2Tours;
import methode.VoteAlternatif;
import tools.Affichage;
import tools.CSVReader;

public class Main {

	private static Scanner sc;
	private static final String PATH_DATA = "data";
	private static final String PATH_OUTPUT = "resultatOutput";
	private static final String DEFAULT_SEPARATOR_CSV = ",";

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

		// On créer un dossier
		String pathDir = createDir();

		if (choiceMethod == 0) {
			// on execute tous
			runBorda(choiceFile, listFile, pathDir);
			runCondorcet(choiceFile, listFile, pathDir);
			runCondorcetCopeland(choiceFile, listFile, pathDir);
			runVote1Tour(choiceFile, listFile, pathDir);
			runVote2Tours(choiceFile, listFile, pathDir);
			runVoteAlternatif(choiceFile, listFile, pathDir);
		} else {
			// on execute seulement celui qui est demandé
			switch (listMethod[choiceMethod - 1]) {
			case "Borda":
				runBorda(choiceFile, listFile, pathDir);
				break;
			case "Condorcet":
				runCondorcet(choiceFile, listFile, pathDir);
				break;
			case "CondorcetCopeland":
				runCondorcetCopeland(choiceFile, listFile, pathDir);
				break;
			case "Vote1Tour":
				runVote1Tour(choiceFile, listFile, pathDir);
				break;
			case "Vote2Tours":
				runVote2Tours(choiceFile, listFile, pathDir);
				break;
			case "VoteAlternatif":
				runVoteAlternatif(choiceFile, listFile, pathDir);
				break;

			default:
				System.out.println("TODO : " + listMethod[choiceMethod - 1]
						+ " pas encore implémenter ou pas encore disponible dans le main");
				break;
			}
		}

		System.out.println("\n########################################################################");
		System.out.println("Résultat disponible dans le dossier : " + PATH_OUTPUT + File.separator + pathDir);
		System.out.println("########################################################################");
	}

	/***********************
	 * méthodes qui executent une méthode avec 1 ou tous les fichiers
	 *****************************/

	public static void runBorda(int choiceFile, String[] listFile, String pathDir)
			throws FileNotFoundException, UnsupportedEncodingException {
		if (choiceFile == 0) {
			for (String file : listFile) {
				execBorda(file, pathDir);
			}
		} else
			execBorda(listFile[choiceFile - 1], pathDir);
	}

	public static void runCondorcet(int choiceFile, String[] listFile, String pathDir)
			throws FileNotFoundException, UnsupportedEncodingException {
		if (choiceFile == 0) {
			for (String file : listFile) {
				execCondorcet(file, pathDir);
			}
		} else
			execCondorcet(listFile[choiceFile - 1], pathDir);
	}

	public static void runCondorcetCopeland(int choiceFile, String[] listFile, String pathDir)
			throws FileNotFoundException, UnsupportedEncodingException {
		if (choiceFile == 0) {
			for (String file : listFile) {
				execCondorcetCopeland(file, pathDir);
			}
		} else
			execCondorcetCopeland(listFile[choiceFile - 1], pathDir);
	}

	public static void runVote1Tour(int choiceFile, String[] listFile, String pathDir)
			throws FileNotFoundException, UnsupportedEncodingException {
		if (choiceFile == 0) {
			for (String file : listFile) {
				execVote1Tour(file, pathDir);
			}
		} else
			execVote1Tour(listFile[choiceFile - 1], pathDir);
	}

	public static void runVote2Tours(int choiceFile, String[] listFile, String pathDir)
			throws FileNotFoundException, UnsupportedEncodingException {
		if (choiceFile == 0) {
			for (String file : listFile) {
				execVote2Tours(file, pathDir);
			}
		} else
			execVote2Tours(listFile[choiceFile - 1], pathDir);
	}

	public static void runVoteAlternatif(int choiceFile, String[] listFile, String pathDir)
			throws FileNotFoundException, UnsupportedEncodingException {
		if (choiceFile == 0) {
			for (String file : listFile) {
				execVoteAlternatif(file, pathDir);
			}
		} else
			execVoteAlternatif(listFile[choiceFile - 1], pathDir);
	}

	/***********************
	 * méthodes qui executent une méthode le fichier passé en parametre, et qui vient ensuite créer un fichier de sortie
	 *****************************/

	private static void execBorda(String fileNameSource, String dirToOutOut)
			throws FileNotFoundException, UnsupportedEncodingException {
		
		System.out.println("==================================");
		System.out.println("execBorda + :"+fileNameSource);
		System.out.println("==================================");

		int[][] donnees = CSVReader.giveMeTab(PATH_DATA + File.separator + fileNameSource, DEFAULT_SEPARATOR_CSV);

		int[] res = Borda.calculBorda(donnees);

		ecrireFichier(res, dirToOutOut + File.separator + "execBorda_" + fileNameSource + ".txt");
	}

	private static void execCondorcet(String fileNameSource, String dirToOutOut)
			throws FileNotFoundException, UnsupportedEncodingException {
		
		System.out.println("==================================");
		System.out.println("execCondorcet + :"+fileNameSource);
		System.out.println("==================================");

		int[][] donnees = CSVReader.giveMeTab(PATH_DATA + File.separator + fileNameSource, DEFAULT_SEPARATOR_CSV);

		Condorcet condorcet = new Condorcet(donnees);
		int[] res = condorcet.calculCondorcet();

		ecrireFichier(res, dirToOutOut + File.separator + "execCondorcet_" + fileNameSource + ".txt");
	}

	private static void execCondorcetCopeland(String fileNameSource, String dirToOutOut)
			throws FileNotFoundException, UnsupportedEncodingException {
		
		System.out.println("==================================");
		System.out.println("execCondorcetCopeland + :"+fileNameSource);
		System.out.println("==================================");
		
		int[][] donnees = CSVReader.giveMeTab(PATH_DATA + File.separator + fileNameSource, DEFAULT_SEPARATOR_CSV);

		CondorcetCopeland condorcetCopeland = new CondorcetCopeland(donnees);
		int[] res = condorcetCopeland.calculCondorcetCopeland();

		ecrireFichier(res, dirToOutOut + File.separator + "execCondorcetCopeland_" + fileNameSource + ".txt");
	}

	private static void execVote1Tour(String fileNameSource, String dirToOutOut)
			throws FileNotFoundException, UnsupportedEncodingException {
		
		System.out.println("==================================");
		System.out.println("execVote1Tour + :"+fileNameSource);
		System.out.println("==================================");
		
		int[][] donnees = CSVReader.giveMeTab(PATH_DATA + File.separator + fileNameSource, DEFAULT_SEPARATOR_CSV);
		
		int[] res = Vote1Tour.calculVote1Tour(donnees);

		ecrireFichier(res, dirToOutOut + File.separator + "execVote1Tour_" + fileNameSource + ".txt");
	}

	private static void execVote2Tours(String fileNameSource, String dirToOutOut)
			throws FileNotFoundException, UnsupportedEncodingException {
		
		System.out.println("==================================");
		System.out.println("execVote2Tours + :"+fileNameSource);
		System.out.println("==================================");
		
		int[][] donnees = CSVReader.giveMeTab(PATH_DATA + File.separator + fileNameSource, DEFAULT_SEPARATOR_CSV);

		int[] res = Vote2Tours.calculVote2Tours(donnees);

		ecrireFichier(res, dirToOutOut + File.separator + "execVote2Tours_" + fileNameSource + ".txt");

	}

	private static void execVoteAlternatif(String fileNameSource, String dirToOutOut)
			throws FileNotFoundException, UnsupportedEncodingException {
		
		System.out.println("==================================");
		System.out.println("execVoteAlternatif + :"+fileNameSource);
		System.out.println("==================================");

		int[][] donnees = CSVReader.giveMeTab(PATH_DATA + File.separator + fileNameSource, DEFAULT_SEPARATOR_CSV);

		int[] res = VoteAlternatif.calculVoteAlternatif(donnees);

		ecrireFichier(res, dirToOutOut + File.separator + "execVoteAlternatif_" + fileNameSource + ".txt");
	}

	/************************** HELPERS **********************************/

	/**
	 * liste le fichier du répetoire indiqué
	 * 
	 * @param repertoire
	 * @return
	 */
	public static String[] listerChoixFichier(File repertoire) {

		String[] listefichiers;
		int i;
		listefichiers = repertoire.list();

		System.out.print("0 - pour tous ");
		for (i = 0; i < listefichiers.length; i++) {
			listefichiers[i] = listefichiers[i].replace(".java", "");
			System.out.print(" | " + (i + 1) + " - " + listefichiers[i]);
		}
		System.out.println();

		return listefichiers;
	}

	/**
	 * Ecris dans un fichier les résultats
	 * 
	 * @param res
	 * @param filename
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public static void ecrireFichier(int[] res, String filename)
			throws FileNotFoundException, UnsupportedEncodingException {

		StringBuilder textOutPut = new StringBuilder();

		textOutPut.append(Affichage.afficheClassement(res));
		textOutPut.append(Affichage.afficheGagnant(res));

		PrintWriter writer = new PrintWriter(PATH_OUTPUT + File.separator + filename, "UTF-8");
		writer.println(textOutPut);
		writer.close();
	}

	/**
	 * Créer un répetoire avec la date du moment
	 * 
	 * @return
	 */
	public static String createDir() {
		String pattern = "dd.MM.yyyy-HH-mm-ss";
		SimpleDateFormat format = new SimpleDateFormat(pattern);

		String res = format.format(new Date());

		File dir = new File(PATH_OUTPUT + File.separator + res);

		dir.mkdir();

		return res;
	}

}
