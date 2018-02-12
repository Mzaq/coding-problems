/*
This problem was asked by Google.

A unival tree (which stands for "universal value") is a tree where all nodes have the same value.

Given the root to a binary tree, count the number of unival subtrees.

Also on LeetCode: https://leetcode.com/problems/count-univalue-subtrees/description/
*/


//O(n) recursive post order traversal solution
private int numUnivalTrees = 0;
private final int WRONG = Integer.MAX_VALUE;

public int countUnivalSubtrees(TreeNode root) {
	if (root == null) return 0;
	countUnivalHelper(root);
	return numUnivalTrees;
}

private int countUnivalHelper(TreeNode node){
	if (node.left == null && node.right == null){
		numUnivalTrees++;
		return node.val;
	}
	
	Integer left = null;
	Integer right = null;
	
	if (node.left != null){
		left = countUnivalHelper(node.left);
	} 
	
	if (node.right != null){
		right = countUnivalHelper(node.right);
	}
	
	if ((left != null && left == WRONG) || (right != null && right == WRONG)){
		return WRONG;
	}

	if ((left == null && node.val == right) || (right == null && node.val == left)){
		numUnivalTrees++;
		return node.val;
	}
	
	if (left != null && right != null && node.val == left && node.val == right){
		numUnivalTrees++;
		return node.val;
	}
	
	return WRONG;
}