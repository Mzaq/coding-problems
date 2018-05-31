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

//O(1) space
public int[][] zeroMatrix(int[][] matrix) {
	boolean firstRow = false;
	boolean firstColumn = false;

	//Mark rows and columns
	for (int i = 0; i < matrix.length; i++) {
		for (int j = 0; j < matrix[0].length; j++) {
			if (matrix[i][j] == 0){
				if (i == 0) firstRow = true;
				if (j == 0) firstColumn = true;
				matrix[i][0] = 0;
				matrix[0][j] = 0;
			}
		}
	}

	//Set cells to 0
	for (int i = 1; i < matrix.length; i++) {
		for (int j = 1; j < matrix[0].length; j++) {
			if (matrix[i][0] == 0 || matrix[0][j] == 0){
				matrix[i][j] = 0;
			}
		}
	}
	
	//Set first column if needed
	if (firstColumn){
		for (int i = 0; i < matrix.length; i++){
			matrix[i][0] = 0;
		}
	}

	//Set first row if needed
	if (firstRow){
		for (int j = 0; j < matrix[0].length; j++){
			matrix[0][j] = 0;
		}
	}

	return matrix;
}