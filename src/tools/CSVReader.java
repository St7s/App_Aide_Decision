package tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class CSVReader {

	public static int[][] giveMeTab(String filePath, String separator) {

		BufferedReader br = null;
		String line = "";

		int x = -1;
		int y = 0;

		// int[][] result = new int[] {};

		try {
			br = new BufferedReader(new FileReader(filePath));
			while ((line = br.readLine()) != null) {
				if (y == -1)
					y = line.split(separator).length;
				x++;
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

		//TODO ADRIEN : WTF
		System.out.println(x + "_" + y);
		int[][] result = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}} ;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				result[i][j] = 0;
			}
			
		}
		
		Affichage.afficheDonnees(result);
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