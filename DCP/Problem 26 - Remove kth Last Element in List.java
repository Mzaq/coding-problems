/*
This question was asked by Microsoft, Facebook, Google.

Given a singly linked list and an integer k, remove the kth last element from the list. k is guaranteed to be smaller than the length of the list.

The list is very long, so making more than one pass is prohibitively expensive.

Do this in constant space and in one pass.

Also on LeetCode: https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
*/

public ListNode removeNthFromEnd(ListNode head, int n) {
	ListNode remove = head;
	ListNode leader = head;
	
	for (int i = 0; i < n; i++) {
		leader = leader.next;
	}
	
	if (leader == null) return head.next;
	if (n == 1) leader = leader.next;
	
	while (leader != null) {
		remove = remove.next;
		leader = leader.next;
	}
	
	if (n == 1) {
		remove.next = null;
		return head;
	}
	remove.val = remove.next.val;
	remove.next = remove.next.next;
	
	return head;
}