//
// Created by Quentin Nouvel on 28/02/2018.
//

#include "generate_transactions.h"

char **generateRandomTransactionsList(int *nb){
<<<<<<< HEAD
	srand((unsigned int) time(NULL));
	char chaine[] = "Source-Destination:";
	int taille = rand()%NB_MAX_TRANSACTION; // NOLINT
	char** transactions = malloc(taille*sizeof(char));
=======
	char a;

	srand((unsigned int) time(NULL));
	char chaine[] = "Source-Destination:";
	int taille = (rand()%NB_MAX_TRANSACTION)+1; // NOLINT
	char** transactions = malloc(taille*sizeof(char*));
>>>>>>> master
	for (int i = 0; i < taille; ++i) {
		transactions[i] = malloc(TRANSACTION_SIZE*sizeof(char));
		for (int j = 0; j < 20; ++j) {
			transactions[i][j] = chaine[j];
		}
<<<<<<< HEAD
		transactions[i][20] = (char) (rand() % 10);// NOLINT
		transactions[i][21] = (char) (rand() % 10);// NOLINT
=======
		/* complètement contre intuitif, Quentin devrait aimer : d'abord on choisit un nombre entre 1 et 9 et ensuite entre 1 et 10
		 * si ce nombre vaut 10, alors on rajoute rien.
		 * en gros si on génère 3 et 10 ça donne :   Source-Destination:3
		 * et 2 et 5 donnent :						 Source-Destination:25
		 */
		transactions[i][19] = (char) ((char) (rand() % 9) + '1');// NOLINT
		transactions[i][20] = (char) ((a =(char) (rand() % 11)) == 10 ? 0 : a + '0');// NOLINT
>>>>>>> master
		transactions[i][21] = 0;
	}
	*nb = taille;
	return transactions;
}
<<<<<<< HEAD
=======

void freeTransac(char** t, int nb){
	for(int i = 0; i < nb; ++i){
		free(t[i]);
	}
	free(t);
}
>>>>>>> master
