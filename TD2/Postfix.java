import static java.lang.System.out;
import java.util.Stack;
import java.io.*;

public class Postfix{

	private static void msg(String s){
		System.err.println(s);
	}

	private static Boolean is_operand(char c){
		return (c == '*') || (c == '+')|| (c == '/')|| (c == '-');
	}

	private static double applyOp(char op, double a, double b){
		switch(op){
			case '*' : return a * b;
			case '/' : return a / b;
			case '-' : return a - b;
			case '+' : return a + b;
			default : return -1;
		}
	}

	public static void main (String[] argv) throws IOException{
		double a;
		double b;
		Stack stack = new Stack();
		StreamTokenizer st = new StreamTokenizer(
				new BufferedReader(
				new InputStreamReader(System.in)));
		st.ordinaryChar((int) '/');

		while(st.nextToken() != st.TT_EOF){
			//On reçoit un entier, on empile juste
			if(st.ttype == st.TT_NUMBER ){
				stack.push(st.nval);
			}
			else{
				char op = (char) st.ttype;
				//On reçoit un opérande, alors on désempile
				if (is_operand(op)){
					try{
					a = (double) stack.pop();
					b = (double) stack.pop();
					stack.push(applyOp(op,a,b));
					}
					catch (java.util.EmptyStackException e) {
						msg("Opérande manquant");
						return;
					}
				}
				else {
					//Fin de calcul
					if (op == '='){
						double result =
							(double) stack.pop();
						if (stack.empty()) {
							out.println(result);
							return ;
						}
						else{
							msg("Syntaxe invalide");
							return ;
						}
					}
					//Caractère inconnu
					else{
						msg("Caractère inconnu");
						return;
					}
				}
			}
		}
	}
}

