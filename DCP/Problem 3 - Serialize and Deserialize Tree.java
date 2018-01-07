/*
Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.

This question was asked by Google, Facebook, Bloomberg, Microsoft, Amazon, Uber, LinkedIn

Definition for a binary tree node.
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
 
*/

//Initial iterative implementation
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder serial = new StringBuilder();
        Deque<TreeNode> traversal = new LinkedList<>();
        
        if (root == null){
            return serial.toString();
        }
        
        traversal.addLast(root);
        while (!traversal.isEmpty()){
            TreeNode current = traversal.removeFirst();
            if (current == null){
                serial.append("null,");
                continue;
            }
            
            serial.append(current.val).append(",");
            
            traversal.addLast(current.left);
            traversal.addLast(current.right);
        }
        serial.deleteCharAt(serial.length() - 1);
        System.out.println(serial.toString());
        return serial.toString(); 
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0){
            return null;
        }
        
        Deque<TreeNode> queue = new LinkedList<>();
        String[] serial = data.split(",");
        
        int i = serial.length - 1;
        while (serial[i].equals("null")){
            serial[i] = "end";
            i--;
        }
        
        int children = 1;
        TreeNode root = new TreeNode(Integer.parseInt(serial[0]));
        queue.addLast(root);
        while (children < serial.length && !serial[children].equals("end")){
            TreeNode current = queue.removeFirst();
            
            if (!serial[children].equals("null")){
                TreeNode leftChild = new TreeNode(Integer.parseInt(serial[children]));
                current.left = leftChild;
                queue.addLast(leftChild);
            }
            children++;
            if (!serial[children].equals("null") && !serial[children].equals("end")){
                TreeNode rightChild = new TreeNode(Integer.parseInt(serial[children]));
                current.right = rightChild;
                queue.addLast(rightChild);
            }
            children++;       
        }
        
        return root;
    }
	
	
//Try Recursive implementation