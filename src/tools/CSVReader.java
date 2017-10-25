package tools;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class CSVReader {

	public static int[][] giveMeTab(String filePath, String separator) {

		BufferedReader br = null;
		String line = "";

		int nbCol = -1;
		int nbLin = 0;

		//on compte le nombre de ligne et de colonne
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

		int[][] result =  new int[nbLin][nbCol];
	
		int numeroLigne = 0;
		try {
			br = new BufferedReader(new FileReader(filePath));
			while ((line = br.readLine()) != null) {
				System.out.println("num=" + numeroLigne);
				String[] lines = line.split(separator);
				System.out.println(Arrays.asList(lines));
				System.out.println("line.length = " + lines.length + "ççç" + result[0].length);
				for (int i = 0; i < lines.length; i++) {
					System.out.println("i=" + i + "//" + result[numeroLigne]);
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