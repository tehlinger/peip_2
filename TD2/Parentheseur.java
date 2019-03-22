import static java.lang.System.out;
import java.util.Stack;
import java.io.*;

public class Parentheseur{

	private static boolean par_closes_par(char a,char b){
		if (a == '(') {
			return b == ')';
		}
		if (a == '[') {
			return b == ']';
		}
		else {
			return false;
		}
	}

	private static boolean is_ouvrant(char par){
		return (par=='(') || (par == '[');
	}

	private static boolean is_fermant(char par){
		return (par==']') || (par == ')');
	}

	private static boolean is_par(char par){
		return  is_ouvrant(par) || is_fermant(par);
	}

	private static void msg(String s){
		System.err.println(s);
	}

	public static void main (String[] argv) throws IOException{
		Stack stack = new Stack();
		StreamTokenizer st = new StreamTokenizer(
				new BufferedReader(
				new InputStreamReader(System.in)));
		while(st.nextToken() != st.TT_EOF){
			char par = (char) st.ttype;
			if (is_par(par)){
				if (is_ouvrant(par)){
					stack.push(par);
				}
				else{
					try {
					char prec_par = (char) stack.pop();
					if (!par_closes_par(prec_par,par)){
					msg("No match between " +
					prec_par + " and " + par);
					return;
					}
					}
					catch (java.util.EmptyStackException e) {
						msg("Char : " +par + " has no predecessor.");
						return;
					}
				}
			}
		}
		if (stack.empty()){
			out.println("All good!");
		}
		else{
			msg("\nNot okay.");
		}
	}
}

