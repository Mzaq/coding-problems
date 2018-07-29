/*
8.2 - Robot in a Grid

NOTE: this is a variant on the actual problem. Problem done from LeetCode
https://leetcode.com/problems/unique-paths-ii/description/
*/

//bottom up DP solution
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	if (obstacleGrid.length < 1 || obstacleGrid[0][0] == 1) return 0;
	int[][] numWays = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
	
	for (int i = 0; i < obstacleGrid.length; i++) {
		numWays[i][0] = 0;
	}
	
	for (int i = 0; i < obstacleGrid[0].length; i++) {
		numWays[0][i] = 0;
	}
	
	for (int i = 1; i <= obstacleGrid.length; i++) {
		for (int j = 1; j <= obstacleGrid[0].length; j++) {
			if (i == 1 && j == 1) { 
				numWays[i][j] = 1;
			} else if (obstacleGrid[i - 1][j - 1] != 1) {
				numWays[i][j] = numWays[i - 1][j] + numWays[i][j - 1];
			} else {
				numWays[i][j] = 0;
			}
		}
	}
	
	return numWays[obstacleGrid.length][obstacleGrid[0].length];
}