/*
2.8 - Loop Detection

Given a circular linked list, implement an algorithm that returns the node at the
beginning of the loop.
DEFINITION
Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so
as to make a loop in the linked list.

EXAMPLE
Input: A -> B -> C -> D -> E -> C (the same C as earlier)
Output: C

Also on LeetCode: https://leetcode.com/problems/linked-list-cycle-ii/description/
*/

//O(n) space solution
public ListNode detectCycle(ListNode head) {
	Set<ListNode> set = new HashSet<>();
	
	while (head != null){
		if (!set.add(head)) return head;
		head = head.next;
	}
	
	return null;
}

//O(1) space solution
public ListNode detectCycle(ListNode head) {
	ListNode slow = head;
	ListNode fast = head;
	boolean cycle = false;
	
	while (fast != null && fast.next != null) {
		slow = slow.next;
		fast = fast.next.next;
		if (slow == fast) {
			cycle = true;
			break;
		}
	}
	if (!cycle) {
		return null;
	}
	
	fast = head;
	
	while (fast != slow) {
		fast = fast.next;
		slow = slow.next;
	}
	
	return slow;
}