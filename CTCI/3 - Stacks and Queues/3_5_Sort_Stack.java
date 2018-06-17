/*
3.5 - Sort Stack

Write a program to sort a stack such that the smallest items are on the top. You can use
an additional temporary stack, but you may not copy the elements into any other data structure
(such as an array). The stack supports the following operations: push, pop, peek, and isEmpty.
*/

//First attempt
public Stack<E> sortStack(Stack stack) {
	if (stack.isEmpty()) return stack;
	Stack<E> sortStack = new Stack<>();
	E tempMax = stack.pop();	
	int currentSize = 0;
	while (!stack.isEmpty()) {
		while (!stack.isEmpty()) {
			E temp = stack.pop();
			if (temp.compareTo(tempMax) > 0) {
				tempMax = temp;
			} else {
				currentSize++;
				sortStack.push(temp);
			}
		}
		for (int i = 0; i < currentSize; i++) {
			stack.push(sortStack.pop());
		}
		sortStack.push(tempMax);
		tempMax = stack.pop();
		currentSize = 0;
	}
	sortStack.push(tempMax);
	
	return sortStack;
}