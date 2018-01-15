/*
This problem was asked by Google, Microsoft, Amazon, Bloomberg, Airbnb

Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.

For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.

In this example, assume nodes with the same value are the exact same node objects.

Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.

Also on LeetCode: https://leetcode.com/problems/intersection-of-two-linked-lists/description/
*/

//O(M + N) solution by finding difference in lengths
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	if (headA == null || headB == null){
		return null;
	}
	
	int lenA = 1, lenB = 1;
	ListNode itrA = headA;
	ListNode itrB = headB;
	
	while (itrA.next != null) {
		lenA++;
		itrA = itrA.next;
	}
	while (itrB.next != null) {
		lenB++;
		itrB = itrB.next;
	}
	
	int difference = Math.abs(lenA - lenB);
	itrA = headA;
	itrB = headB;
	
	if (lenA > lenB){
		while (difference > 0){
			itrA = itrA.next;
			difference--;
		}
	}
	if (lenB > lenA){
		while (difference > 0){
			itrB = itrB.next;
			difference--;
		}
	}
	
	while (itrA.val != itrB.val){
		if (itrA.next == null){
			return null;
		}
		itrA = itrA.next;
		itrB = itrB.next;
	}
	
	return itrA;
}