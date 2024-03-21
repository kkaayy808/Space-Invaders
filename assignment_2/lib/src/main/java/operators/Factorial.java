package operators;

public class Factorial extends UnaryOperator{

	private Term term;
	
	public Factorial(Term termObjectReceived) {
		super(termObjectReceived);
		this.term = termObjectReceived;
		
	}
	
	public int getValue() {
		
		int result = 1;
		int val = term.getValue();
		
		for (int i = 1; i <= val; i++) {
			result *= i;
		}
		
		return result;
		
	}

}
