/*
4.10 - Check Subtree

Tl and T2 are two very large binary trees, with Tl much bigger than T2. Create an
algorithm to determine if T2 is a subtree of Tl.
A tree T2 is a subtree ofTi if there exists a node n in Ti such that the subtree of n is identical to T2.
That is, if you cut off the tree at node n, the two trees would be identical

Also on LeetCode: https://leetcode.com/problems/subtree-of-another-tree/description/
*/

//Recursive solution O(n log`n) ?
public boolean isSubtree(TreeNode s, TreeNode t) {
	if (s == null && t == null) return true; 
	if (s == null || t == null) return false;
	if (s.val == t.val && isSubtreeHelper(s, t)) {
		return true;
	}
	
	return false || isSubtree(s.left, t) || isSubtree(s.right, t);
}

private boolean isSubtreeHelper(TreeNode s, TreeNode t) {
	if (s == null && t == null) return true;
	if (s == null || t == null) return false;

	return s.val == t.val && isSubtreeHelper(s.left, t.left) && isSubtreeHelper(s.right, t.right);
}

//TODO: O(n) preorder traversal solution