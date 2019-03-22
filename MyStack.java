import java.util.LinkedList ;
import java.util.EmptyStackException ;
import static java.lang.System.out;

class MyStack{
	LinkedList<Integer> l;

	public MyStack(){
		this.l = new LinkedList<Integer>();
	}

	public boolean empty(){
		return this.l.size() == 0 ;
	}

	public int peek(){
		return this.l.get(l.size()-1);
	}

	public void push(int e){
		this.l.add(e);
	}

	public String toString(){
		return l.toString();
	}

	public int pop(){
		if (this.l.size() == 0){
			throw new EmptyStackException();
		}
		else{
			int e = this.l.get(this.l.size()-1);
			this.l.remove(l.size()-1);
			return e;
	}
	}

	public static void main(String[] argv){
		MyStack s = new MyStack();
		out.println(s);
		out.println(s.empty());
		s.push(23);
		s.push(42);
		out.println(s);
		out.println(s.empty());
		out.println(s.peek());
		out.println(s.pop());
		out.println(s);
		out.println(s.empty());
	}
}
