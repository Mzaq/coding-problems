/*
4.8 - First Common Ancestor

Design an algorithm and write code to find the first common ancestor
of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
necessarily a binary search tree.

Also on LeetCode: 
- https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
- https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/ (this question)

*/

//BST version first attempt
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	Deque<TreeNode> stackP = findNode(root, p);
	Deque<TreeNode> stackQ = findNode(root, q);
	
	TreeNode LCA = stackP.size() > stackQ.size() ? findLCA(stackP, stackQ) : findLCA(stackQ, stackP);
	return LCA;
}

private Deque<TreeNode> findNode(TreeNode root, TreeNode target) {
	Deque<TreeNode> stack = new LinkedList<>();
	
	TreeNode current = root;
	stack.addFirst(current);
	while (current.val != target.val) {
		if (target.val < current.val) {
			current = current.left;
		} else {
			current = current.right;
		}
			stack.addFirst(current);
	}
	
	return stack;
}

private TreeNode findLCA (Deque<TreeNode> stack1, Deque<TreeNode> stack2) {
	while (stack1.size() > stack2.size()) stack1.removeFirst();
	TreeNode curr1 = stack1.peekFirst();
	TreeNode curr2 = stack2.peekFirst();
	while (curr1.val != curr2.val) {
		curr1 = stack1.removeFirst();
		curr2 = stack2.removeFirst();
	}
	
	return curr1;
}

//BST version second attempt
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	TreeNode current = root;
	while ((p.val < current.val && q.val < current.val) || (p.val > current.val && q.val > current.val)) {
		if (p.val < current.val && q.val < current.val) current = current.left;
		else current = current.right;
	}
	
	return current;
}

//Binary tree version first attempt
boolean found = false;
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	Deque<TreeNode> stackP = new LinkedList<>();
	Deque<TreeNode> stackQ = new LinkedList<>();
	findNode(stackP, root, p);
	found = false;
	findNode(stackQ, root, q);

	TreeNode LCA = stackP.size() > stackQ.size() ? findLCA(stackP, stackQ) : findLCA(stackQ, stackP);
	return LCA;

}

private void findNode(Deque<TreeNode> stack, TreeNode root, TreeNode target) {
	if (root == null) return;
	
	TreeNode current = root;
	stack.addFirst(current);
	
	if (current.val == target.val) found = true;
	
	if (!found) findNode(stack, root.left, target);
	if (!found) findNode(stack, root.right, target);
	
	if (found) return;
	else stack.removeFirst();
}

private TreeNode findLCA(Deque<TreeNode> stack1, Deque<TreeNode> stack2) {
	while (stack1.size() > stack2.size()) stack1.removeFirst();
	TreeNode curr1 = stack1.peekFirst();
	TreeNode curr2 = stack2.peekFirst();
	while (curr1.val != curr2.val) {
		curr1 = stack1.removeFirst();
		curr2 = stack2.removeFirst();
	}
	
	return curr1;
}