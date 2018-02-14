/*
This problem was asked by Airbnb and LinkedIn.

Given a list of integers, write a function that returns the largest sum of non-adjacent numbers.

For example, [2, 4, 6, 8] should return 12, since we pick 4 and 8. [5, 1, 1, 5] should return 10, since we pick 5 and 5.

Also on LeetCode: 
- https://leetcode.com/problems/house-robber/
- https://leetcode.com/problems/house-robber-ii
- https://leetcode.com/problems/house-robber-iii

*/

//First variation solution
//O(n) time complexity
//O(n) space complexity
public int maxSumNonAdjacent(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        if (nums.length == 1) return nums[0];
            
        int[] maxSum = new int[nums.length + 1];
        maxSum[0] = 0;
        maxSum[1] = nums[0];
        maxSum[2] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < nums.length; i++){
            int add = Math.max(maxSum[i - 1], maxSum[i - 2]) == maxSum[i - 1] ? i - 1: i - 2; 
            maxSum[i + 1] = Math.max(nums[i] + maxSum[add], maxSum[add]);
        }
        
        return Math.max(maxSum[nums.length], maxSum[nums.length - 1]);
    }
}
