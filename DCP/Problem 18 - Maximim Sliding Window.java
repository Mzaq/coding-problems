/*

This problem was asked by Google.

Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each subarray of length k.

For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:

10 = max(10, 5, 2)
7 = max(5, 2, 7)
8 = max(2, 7, 8)
8 = max(7, 8, 7)
Do this in O(n) time

*/

//O(n) time solution with Deque
public int[] maxSlidingWindow(int[] nums, int k) {
	if (nums == null || nums.length == 0){ 
		return new int[]{};
	}
	
	List<Integer> maxVals = new ArrayList<>();
	Deque<Integer> queue = new ArrayDeque<>();
	int index = 0;
	int max = Integer.MIN_VALUE;
	
	while (index < k){
		int current = nums[index];
		max = current > max ? current : max;
		queue.addLast(nums[index]);
		index++;
	}
	
	maxVals.add(max);
	
	while (index < nums.length){
		int first = queue.removeFirst();
		int currentMax = maxVals.get(maxVals.size() - 1);
		queue.addLast(nums[index]);
		
		if (first < currentMax){
			if (nums[index] > currentMax) maxVals.add(nums[index]);
			else maxVals.add(currentMax);
		} else {                
			int windowMax = Integer.MIN_VALUE;
			for (int num : queue){
				if (num > windowMax) windowMax = num;
			}
			
			maxVals.add(windowMax);
		}
		index++;
	}
	
	return maxVals.stream().mapToInt(i->i).toArray();
}