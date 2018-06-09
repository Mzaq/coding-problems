/*
2.7 - Intersection 

Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting
node. Note that the intersection is defined based on reference, not value. That is, if the kth
node of the first linked list is the exact same node (by reference) as the jth node of the second
linked list, then they are intersecting.

Also on LeetCode: https://leetcode.com/problems/intersection-of-two-linked-lists/description/
*/

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	int lenA = getLength(headA);
	int lenB = getLength(headB);
	
	int diff = Math.abs(lenA- lenB);
	
	if (lenB > lenA){
		for (int i = 0; i < diff; i++){
			headB = headB.next;
		}
	} else {
		for (int i = 0; i < diff; i++){
			headA = headA.next;
		}
	}
	
	while (headA != null || headB != null){
		if (headA.equals(headB)) return headA;
		headA = headA.next;
		headB = headB.next;
	}
	
	return null;
}

private int getLength(ListNode head){
	int count = 0;
	ListNode current = head;
	while (current != null){
		current = current.next;
		count++;
	}
	return count;
}