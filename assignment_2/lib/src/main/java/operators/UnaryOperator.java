package operators;

public abstract class UnaryOperator implements Term{
	
	private Term termObject;
	
	public UnaryOperator(Term termObjectReceived) {
		if (termObjectReceived == null) {
			throw new IllegalArgumentException("Term cannot be null");
		}
		this.termObject = termObjectReceived;
	}

	public Term getTerm() {
		return termObject;
	}
}
