/**
* Cette application lit sur l'entrée standard des expressions arithmétiques
* en notation positixée, et les écrit sur la sortie standard en notation infixe
* avec le résultat de leur évaluation.
*
* @author Vincent Granet (03/05/2016)
*/
import java.io.*;
import java.util.*;
public class EvalExpr {
  public static void main(String [] args) throws Exception {
    // créer un flot d'unités syntaxiques à partir de l'entrée standard
    StreamTokenizer st =
    new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    Stack<ExprBinaire> s = new Stack<ExprBinaire>();
    st.ordinaryChar((int) '/');
    st.eolIsSignificant(true);
    while (st.nextToken() != st.TT_EOF) {
      //On lit un entier
      if (st.ttype == st.TT_NUMBER)
      else
      //On le symbole 'end of line'
      if (st.ttype == st.TT_EOL){
      }
      //On lit un opérateur
      else {
        // un opérateur => empiler un arbre avec ses 2 opérandes
      }
    }
    }
} // fin EvalExpr
