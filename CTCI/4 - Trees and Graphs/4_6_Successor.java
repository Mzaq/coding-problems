/*
4.6 - Successor

Write an algorithm to find the "next" node (i .e., in-order successor) of a given node in a
binary search tree. You may assume that each node has a link to its parent
*/

public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
	TreeNode successor = null;
	while (root != null) {
		if (p.val < root.val) {
			successor = root;
			root = root.left;
		} else {
			root = root.right;
		}
	}
	return successor;
}