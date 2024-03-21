package operators;

public class Number implements Term{
	
	private int num;
	
	public Number(int number) {
		this.num = number;
	}

	@Override
	public int getValue() {
		return num;
	}

}
