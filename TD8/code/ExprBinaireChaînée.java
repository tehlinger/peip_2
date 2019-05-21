@SuppressWarnings("unchecked")
public class ExprBinaireChaînée extends ArbreBinaireChaîné<Integer> implements ExprBinaire
  {
    public ExprBinaireChaînée(Integer e) { super(e); }
    public ExprBinaireChaînée(Integer e, ExprBinaire g, ExprBinaire d) {
      super(e, (ArbreBinaireChaîné<Integer>) g, (ArbreBinaireChaîné<Integer>)
      d);
    }
    /*
    * Rôle : renvoie le résultat de l'évaluation de l'expression
    * représentée par l'arbre binaire a
    */
    public Integer éval() throws ArbreVideException {
      if (this.estUneFeuille()) {
        //TODO
      }
      else {
        //TODO
        // c'est un opérateur : '+' || '-' || '*' || '/'
        //ATTENTION : pour lire le nombre 43 comme un + :
        //(char) this.racine().intValue()
      }
      // pour faire plaisir au compilateur
      return 0;
    }

    /*
    * Rôle : renvoie la représentation, sous forme de String, d'un opérande.
    * Le parenthèse si nécessaire
    */
  public String toString() {
    try {
    }
    catch (ArbreVideException e) { return "";}
  }
}
