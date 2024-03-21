package operators;

public abstract class BinaryOperator implements Term{
	
	private Term term1;
	private Term term2;

	public BinaryOperator(Term termOne, Term termTwo) {
		if (termOne == null) {
			throw new IllegalArgumentException("left term cannot be null");
		}
		else if (termTwo == null) {
			throw new IllegalArgumentException("right term cannot be null");
		}
		else {
			this.term1 = termOne;
			this.term2 = termTwo;
		}
	}
	
	public Term getLeft() {
		return term1;
	}
	
	public Term getRight() {
		return term2;
	}
}
