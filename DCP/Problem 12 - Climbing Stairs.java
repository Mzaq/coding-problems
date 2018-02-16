/*
This problem was asked by Apple.

There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. Given N, write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.

For example, if N is 4, then there are 5 unique ways:

1, 1, 1, 1
2, 1, 1
1, 2, 1
1, 1, 2
2, 2

Also on LeetCode: https://leetcode.com/problems/climbing-stairs

*/

//O(n) time, O(n) space solution w/ DP+memoization

public int climbStairs(int n) {
	if (n <= 0) return 0;
	
	int[] numWays = new int[n + 1];
	numWays[0] = 1;
	numWays[1] = 1;

	for (int i = 1; i < n; i++){
		numWays[i + 1] = numWays[i] + numWays[i - 1];
	}
	
	return numWays[n];
}
