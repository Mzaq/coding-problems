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
	
	
//Recursive Implementation
public static final String delimiter = ",";
public static final String nullValue = "null";

// Encodes a tree to a single string.
public String serialize(TreeNode root) {
	if (root == null){
		return "";
	}
	StringBuilder stringBuilder = new StringBuilder();
	serializeDFS(root, stringBuilder);
	return stringBuilder.toString();
}

private void serializeDFS(TreeNode node, StringBuilder stringBuilder){
	if (node == null){
		stringBuilder.append(nullValue).append(delimiter);
		return;
	}
	
	stringBuilder.append(node.val).append(delimiter);        
	serializeDFS(node.left, stringBuilder);
	serializeDFS(node.right, stringBuilder);
}

// Decodes your encoded data to tree.
public TreeNode deserialize(String data) {
	if (data.equals("")){
		return null;
	}

	Deque<String> vals = new LinkedList<>();
	vals.addAll(Arrays.asList(data.split(delimiter)));
	
	return deserializeDFS(vals);
}

private TreeNode deserializeDFS(Deque<String> vals){
	if (vals.peekFirst().equals(nullValue)){
		vals.removeFirst();
		return null;
	} else {
		TreeNode node = new TreeNode(Integer.parseInt(vals.removeFirst()));
		node.left = deserializeDFS(vals);
		node.right = deserializeDFS(vals);    
		return node;
	}
}