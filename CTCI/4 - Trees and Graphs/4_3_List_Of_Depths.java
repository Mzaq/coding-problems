/*
4.3 - List of Depths

Given a binary tree, design an algorithm which creates a linked list of all the nodes
at each depth (e.g., if you have a tree with depth 0, you'll have 0 linked lists).

Also on LeetCode: https://leetcode.com/problems/binary-tree-level-order-traversal/description/
*/


//O(n) solution with Java List and not linked lists
public List<List<Integer>> levelOrder(TreeNode root) {
	List<List<Integer>> levels = new ArrayList<>();

	if (root == null) return levels;
	
	List<TreeNode> currentLevel = new ArrayList<>();
	currentLevel.add(root);
	
	while(!currentLevel.isEmpty()){
		List<Integer> numList = new ArrayList<>();

		List<TreeNode> nextLevel = new ArrayList<>();
		for (TreeNode node : currentLevel){
			numList.add(node.val);
			if (node.left != null) nextLevel.add(node.left);
			if (node.right != null) nextLevel.add(node.right);
		}
		
		levels.add(numList);
		currentLevel = nextLevel;
	}
	
	return levels;
}