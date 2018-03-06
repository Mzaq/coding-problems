/*
This problem was asked by LinkedIn, Facebook.

A builder is looking to build a row of N houses that can be of K different colors. He has a goal of minimizing cost while ensuring that no two neighboring houses are of the same color.

Given an N by K matrix where the nth row and kth column represents the cost to build the nth house with kth color, return the minimum cost which achieves this goal.

On LeetCode:
- https://leetcode.com/problems/paint-house/description/
- https://leetcode.com/problems/paint-house-ii/description/

*/

//Paint House I solution (k = 3):
public int minCost(int[][] costs) {
	if (costs == null || costs.length == 0) return 0;
	
	int[][] minCost = new int[costs.length + 1][3];
	for (int i = 0; i < minCost[0].length; i++){
		minCost[0][i] = 0;
	}
	
	for (int i = 1; i < minCost.length; i++){
		minCost[i][0] = Math.min(minCost[i-1][1], minCost[i-1][2]) + costs[i-1][0];
		minCost[i][1] = Math.min(minCost[i-1][0], minCost[i-1][2]) + costs[i-1][1];
		minCost[i][2] = Math.min(minCost[i-1][1], minCost[i-1][0]) + costs[i-1][2];
	}
	
	int size = minCost.length;
	return Math.min(Math.min(minCost[size - 1][0], minCost[size - 1][1]), minCost[size - 1][2]);
}