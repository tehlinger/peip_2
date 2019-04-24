import java.util.*;

class ListeTri<C extends Comparable<C>, V> {
    public List<Element<C,V>> l;
	public boolean isDemo = false;

    public ListeTri() {
	l = new ArrayList<Element<C,V>>();
    }

    public int size() {
	return l.size();
    }

    public String sublist(int g, int d){
	String r = "";
	for (int i = 0; i <= d - g; i++){ 
		r += l.get(g+i).cle().toString()+",";
	}
	return r;
	}
		
    
    /*
     *  Rôle : ajout x dans la liste ordonnee courante à sa place pour
     *         maintenir la relation d'ordre sur les elements
     */
    public void add(C c, V v) {
	l.add(new Element<C,V>(c,v));
    }
    public void  triInsertSeq2() {
	for (int i=1; i<l.size(); i++){
	    Element<C,V> candidat = l.get(i);
	    for(int j=0; j<i; j++){
		if(l.get(i-(j+1)).cle().compareTo(candidat.cle())>0){
		    l.set(i-j, l.get(i-(j+1)));
		    l.set(i-(j+1), candidat);
		    candidat = l.get(i-(j+1));
		}
	    }
	}
    }

    /*
     *  Rôle : tri la liste courante selon la methode d'insertion sequentielle
     */
    public void  triInsertSeq() {
	Element<C,V> tmp= null;
	for (int i=1; i<l.size(); i++) {
		boolean matchFound = false;
	        Element<C,V> cand = l.get(i);
		Element<C,V> before= cand;
		for (int j=0; j<i; j++){
			if (!matchFound){
				//If i < j
				if (cand.cle().compareTo(l.get(j).cle()) < 0){
			matchFound=true;
			before = l.get(j);
			l.set(j,cand);}
			}else{
				tmp = l.get(j);
				l.set(j,before);
				before = tmp;
				}
			}
		l.set(i,before);
		}
	    }

    public void insertOne(int index,Element <C,V> e){
	if (index <= l.size()){
	l.add(e);
	int i = 0;
	for (i = l.size()-1; i > index ; i--){
		l.set(i,l.get(i-1));
	}
 	l.set(i,e);
	}
    }	

	public boolean estTrie(){
		for (int i=1; i<l.size(); i++) {
	        	Element<C,V> previous = l.get(i-1);
	        	Element<C,V> next = l.get(i);
			if (previous.cle().compareTo(next.cle()) > 0){
				return false;
			}
		}
		return true;
	}

public void triQS(){
	int g = 0; int d = l.size() - 1;
	triQS(g,d);
	}

private void triQS(int g, int d){
	int i=g, j=d;
	C pivot = l.get((i+j)/2).cle();
	if (this.isDemo){
	System.out.print("Pivot : " +pivot);
	System.out.println("\t"+this.sublist(g,d));}
	Element < C,V > tmp = null;
	do{
		while (pivot.compareTo(l.get(i).cle()) > 0) i++;
		while (pivot.compareTo(l.get(j).cle()) < 0) j--;
		if (i<=j) {
		    tmp = l.get(i);
		    l.set(i,l.get(j));
		    l.set(j,tmp);		     
		    i++; j--;
		}
	if (this.isDemo){
	System.out.println("\t\t"+this.sublist(g,d));}
	} while (i<=j ) ;
	//System.out.println(this.sublist(g,d));
	if (g<j) triQS (g, j) ;
	if (d>i)  triQS (i, d) ;
}
	
    /*
     *  Rôle : tri la liste courante selon la methode selection directe
     */
    public void  triSelection() {
	for (int i=0; i<l.size()-1; i++) {
	    // Invariant : la sous-liste l(0..i-1) est triee
	    // et tous les elements de l(i..l.size()-1) sont
	    // superieurs à ceux de la première sous-liste
	    int min=i;
	    // chercher l'indice du  min dans la liste l(i..l.size()-1)
	    for (int j=i+1; j < l.size(); j++)
		if (l.get(j).cle().compareTo(l.get(min).cle())<0)
		    min=j;
	    // echanger l.get(i) et l.get(min)
	    if (min != i) {
		Element<C,V> aux = l.get(i);
		l.set(i, l.get(min));
		l.set(min, aux);
	    }
	}
    }

    /*
     *  Rôle : tri la liste courante selon la methode d'insertion dichotomique
     */
    public void  triInsertDicho() {
	int g,m,d,v,indToInsert;
	C cand;
	Element<C,V> tmp;
	boolean notFound = true;
	for (int i = 1; i < l.size(); i++){
	    g = 0 ; d = i -1 ; indToInsert = i;
	    tmp = l.get(i);
	    cand = tmp.cle();
	    notFound = true;
	    while(notFound){
		m = (g+d)/2;
		if (d - g <= 1){
			notFound = false;
		        if (cand.compareTo(l.get(g).cle())<0){
		        	indToInsert = g;
		        	}else{
		        	    if(cand.compareTo(l.get(d).cle())<0){
		        		indToInsert = d;
		        		}
		        	}
		l.remove(i);
		this.insertOne(indToInsert,tmp);
		}
		if (cand.compareTo(l.get(m).cle())<0){
		   d = m;
		}else{
		   g = m;
		}
	    }
        }
    }
    
    public String toString() { 
	String result = "";
	for (Element <C,V> i : l){
		result += i.cle();
		result += ", ";
	}
	return result;
    }

    private class Element<C extends Comparable<C>,V> {
        private C cle;
	private V valeur;
	
	Element(C c, V v) {
	    this.cle = c;
	    this.valeur = v;
	}

	public String toString() {
	    return "(" + this.cle + "," + this.valeur + ")";
	}

	C cle() { return this.cle; }
	V valeur() { return this.valeur; }
    } // fin class Element

public static double launchOneIns(long n) throws Exception{
	Random r = new Random();
	ListeTri<Integer, String> l = new ListeTri<Integer, String>();
	for (int i=0; i<n; i++) l.add(r.nextInt(), "x");
	long t1 = System.nanoTime();
	l.triInsertSeq();
	long t2 = System.nanoTime();
	if (!l.estTrie()){
		throw new Exception("Liste non triee");
	}	
	return ((double) (t2-t1)/1e9);
}

public static double launchOneDicho(long n) throws Exception{
	Random r = new Random();
	ListeTri<Integer, String> l = new ListeTri<Integer, String>();
	for (int i=0; i<n; i++) l.add(r.nextInt(), "x");
	//System.out.println(l);
	long t1 = System.nanoTime();
	l.triInsertDicho();
	long t2 = System.nanoTime();
	//System.out.println(l);
	if (!l.estTrie()){
		throw new Exception("Liste non triee");
	}	
	return ((double) (t2-t1)/1e9);
}

public static double launchOneTommy(long n) throws Exception{
	Random r = new Random();
	ListeTri<Integer, String> l = new ListeTri<Integer, String>();
	for (int i=0; i<n; i++) l.add(r.nextInt(), "x");
	long t1 = System.nanoTime();
	l.triInsertSeq2();
	long t2 = System.nanoTime();
	if (!l.estTrie()){
		throw new Exception("Liste non triee");
	}	
	return ((double) (t2-t1)/1e9);
}

public static double launchOneSelec(long n) throws Exception {
	Random r = new Random();
	ListeTri<Integer, String> l = new ListeTri<Integer, String>();
	for (int i=0; i<n; i++) l.add(r.nextInt(), "x");
	long t1 = System.nanoTime();
	l.triSelection();
	long t2 = System.nanoTime();
	if (!l.estTrie()){
		throw new Exception("Liste non triee");
	}	
	return ((double) (t2-t1)/1e9);
}

public static double launchOneQS(long n) throws Exception{
	Random r = new Random();
	ListeTri<Integer, String> l = new ListeTri<Integer, String>();
	if (n > 0){
		for (int i=0; i<n; i++) l.add(r.nextInt(), "x");
	}else{
	for (int i : new int[]{23,42,70,11,25,77,69,18,1
			//,13,68,12,67,777,65
			}) l.add(i, "x");
	l.isDemo = true;
	}
	long t1 = System.nanoTime();
	l.triQS();
	long t2 = System.nanoTime();
	if (!l.estTrie()){
		throw new Exception("Liste non triee");
	}	
	return ((double) (t2-t1)/1e9);
}


    public static void main(String []args) throws Exception {
	boolean isDemo = false;
	long n ;
	long size;
	try{
		n = Long.valueOf(args[0]);
		size = Long.valueOf(args[1]);
	}
	catch (ArrayIndexOutOfBoundsException e) {
		isDemo = true;
		n = 1;
		size = 0;
	}
	double tSelec, tIns, tTommy, tDicho, tQS;
	double percent;
	double totalSelec = 0;
	double totalIns = 0;
	double totalQS = 0;
	double totalTom = 0;
	double totalDicho = 0;
	System.out.println("[" +n+" tris, "+size+" éléments]");

	for (int i = 0; i < n; i++){
		if(!isDemo){
		    //SELECTION
		    tSelec = launchOneSelec(size);
		    totalSelec += tSelec;

		    //INSERTION LINEAIRE
		    tIns = launchOneIns(size);
		    totalIns += tIns;

		    //TRI DE TOMMY
		    tTommy = launchOneTommy(size);
		    totalTom += tTommy;

		    //INSERTION DICHOTOMIQUE
		    tDicho = launchOneDicho(size);
		    totalDicho += tDicho;
		    }

		    //QUICK SORT
		    tQS = launchOneQS(size);
		    totalQS += tQS;
		    System.out.print(".");
	        }
	System.out.print("\n");
	if (!isDemo){
	System.out.println("Select : "+(totalSelec/n)+"sec");
	System.out.println("Tommy  : "+(totalTom/n)+"sec");
	System.out.println("Insert : "+(totalIns/n)+"sec");
	System.out.println("Dicho  : "+(totalDicho/n)+"sec");
	System.out.println("QS     : "+(totalQS/n)+"sec");}
//	System.out.println(l);
//	System.out.println("--------- start ------------");
//	//l.triSelection();
//	l.triInsertDicho();
//	System.out.println("--------- end ------------");
//	System.out.println(l);
    }
}
