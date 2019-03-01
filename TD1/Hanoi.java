
class Hanoi {
	static void déplacer(int n, char a, char b) {
		System.out.println(
				"déplacez le disque " + n + " du socle " + a + " vers le socle " + b
				);
	}

	/*
	* Rôle : déplace les n disques du socle a vers le socle b
	* selon les règles d’Hanoï.
	*/
	static void hanoi(int n, char a, char b, char c) {
		if (n > 0) {
		//A REMPLIR
		}
	}
	public static void main(String [] arg) {
		hanoi(4,'a', 'b', 'c');
	}
}
