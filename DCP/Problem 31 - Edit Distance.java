/*
This problem was asked by Google, Baidu, Microsoft, Amazon

The edit distance between two strings refers to the minimum number of character insertions, deletions, and substitutions required to change one string to the other. For example, the edit distance between “kitten” and “sitting” is three: substitute the “k” for “s”, substitute the “e” for “i”, and append a “g”.

Given two strings, compute the edit distance between them.

Also on LeetCode: https://leetcode.com/problems/edit-distance/description/
*/

public int minDistance(String word1, String word2) {       
	int[][] distance = new int[word1.length() + 1][word2.length() + 1];
	
	for (int i = 0; i < distance.length; i++) {
		distance[i][0] = i;
	}
	
	for (int i = 0; i < distance[0].length; i++) {
		distance[0][i] = i;
	}
	
	for (int i = 1; i < distance.length; i++) {
		for (int j = 1; j < distance[0].length; j++) {
			char A = word1.charAt(i - 1);
			char B = word2.charAt(j - 1);
			
			if (A == B) {
				distance[i][j] = distance[i-1][j-1];
			} else {
				distance[i][j] = Math.min(distance[i-1][j], Math.min(distance[i][j-1], distance[i-1][j-1])) + 1;
			}
		}
	}
	
	return distance[distance.length - 1][distance[0].length - 1];
}