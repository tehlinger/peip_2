import static java.lang.System.out;

class Permutations {
	/*
	 *  Antecedent : aucun.
	 *  Role : renvoie le tableau avec x en plus a la fin
	 *  Renvoie : le tableau avec x au bout
	 *  @param arr le tableau
	 *  @param x l'entier à ajouter
	 */
	public static int[] ConcatToArray(int[] arr,int x){
		int n = arr.length+1;
		int[] res = new int[n];
		int j = 0;
		for (int i : arr){
			res[j] = i;
			j++;
		}
		res[n-1] = x;
		return res;
	}

	/*
	 *  Antecedent : aucun.
	 *  Role : affiche un tableau
	 *  Renvoie : rien.
	 *  @param arr le tableau
	 */
	public static void PrintArray(int[] arr){
		for(int i : arr){
			out.print(i+" ");
		}
		out.println();
	}

	/*
	 *  Role : Renvoie le tableau SANS l'element en parametre
	 *  Antecedent : L'élément doit être dans le tableau, en un seul
	 *  exemplaire.
	 *  Renvoie : Renvoie le tableau SANS l'element en parametre
	 *  @param element, l'élément à retirer du tableau
	 *  @param arr, le tableau
	 */
	public static int[] ArrayWithoutElement(int element, int[] arr){
		int size = arr.length;
		int[] result = new int[size-1];
		int j = 0;
		for(int i : arr){
			if (i != element) {
				result[j] = i;
				j++;
			}
		}
		return result;
	}

	/*
	 *  Role : Fonction AUXILIAIRE. Affiche toutes les permutations
	 *  d'une liste. Le premier appel s'effectue avec begin étant un
	 *  tableau vide, et 'end' la liste à traiter.
	 *  Antecedent : Pas de doublon dans la liste.
	 *  @param begin : La liste de nombres à afficher quand end est vide
	 *  @param end : la liste des nombres qu'il reste à permuter
	 */
	private static void PrintPermsAux(int[] begin, int[] end){
		if (/*A REPLIR*/){
		//A REMPLIR
		}
		else{
		//A REMPLIR
			}
		}
	}

	/*
	 *  Role : affiche toutes les permutations de arr
	 *  Antecedent : pas de doublon dans arr
	 *  @param : la liste
	 */
	public static void PrintPerms(int[] arr){
		//A REMPLIR
	}

	public static void main(String args[]){
		out.println("Permutations de {1,2,3}. J'attends 6 lignes différentes :");
		out.println("=========================================================");
		int[] intArray = new int[]{1,2,3};
		PrintPerms(intArray);
	}
}
