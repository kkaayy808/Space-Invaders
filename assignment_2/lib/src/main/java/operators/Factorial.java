package operators;

public class Factorial extends UnaryOperator{

	
	public Factorial(Term termObjectReceived) {
		super(termObjectReceived);
		if (termObjectReceived.getValue() < 0) {
			throw new IllegalArgumentException("negative value: " + termObjectReceived.getValue());
		}
		
	}
	
	public int getValue() {
		
		int result = 1;
		int val = super.getTerm().getValue();
		
		for (int i = 1; i <= val; i++) {
			result *= i;
		}
		
		return result;
		
	}

}
