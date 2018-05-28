/*
1.8 - Zero Matrix

Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
column are set to O.

Also on LeetCode: https://leetcode.com/problems/set-matrix-zeroes/description/
*/

//Naive solution: O(mn) space
public int[][] zeroMatrix(int[][] matrix){
	boolean[][] zeros = new boolean[matrix.length][matrix[0].length];
	for (int i = 0; i < matrix.length; i++){
		for (int j = 0; j < matrix[0].length; j++) {
			if (matrix[i][j] == 0) zeros[i][j] = true;
		}
	}

	for (int i = 0; i < matrix.length; i++) {
		for (int j = 0; j < matrix[0].length; j++) {
			if (zeros[i][j]){
				for (int k = 0; k < matrix.length; k++){
					matrix[k][j] = 0;
				}
				for (int k = 0; k < matrix[0].length; k++){
					matrix[i][k] = 0;
				}
			}
		}
	}

	return matrix;
}

//TODO: Complete O(1) space solution