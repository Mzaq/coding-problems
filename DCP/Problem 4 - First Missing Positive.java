/*
This problem was asked by Stripe.

Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

You can modify the input array in-place.

Also on LeetCode: https://leetcode.com/problems/first-missing-positive/description/
*/

//O(1) constant space solution
public int firstMissingPositive(int[] nums) {       
	for (int i = 0; i < nums.length; i++){
		while (nums[i] > 0 && nums[i] <= nums.length){
			if (nums[i] == i + 1 || nums[i] == nums[nums[i] - 1]) break;
			swap(i, nums[i] - 1, nums);
		}
	}
	
	for (int i = 0; i < nums.length; i++){
		if (nums[i] != i + 1){
			return i + 1;
		}
	}
	
	return nums.length + 1;
}

private void swap(int a, int b, int[] nums){
	int temp = nums[a];
	nums[a] = nums[b];
	nums[b] = temp;
}