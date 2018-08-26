/*
This problem was asked by Facebook, Microsoft, Google, Coursera, Bloomberg

Implement regular expression matching with the following special characters:

. (period) which matches any single character
* (asterisk) which matches zero or more of the preceding element
That is, implement a function that takes in a string and a valid regular expression and returns whether or not the string matches the regular expression.

For example, given the regular expression "ra." and the string "ray", your function should return true. The same regular expression on the string "raymond" should return false.

Given the regular expression ".*at" and the string "chat", your function should return true. The same regular expression on the string "chats" should return false.

Also on LeetCode: https://leetcode.com/problems/regular-expression-matching/description/
*/

//DP solution
final char WILD_CARD_CHAR = '.';
final char REPEAT_CHAR = '*';

public boolean isMatch(String s, String p) {
	if (s == null || p == null) return false;
	
	boolean[][] isMatch = new boolean[s.length() + 1][p.length() + 1];
	isMatch[0][0] = true;
	
	for (int j = 2; j < isMatch[0].length; j++) {
		if (p.charAt(j - 1) == REPEAT_CHAR) {
			isMatch[0][j] = isMatch[0][j - 2];
		}
	}
	
	for (int i = 1; i < isMatch.length; i++) {
		for (int j = 1; j < isMatch[0].length; j++) {
			char string = s.charAt(i - 1); 
			char pattern = p.charAt(j - 1);
			
			if (string == pattern || pattern == WILD_CARD_CHAR) {
				isMatch[i][j] = isMatch[i - 1][j - 1];
			} else if (pattern == REPEAT_CHAR) {
				if (p.charAt(j - 2) == string || p.charAt(j - 2) == WILD_CARD_CHAR) {
					isMatch[i][j] = isMatch[i][j - 2] || isMatch[i][j - 1] || isMatch[i - 1][j];
				} else {
					isMatch[i][j] = isMatch[i][j - 2];
				}
			} 
		}
	}
	
	return isMatch[isMatch.length - 1][isMatch[0].length - 1];
}