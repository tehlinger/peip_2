public interface ArbreBinaire<T> {
    public boolean estVide();
    public ArbreBinaire<T> sag() throws ArbreVideException;
    public ArbreBinaire<T> sad() throws ArbreVideException;
    public T valeur() throws ArbreVideException;
    public ArbreBinaire<T> getArbreVide();
    public void changerSag(ArbreBinaire<T> g);
    public void changerSad(ArbreBinaire<T> d);
    public boolean estUneFeuille() throws ArbreVideException;
    public void écrireArbre(String d) throws ArbreVideException;
    public int hauteur()  throws ArbreVideException;
    public boolean estMiroir(ArbreBinaire<T> a) throws ArbreVideException;
}
