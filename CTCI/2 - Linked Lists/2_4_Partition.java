/*
2.4 - Partition list

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.

EXAMPLE:
Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5

Also on LeetCode: https://leetcode.com/problems/partition-list/description/
*/


//2-pass solution with O(n) space
public ListNode partition(ListNode head, int x) {
	List<Integer> beforeX = new ArrayList<>();
	List<Integer> afterX = new ArrayList<>();
	
	while (head != null){
		boolean test = (head.val < x) ? beforeX.add(head.val) : afterX.add(head.val);
		head = head.next;
	}
	
	ListNode dummy = new ListNode(-1);
	head = dummy;
	for (Integer i : beforeX){
		head.next = new ListNode(i);
		head = head.next;
	}
	for (Integer i : afterX){
		head.next = new ListNode(i);
		head = head.next;
	}
	
	return dummy.next;
}

//1-pass solution
pubilc ListNode partition(ListNode head, int x) {
	ListNode dummy1 = new ListNode(0);
	ListNode dummy2 = new ListNode(0);
	ListNode current1 = dummy1;
	ListNode current2 = dummy2;

	while (head != null){
		if (head.val < x) {
			current1.next = head;
			current1 = head;
		} else {
			current2.next = head;
			current2 = head;
		}
		head = head.next;
	}
	current1.next = dummy2.next;
	current2.next = null;

	return dummy1.next;
}