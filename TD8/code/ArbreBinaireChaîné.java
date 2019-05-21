public class ArbreBinaireChaîné<T extends Comparable<T>> implements ArbreBinaire<T> {
    @SuppressWarnings("unchecked")
    public static final ArbreBinaire arbreVide = new ArbreBinaireChaîné();
    private T valeur;
    private ArbreBinaire<T> sag, sad;

    public T racine(){
      return this.valeur;
    }

    // uniquement pour construire la constante arbreVide
    private ArbreBinaireChaîné() {
	this(null, null, null);
    }

    /**
     * Rôle : créer une feuille de l'arbre
     *        étiquetée par valeur
     */
    @SuppressWarnings("unchecked")
    public ArbreBinaireChaîné(T valeur) {
	this(valeur, arbreVide, arbreVide);
    }

    /**
     * Rôle : créer un noeud de l'arbre étiqueté par valeur et dont
     *        les sous-arbres sont sag et sad
     */
    @SuppressWarnings("unchecked")
    public ArbreBinaireChaîné(T valeur, ArbreBinaire<T> sag, ArbreBinaire<T> sad)
    {
	this.valeur = valeur;
	// on fait attention à ce que les paramètres sag et sad
	// ne soient pas null
	this.sag = (sag == null) ? arbreVide : sag;
	this.sad = (sad == null) ? arbreVide : sad;
    }

    /**
     * Rôle : retourne true si l'arbre courant est vide
     *        et false sinon
     */
    @SuppressWarnings("unchecked")
    public boolean estVide() {
	return this == arbreVide;
    }

    /**
     * Rôle : retourne le sous-arbre gauche de l'arbre courant
     */
    public ArbreBinaire<T> sag() throws ArbreVideException {
	if (this.estVide())
	    throw new ArbreVideException();
	return this.sag;
    }

    /**
     * Rôle : retourne le sous-arbre droit de  l'arbre courant
     */
    public ArbreBinaire<T> sad() throws ArbreVideException {
	if (this.estVide())
	    throw new ArbreVideException();
	return this.sad;
    }


    /*estVide
     * Rôle : modifie le sous-arbre gauche de l'arbre courant
     */
    public void changerSag(ArbreBinaire<T> g) {
	this.sag = g;
    }

    /**
     * Rôle : modifie le sous-arbre droit de l'arbre courant
     */
    public void changerSad(ArbreBinaire<T> d) {
	this.sad = d;
    }

    /**
     * Rôle : retourne la valeur de l'arbre courant
     */
    public T valeur() throws ArbreVideException {
	if (this.estVide())
	    throw new ArbreVideException();
	return this.valeur;
    }

    @SuppressWarnings("unchecked")
    public ArbreBinaire<T> getArbreVide() {
	return  this.arbreVide;
    }

        /**
     * Rôle : retourne vrai si les arbres this et a sont miroirs
     *        et faux sinon
     */
    public boolean estMiroir(ArbreBinaire<T> a) throws ArbreVideException {
	    return estMiroir(this,a);
    }

    /*
     * Rôle : estMiroir = vrai si a est le miroir de b; faux sinon
     *
     */
    private boolean estMiroir(ArbreBinaire<T> a, ArbreBinaire<T> b)
	throws ArbreVideException

    {
	if (a.estVide() &&  b.estVide())
	    // les deux arbres sont vides
	    return true;
	if (a.estVide() || b.estVide())
	    // un des deux arbres est vide et pas l'autre
	    return false;
	// les 2 arbres de sont pas vides
	if (a.valeur().compareTo(b.valeur()) != 0)
	    // le noeuds sont différents
	    return false;
	// les 2 noeuds sont identiques
	return estMiroir(a.sag(),b.sad()) && estMiroir(a.sad(),b.sag());
    }

    private int hauteur(ArbreBinaire<T> a) throws ArbreVideException {
	return a.estVide() ?  0 :
	    1 + Math.max(hauteur(a.sag()),hauteur(a.sad()));
    }


    /** Rôle : retourne la hauteur de l'arbre binaire courant
     *
     * @return <code>int</code>
     */
    public int hauteur() throws ArbreVideException {
	if (estVide())
	    throw new ArbreVideException();
	return hauteur(this) - 1;
    }

        /**
     * Rôle : écrit sur la sortie standard l'arbre courant. Il est écrit
     * de façon horizontale avec la racine placé à gauche.
     *
     * Note : utilise un parcours DNG
     */
  public void écrireArbre(String d) throws ArbreVideException {
	   écrireArbre(this, d);
  }


    private void écrireArbre(ArbreBinaire<T> a, String d)
	throws ArbreVideException
    {
	final String  h = "  ";
	if (! a.estVide()) {
	    // écrire le sous arbre droit
	    écrireArbre(a.sad(), d+h);
	    // écrire la valeur du noeud avec son décalage
	    System.out.println(d + a.valeur());
	    // écrire le sous arbre gauche
	    écrireArbre(a.sag(), d+h);
	}
    }

    private String toString(ArbreBinaire<T> a, String d)
	throws ArbreVideException
    {
	final String  h = "  ";
	if (a.estVide()) return "";
	return toString(a.sad(), d+h) + d + a.valeur() + "\n" + toString(a.sag(), d+h);
    }

    public String toString(String d) {
	try {
	    return toString(this, d);
	} catch (ArbreVideException e) {
	    return "";
	}
    }

    public boolean estUneFeuille() throws ArbreVideException {
	return this.sag().estVide() && this.sad().estVide();
    }

} // fin classe ArbreBinaireChaîné
