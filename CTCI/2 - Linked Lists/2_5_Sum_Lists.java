/*
2.5 - Sum Lists

You have two numbers represented by a linked list, where each node contains a single
digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
function that adds the two numbers and returns the sum as a linked list.

EXAMPLE
Input: (7 -> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295.
Output: 2 -> 1 -> 9. That is, 912.

Also on LeetCode: https://leetcode.com/problems/add-two-numbers/description/
*/

boolean carry = false;

public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	ListNode dummy = new ListNode(0);
	ListNode current = dummy;
	
	while (l1 != null || l2 != null){
		if (l1 == null) {
			int add = carry ? l2.val + 1 : l2.val;
			current.next = new ListNode(carry(add, carry));
			l2 = l2.next;
		}
		else if (l2 == null) {
			int add = carry ? l1.val + 1 : l1.val;
			current.next = new ListNode(carry(add, carry));
			l1 = l1.next;
		}
		else {
			int val = l1.val + l2.val;
			int add = carry ? val + 1 : val;
			current.next = new ListNode(carry(add,carry));
			l1 = l1.next;
			l2 = l2.next;
		}
		current = current.next;
	}
	
	current.next = carry ? new ListNode(1) : null;
	return dummy.next;
}

private int carry(int add, boolean carry){
	if (add >= 10) {
		this.carry = true;
		add = add - 10;
	} else {
		this.carry = false;
	}
	return add;
}