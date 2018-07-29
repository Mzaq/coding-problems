/*
8.1 - Triple Step

A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
steps at a time. Implement a method to count how many possible ways the child can run up the
stairs.
*/

public int climbingStairs(int n) {
	if (n == 0) return 0;
	int[] numWays = new int[n + 1];
	
	numWays[0] = 1;
	numWays[1] = 1;
	numWays[2] = 2;

	for (int i = 3; i <= n; i++) {
		numWays[i] = numWays[i - 1] + numWays[i - 2] + numWays[i - 3];
	}

	return numWays[n];
}