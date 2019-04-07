class Element <C extends Comparable <C>,V> {
	private C cle;
	private V valeur;

	Element(C c, V v) {
		this.cle = c;
		this.valeur = v;
	}

	public String toString() {
	return "(" + this.cle + "," + 
		this.valeur + ")";
	}

	C cle() { return this.cle; }
	V valeur() { return this.valeur; }
}
