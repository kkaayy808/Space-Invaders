package operators;

public class Plus extends BinaryOperator{


	public Plus(Term termOne, Term termTwo) {
		super(termOne, termTwo);

	}

	
	public int getValue() {
		

		int val1 = super.getLeft().getValue();
		int val2 = super.getRight().getValue();
		return val1 + val2;
		
	}
}
