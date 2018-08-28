/*
This problem was asked by Facebook, Bloomberg, Microsoft, Amazon, Google, LinkedIn

Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).

For example, given the string "([])[]({})", you should return true.

Given the string "([)]" or "((()", you should return false.

Also on LeetCode: https://leetcode.com/problems/valid-parentheses/description/
*/

public boolean isValid(String s) {
	Deque<Character> stack = new LinkedList<>();
	
	for (Character c : s.toCharArray()) {
		if (c == '(' || c == '[' || c == '{') {
			stack.push(c);
		} else if (c == ')') {
			if (stack.isEmpty() || stack.peekFirst() != '(') {
				return false;
			}
			stack.removeFirst();
		} else if (c == ']') {
			if (stack.isEmpty() || stack.peekFirst() != '[') {
				return false;
			}
			stack.removeFirst();
		} else if (c == '}') {
			if (stack.isEmpty() || stack.peekFirst() != '{') {
				return false;
			}
			stack.removeFirst();
		}
	}
	
	return stack.isEmpty();
}