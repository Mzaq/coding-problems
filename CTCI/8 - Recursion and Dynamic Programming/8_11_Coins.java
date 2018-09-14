/*
8.11 - Coins
Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents), and
pennies (1 cent), write code to calculate the number of ways of representing n cents.

Also on LeetCode: https://leetcode.com/problems/coin-change-2/
*/

public int change(int amount, int[] coins) {
	int[][] numWays = new int[coins.length + 1][amount + 1];
	numWays[0][0] = 1;

	for (int i = 1; i <= coins.length; i++) {
		for (int j = 0; j <= amount; j++) {
			if (j == 0) {
				numWays[i][j] = 1;
			} else {
				if (j - coins[i - 1] >= 0) {
					numWays[i][j] = numWays[i-1][j] + numWays[i][j-coins[i-1]];
				} else {
					numWays[i][j] = numWays[i-1][j];
				}
			}
		}
	}
	
	return numWays[coins.length][amount];
}