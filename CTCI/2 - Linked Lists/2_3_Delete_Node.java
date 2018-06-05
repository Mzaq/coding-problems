/*
2.3 - Delete Node 

Implement an algorithm to delete a node (except for the tail node) of a singly linked list, given only access to that node.

EXAMPLE
Input: the node c from the linked list a -> b-> c -> d ->e -> f
Result: nothing is returned, but the new linked list looks like a -> b -> d -> e -> f
*/

public void deleteNode(ListNode node) {
	if (node == null || node.next == null){
		return;
	}
	
	node.val = node.next.val;
	node.next = node.next.next;
}