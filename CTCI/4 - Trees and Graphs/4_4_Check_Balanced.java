/*
4.4 - Check Balanced

Implement a function to check if a binary tree is balanced. For the purposes of
this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
node never differ by more than one.

Also on LeetCode: https://leetcode.com/problems/balanced-binary-tree/description/
*/


public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

class Solution {
    private static final int UNBALANCED = -1;
        
    public boolean isBalanced(TreeNode root) {
        return isBalancedHelper(root) != UNBALANCED;
    }
    
    private int isBalancedHelper(TreeNode node) {
        if (node == null) {
            return 1;
        }
        
        int left = isBalancedHelper(node.left);
        int right = isBalancedHelper(node.right);
        
        if (left == UNBALANCED || right == UNBALANCED || Math.abs(left-right) > 1) {
            return UNBALANCED;
        }
        
        return Math.max(left, right) + 1;
    }
}