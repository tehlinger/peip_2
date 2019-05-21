public class Test {
public static void main(String [] args) throws ArbreVideException {
	ArbreBinaire<String> b = new ArbreBinaireChaîné<String> ("x", new ArbreBinaireChaîné<String>("y"), new ArbreBinaireChaîné<String>("m"));
  ArbreBinaire<String> a = new ArbreBinaireChaîné<String> ("a", new ArbreBinaireChaîné<String>("b"), b);
	ArbreBinaire<String> c = new ArbreBinaireChaîné<String> ("z", a, new ArbreBinaireChaîné<String>("j"));

	if (b != ArbreBinaireChaîné.arbreVide)
	System.out.println("−−−−−−−−−−−−−−−−−−−−−−");
	c.écrireArbre(" ");
	System.out.println("hauteur = " + c.hauteur());
	System.out.println("mirroir ? " + a.estMiroir(b));
	System.out.println("−−−−−−−−−−−−−−−−−−−−−−");
	 }
}
