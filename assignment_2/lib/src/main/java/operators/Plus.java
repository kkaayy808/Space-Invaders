package operators;

public class Plus extends BinaryOperator{
	
//	private Term firstTerm;
//	private Term secondTerm;

	public Plus(Term termOne, Term termTwo) {
		super(termOne, termTwo);
//		this.firstTerm = termOne;
//		this.secondTerm = termTwo;
	}

	
	public int getValue() {
		
//		int val1 = term1.getValue();
//		int val2 = term2.getValue();
		int val1 = super.getLeft().getValue();
		int val2 = super.getRight().getValue();
		return val1 + val2;
		
	}
}
