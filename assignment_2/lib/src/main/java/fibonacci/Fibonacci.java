package fibonacci;

import java.util.Iterator;

public class Fibonacci implements Iterable<Long>{

	@Override
	public Iterator<Long> iterator() {
		return new Iterator<Long>() {
			private long num1 = 1;
			private long num2 = 1;
			private int count = 0;
			@Override
			public boolean hasNext() {
				return true;
			}
			@Override
			public Long next() {
				if (count == 0) {
					count++;
					return num1;
				}
				if (count == 1) {
					count++;
					return num2;
				}
				long temp = num1 + num2;
				num1 = num2;
				num2 = temp;
				return num2;
			}
		};
	}


}

