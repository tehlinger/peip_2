import java.util.*;

public class ListeRech<C extends Comparable<C>, V>
{
    List<Element<C,V>> l;

    public ListeRech() {
	l = new ArrayList<Element<C,V>>();
    }

    public void add(C c, V v) {
	l.add(new Element<C,V>(c,v));
    }

    public V rechercheLineaire(C c) throws CleNonTrouveeException {
	for (Element e : this.l){
		if (e.cle() == c){
			return (V) e.valeur();
		}	
	}
	throw new CleNonTrouveeException();
    }

    public V rechercheLineaireOrd(C c) throws CleNonTrouveeException {
	for (Element e : this.l){
		if (e.cle() == c){
			return (V) e.valeur();
		}	
		else{
			C a = (C) e.cle();
			if (a.compareTo(c) > 0){
				System.out.println("Stopped at : "+e);
				throw new CleNonTrouveeException();
			}	
		}
	}
	throw new CleNonTrouveeException();
    }
    

    /**
     * Antecedent : l.longueur()>=1
     *
     * Rôle : recherche dichotomique, classique
     */
    public V rechercheDicho0(C c) throws CleNonTrouveeException {
	return null;
    }

    /**
     * Antecedent : l.longueur()>=1
     *
     * Rôle : recherche dichotomique, classique ecrite de façon recursive
     */
    private V rechercheDichoR(C c, int gauche, int droite)
	throws CleNonTrouveeException
    {
	return null;
    }

    /**
     *
     * Rôle : recherche dichotomique, classique et recursive
     */
    public V rechercheDichoR(C c) throws CleNonTrouveeException {
	return null;
    }


    /**
     * Antecedent : l.longueur()>=1
     *
     * recherche dichotomique (2ème methode)
     * Cette seconde methode n'utilise plus qu'une seule comparaison
     * Dans ce cas, cet algorithme ne peut s'arrêter
     * dès qu'il a trouve l'element recherche ! Au contraire, il
     * parcourt l'arbre de decision jusqu'à son terme, de la même façon
     * que s'il recherchait un element n'appartenant pas à la
     * table. S'il est present dans la table, l'element recherche se
     * trouve à l'indice << gauche >> ?  Si l'element
     * recherche apparaît plusieurs fois dans la table, quel est celui
     * trouve par cette methode ?
     * Cette methode est efficace (puisqu'il n'y a plus qu'un seul test)
     * dans le cas où les recherches sont le plus souvent negatives.
     */
    V rechercheDicho(C c) throws CleNonTrouveeException {
	return null;
    }

    public String toString() {
	return l.toString();
    }

    public static void main(String []args) throws Exception {
	int n;
	ListeRech<Integer, String> l = new ListeRech<Integer, String>();
	l.add(-12, "toto");
	l.add(-9, "kiki");
	l.add(-1, "titi");
	l.add(5, "kaki");
	l.add(8, "keki");
	l.add(9, "kiki");
	l.add(10, "koki");
	l.add(11, "kuki");
	l.add(12, "kyko");
	l.add(100, "baba"); 
	System.out.println(l);
	System.out.println("==========");
	for (int i : new int[] {-12,-1,5,100}){
	System.out.println("[Lin, key :"+i+"] found : " + l.rechercheLineaire(i));
	System.out.println("[Ord, key :"+i+"] found : " + l.rechercheLineaireOrd(i));
	//System.out.println("[LinOrd, key :"+i+"] found : " + l.rechercheLineaireDicho0(i));
	}
    }
}
