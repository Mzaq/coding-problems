//Given a stack of N elements, interleave the first half of the stack with the second half reversed using only one other queue. This question was asked by Google.

//Assuming only using basic stack/queue functionality

//For example, if the stack is [1, 2, 3, 4, 5], it should become [1, 5, 2, 4, 3].

public Deque<Integer> interleaveStacks(Deque<Integer> stack){
	Deque<Integer> queue = new LinkedList<>();
	if (stack.size() == 0 || stack.size() == 1){
		return stack;
	}
	
	while (!stack.isEmpty()){
		queue.addFirst(stack.removeFirst());
	}
	
	while (!queue.isEmpty()){
		stack.addFirst(queue.removeLast());
		if (!queue.isEmpty()){
			stack.addFirst(getFirstQueueElement(queue));
		}
	}
	
	stack = reverseStack(stack);
	
	return stack;
}

private Integer getFirstQueueElement(Deque<Integer> queue){
	for(int i = 0; i < queue.size() - 1; i++){
		queue.addFirst(queue.removeLast);
	}
	return queue.removeLast();
}

private Deque<Integer> reverseStack(Deque<Integer> stack){
	Deque<Integer> queue = new LinkedList<>();
	
	while (!stack.isEmpty()){
		queue.addFirst(stack.removeFirst());
	}
	
	while (!queue.isEmpty()){
		stack.addFirst(queue.removeLast());
	}
	
	return stack;
}