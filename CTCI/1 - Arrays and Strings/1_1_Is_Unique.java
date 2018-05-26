/*
1.1 - Is Unique

Implement an algorithm to determine if a string has all unique characters. What if you
cannot use additional data structures?

EXAMPLE
Input: hello
Output: false

Input: abcd
Output: true
*/

public boolean isUnique(String input){
	if (input.length() > 128) return false;
	Set<Character> set = new HashSet<>();

	for (char c : input.toCharArray()){
		if(!set.add(c)) return false;
	}
	return true;
}

//Assuming lowercase only
public boolean isUniqueLowercase(String input){
	int flag = 0;
	for (char c : input.toCharArray()) {
		int value = c - 'a';
		if ((flag & (1 << value)) != 0){
			return false;
		}
		flag |= (1 << value);
	}
	return true;
}