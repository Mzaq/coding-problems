/*
4.12 - Paths with Sum

You are given a binary tree in which each node contains an integer value (which
might be positive or negative). Design an algorithm to count the number of paths that sum to a
given value. The path does not need to start or end at the root or a leaf, but it must go downwards
(traveling only from parent nodes to child nodes)

On LeetCode (Slightly different question): https://leetcode.com/problems/path-sum-ii/description/
*/

//Recursive solution to LeetCode variation: O(n) time
private List<List<Integer>> paths;
public List<List<Integer>> pathSum(TreeNode root, int sum) {
	paths = new ArrayList<>();
	pathSumHelper(root, sum, 0, new ArrayList<Integer>());
	return paths;
	
}

private void pathSumHelper(TreeNode node, int targetSum, int currentSum, List<Integer> currentPath) {
	if (node == null) {
		return;
	}
	currentSum += node.val;
	currentPath.add(node.val);
	if (currentSum == targetSum && node.left == null && node.right == null) {
		paths.add(new ArrayList<Integer>(currentPath));
	}

	pathSumHelper(node.left, targetSum, currentSum, currentPath);
	pathSumHelper(node.right, targetSum, currentSum, currentPath);
	currentPath.remove(currentPath.size() - 1);
}