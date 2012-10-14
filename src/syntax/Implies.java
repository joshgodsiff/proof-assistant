package syntax;

public class Implies extends BinaryConnective {
	
	public Implies(Formula left, Formula right) {
		super(left, right);
	}
	
	@Override
	public int compareTo(Formula o) {
		return 4;
	}
	
	public String toString() {
		return "("+left().toString() + " IMPLIES " + right().toString()+")";
	}
}