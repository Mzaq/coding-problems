/*
4.2 - Minimal Tree
Given a sorted (increasing order) array with unique integer elements, write an algorithm to create a binary search tree with minimal height (height balanced).
*/

//First attempt solution
public TreeNode sortedArrayToBST(int[] nums) {
	if (nums.length == 0) return null;
	if (nums.length == 1) return new TreeNode(nums[0]);
	int middle = nums.length / 2;
	TreeNode root = new TreeNode(nums[middle]);
	binarySearch(Arrays.copyOfRange(nums, 0, middle), Arrays.copyOfRange(nums, middle + 1, nums.length), root);
	return root;
}

private void binarySearch(int[] leftNodes, int[] rightNodes, TreeNode parent){
	if (leftNodes.length == 0){
		parent.left = null;
	} else {
		int leftMiddle = leftNodes.length / 2;
		int leftValue = leftNodes[leftMiddle];
		parent.left = new TreeNode(leftValue);
		binarySearch(Arrays.copyOfRange(leftNodes, 0, leftMiddle), Arrays.copyOfRange(leftNodes, leftMiddle + 1, leftNodes.length), parent.left);
	}

	
	if (rightNodes.length == 0){
		parent.right = null;
	} else {
		int rightMiddle = rightNodes.length / 2;
		int rightValue = rightNodes[rightMiddle];
		parent.right = new TreeNode(rightValue);
		binarySearch(Arrays.copyOfRange(rightNodes, 0, rightMiddle), Arrays.copyOfRange(rightNodes, rightMiddle + 1, rightNodes.length), parent.right);
	}       
}

//Next: Cleaner solution with no array copies and less code