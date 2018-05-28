/*
Given an image represented by an NxN matrix, where each pixel in the image is 4
bytes, write a method to rotate the image by 90 degrees. (an you do this in place?
*/

public int[][] rotateMatrix(int[][] matrix) {
	//Swap diagonal
	for (int i = 0; i < matrix.length; i++){
		for (int j = 0; j < matrix[i].length - i - 1; j++){
			swap(matrix, i,j, matrix[0].length - j - 1, matrix.length - i - 1);
		}
	}
	
	System.out.println("\n");
	//Swap horizontal
	for (int i = 0; i < matrix.length / 2; i++){
		for (int j = 0; j < matrix.length; j++){
			swap(matrix, i, j, matrix.length - i - 1, j);
		}
	}

	return matrix;
}

private void swap (int[][] matrix, int i, int j, int x, int y){
	int temp = matrix[i][j];
	matrix[i][j] = matrix[x][y];
	matrix[x][y] = temp;
}