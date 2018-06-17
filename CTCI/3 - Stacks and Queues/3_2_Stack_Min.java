/*
 * 3.2 - Stack Min
 * How would you design a stack which, in addition to push and pop, has a function min
 * which returns the minimum element? Push, pop and min should all operate in 0(1) time
*/



public E MinStack { 
	private static final int MAX_SIZE = 100;
	private int count = 0;
	private E[] stack;
	private E[] min;
	
	public Stack(int MAX_SIZE) {
		this.stack = new E[MAX];
		this.min = new E[MAX];
	}
	
	public Stack() {
		this.stack = new E[10];
		this.min = new E[10];
	}
	
	public boolean push(E item) {
		if (count == stack.length) return false;
		item.compareTo(min[count - 1]) < 0 ? min[count] = item : min[count] = min[count - 1];
		stack[count++] = item;
		return true;
	}

	public E pop() {
		if (count == 0) throw new EmptyStackException();
		return stack[--count];
	}
	
	private E min() {
		if (count == 0) throw new EmptyStackException();
		return min[count - 1];;
	}

}