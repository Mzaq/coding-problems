/*
4.5 - Validate BST

Implement a function to check if a binary tree is a binary search tree

Also on LeetCode: https://leetcode.com/problems/validate-binary-search-tree/description/
*/


//O(n) space solution
private List<Integer> traversal = new ArrayList<>();

public boolean isValidBST(TreeNode root) {
	isValidBSTHelper(root);
	
	for (int i = 0; i < traversal.size() - 1; i++){
		if (traversal.get(i) >= traversal.get(i + 1)) {
			return false;
		}
	}
	
	return true;
}

private void isValidBSTHelper(TreeNode node) {
	if (node == null) return;
	
	isValidBSTHelper(node.left);
	traversal.add(node.val);
	isValidBSTHelper(node.right);
}