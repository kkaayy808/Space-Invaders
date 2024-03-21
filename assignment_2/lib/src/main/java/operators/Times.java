package operators;

public class Times extends BinaryOperator{
	
	private Term firstTerm;
	private Term secondTerm;

	public Times(Term termOne, Term termTwo) {
		super(termOne, termTwo);
		this.firstTerm = termOne;
		this.secondTerm = termTwo;
	}
	
	public int getValue() {
		
		int val1 = firstTerm.getValue();
		int val2 = secondTerm.getValue();
		return val1 * val2;
		
	}

}
