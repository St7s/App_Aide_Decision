package methode;



public class Vote2Tours {

	public static int[] calculVote2Tours(int[][] donnees) {



		int nbVotant = donnees[0].length;
		
		int[] resultVote2Tours = new int[2];

		int[] resultVote1Tour = Vote1Tour.calculVote1Tour(donnees);// recuperation classement de vote 1ere tour

		int[] classementVote1tour = Vote1Tour.giveMeRank(resultVote1Tour);
		
		// on teste si le meilleur candidat à la majourité absolu (+50) si oui il est ganagnt si non on passe au 2eme

		// tour

		if (resultVote1Tour[classementVote1tour[0]-1] > (nbVotant / 2)) {
			System.out.println("majorité au 1ere tour");
			return resultVote1Tour;

		} 
		else {
			System.out.println("passage au 2eme tour");

			// on test la 1ere valeur de la premiere colonne si la valeur egale à l'un de nos gangants du 1 tour,

			// on ajoute 1 au candidat concerne, et on passe à la 2eme colonne

			// si non on passe a la deuxieme ligne de la meme colonne et on retest a nouveau jusqu'a trouver un vote

			// pour

			// l'un des candidats



			for (int j = 0; j < nbVotant; j++) {

				int i = 0;
				boolean condition = true;
				
				// si le candidat est dans la premiére ligne ( premier choix des votants)
				if(donnees[i][j] == classementVote1tour[0] || donnees[i][j] == classementVote1tour[1]) {
					if(donnees[i][j] == classementVote1tour[0]) 
						
							resultVote2Tours[0] += 1;
					else 
						 	resultVote2Tours[1] += 1;
	
				}
				
				// si nn vérifier le deuxieme choix des votants et ainsi de suite.... .
				else {
						while ((donnees[i][j] != classementVote1tour[0] || donnees[i][j] != classementVote1tour[1])

							&& condition) { 
							
							i++;
							if (donnees[i][j] == classementVote1tour[0]) {

								resultVote2Tours[0] += 1;
								condition = false;
								}

							if (donnees[i][j] == classementVote1tour[1]) {

								resultVote2Tours[1] += 1;
								condition = false;
							}
					}
				}
			
			}
		// mise a jour du tableau de classement
		resultVote1Tour[classementVote1tour[0]-1]=resultVote2Tours[0];
 		resultVote1Tour[classementVote1tour[1]-1]=resultVote2Tours[1];
        
		return resultVote1Tour;

		}


 				
 		

	}

}
