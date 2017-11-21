package methode;
//TODO : 4_1

public class Vote2Tours {
@SuppressWarnings({ "null", "unused" })

public static int[] calculVote2Tours(int[][] donnees){
		
		int nbCandidat = donnees.length;
		int nbVotant = donnees[0].length;
		int[] resultVote1Tour = new int[nbCandidat];
		int[]  resultVote2Tours= null;
		
		Vote1Tour voteT1 = null;
		
		resultVote1Tour=voteT1.calculVote1Tour(donnees);
		

				for (int j= 0; j< nbVotant;j++){
					int i=0;
					while (i<nbCandidat) {
						if ( donnees [i][j] == resultVote1Tour[0] || donnees [i][j] == resultVote1Tour[1] ){
							if(donnees [i][j] == resultVote1Tour[0])
							    resultVote2Tours[0]+=1;
						   else resultVote2Tours[1]+=1;
						}
						else  i++;
					}
				}
			
		return resultVote2Tours;
	}


public int gangantVote2Tour(int[] resultVote2Tour) {
	
	return 1;
}

}
