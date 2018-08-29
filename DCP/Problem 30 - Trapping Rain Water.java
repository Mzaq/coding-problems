/*
This problem was asked by Amazon, Facebook, Lyft.

You are given an array of non-negative integers that represents a two-dimensional elevation map where each element is unit-width wall and the integer is the height. Suppose it will rain and all spots between two walls get filled up.

Compute how many units of water remain trapped on the map in O(N) time and O(1) space.

For example, given the input [2, 1, 2], we can hold 1 unit of water in the middle.

Given the input [3, 0, 1, 3, 0, 5], we can hold 3 units in the first index, 2 in the second, and 3 in the fourth index (we cannot hold 5 since it would run off to the left), so we can trap 8 units of water.

Also on LeetCode: https://leetcode.com/problems/trapping-rain-water/description/
*/

public int trap(int[] height) {
	List<Integer> left = new ArrayList<>();
	List<Integer> right = new ArrayList<>();
	
	left.add(0);
	int leftPointer = 0;
	for (int i = 1; i < height.length; i++) {
		if (height[i] > height[leftPointer]) {
			leftPointer = i;
			left.add(0);
			continue;
		}
		
		left.add(height[leftPointer] - height[i]);
	}
	
	right.add(0);
	int rightPointer = height.length - 1;
	for (int i = height.length - 2; i > -1; i--) {
		if (height[i] > height[rightPointer]) {
			rightPointer = i;
			right.add(0);
			continue;
		}
		right.add(height[rightPointer] - height[i]);
	}
	Collections.reverse(right);
	
	int totalWater = 0;
	for (int i = 0; i < left.size(); i++) {
		totalWater += Math.min(left.get(i), right.get(i));
	}
	
	return totalWater;
}