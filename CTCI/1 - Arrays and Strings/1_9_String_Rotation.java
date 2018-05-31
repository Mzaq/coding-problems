/*
Assume you have a method isSubst ring which checks if one word is a substring
of another. Given two strings, 51 and 52, write code to check if 52 is a rotation of 51 using only one
call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat").

Also on LeetCode: https://leetcode.com/problems/rotate-string/description/
*/

public boolean stringRotation(String s1, String s2){
	if (s1.length() != s2.length()) return false;
	String check = s1 + s1;
	return check.contains(s2);
}