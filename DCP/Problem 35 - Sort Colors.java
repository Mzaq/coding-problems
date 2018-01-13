/* This question was asked by Google, Facebook, Microsoft

Given an array of strictly the characters 'R', 'G', and 'B', segregate the values of the array so that all the Rs come first, the Gs come second, and the Bs come last. You can only swap elements of the array.

Do this in linear time and in-place.

For example, given the array ['G', 'B', 'R', 'R', 'B', 'R', 'G'], it should become ['R', 'R', 'R', 'G', 'G', 'B', 'B'].

Also on LeetCode: https://leetcode.com/problems/sort-colors/description/
*/

//O(n) brute force naive solution (not in-place)
public void sortColors(int[] nums) {
	int red = 0;
	int white = 0;
	int blue = 0;
	int count = 0;
	
	for (int i = 0; i < nums.length; i++){
		if (nums[i] == 0) red++;
		else if (nums[i] == 1) white ++;
		else blue++;
	}

	while (red > 0){
		nums[count++] = 0;
		red--;
	}
	
	while (white > 0){
		nums[count++] = 1;
		white--;
	}
	
	while (blue > 0){
		nums[count++] = 2;
		blue--;
	}
}

//O(4n) Counting Sort implementation (not in-place). Works for any number of colors,
//but not as efficient as brute force for 3 colors.
public void sortColors(int[] nums) {
	//Count size equal to number of possible colors
	int[] count = new int[3];
	int[] output = new int[nums.length];
	
	for (int i = 0; i < nums.length; i++){
		count[nums[i]]++;    
	}
	
	for (int i = 1; i < count.length; i++){
		count[i] += count[i-1];
	}
	
	for (int i = 0; i < nums.length; i++){
		output[count[nums[i]] - 1] = nums[i];
		count[nums[i]]--;
	}
	
	for (int i = 0; i < nums.length; i++){
		nums[i] = output[i];
	}
}

//Implement one-pass linear solution w/ constant space