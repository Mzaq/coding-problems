/*Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i. Solve it without using division and in O(n) time.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].

This problem was asked by Facebook, Microsoft, Amazon, Uber, LinkedIn

On LeetCode: https://leetcode.com/problems/product-of-array-except-self/description/
*/


public int[] productExceptSelf(int[] nums) {
	int[] result = new int[nums.length];
	result[0] = 1;
	for (int i = 1; i < nums.length; i++){
		result[i] = result[i-1] * nums[i-1];
	}
	
	int temp = 1;
	for (int i = nums.length - 1; i >= 0; i--){
		result[i] *= temp;
		temp *= nums[i];
	}
	
	return result;
}