/*
1.4 - Palindrome Permutation

Given a string, write a function to check if it is a permutation of a palindrome.
A palindrome is a word or phrase that is the same forwards and backwards. A permutation
is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
EXAMPLE
Input: Tact Coa
Output: True (permutations: "taco cat". "atco cta". etc.)

Also on LeetCode: https://leetcode.com/problems/palindrome-permutation/description/
*/

//O(n) solution with HashMap
public boolean canPermutePalindrome(String s) {
	if (s == null) return false;
	
	Map<Character, Integer> count = new HashMap<>();
	
	for (Character c : s.toCharArray()){
		count.put(c, count.getOrDefault(c, 0) + 1);
	}
	
	boolean single = false;
	for (Integer num : count.values()){
		if (num % 2 == 1 && !single) single = true;
		else if (num % 2 == 1 && single) return false;
	}
	
	return true;
}

//Can also use HashSet to save space