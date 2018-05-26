/*
1.2 - Check Palindrome

Given two strings, write a method to decide if one is a permutation of the
other.

EXAMPLE
"hello" and "elhlo" --> True
"pencil" and "cilpens" --> False
*/

public boolean checkPalindrome(String word1, String word2){
	int[] count1 = new int[128];
	int[] count2 = new int[128];

	for (char c : word1.toCharArray()) count1[c]++;
	for (char c : word2.toCharArray()) count2[c]++;

	for (int i = 0; i < 128; i++){
		if (count1[i] != count2[i]) return false;
	}

	return true;
}