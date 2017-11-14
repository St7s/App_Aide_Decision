package tools;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

	/**
	 * 
	 */
	private CSVReader() {

	}

	/**
	 * 
	 * @param filePath
	 * @param separator
	 * @return
	 */
	public static int[][] giveMeTab(String filePath, String separator) {

		BufferedReader br = null;
		String line = "";

		int nbCol = -1;
		int nbLin = 0;

		// on compte le nombre de ligne et de colonne
		try {
			br = new BufferedReader(new FileReader(filePath));
			while ((line = br.readLine()) != null) {
				if (nbCol == -1)
					nbCol = line.split(separator).length;
				nbLin++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		int[][] result = new int[nbLin][nbCol];

		int numeroLigne = 0;
		try {
			br = new BufferedReader(new FileReader(filePath));
			while ((line = br.readLine()) != null) {

				String[] lines = line.split(separator);

				for (int i = 0; i < lines.length; i++) {
					result[numeroLigne][i] = Integer.valueOf(lines[i]);
				}
				numeroLigne++;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
}