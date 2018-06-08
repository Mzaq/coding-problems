/*
2,6 - Palindrome Linked List

Implement a function to check if a linked list is a palindrome.

Also on LeetCode: https://leetcode.com/problems/palindrome-linked-list/description/
*/

//Shitty solution but it works
public boolean isPalindrome(ListNode head) {
	ArrayList<Integer> list = new ArrayList<>();
	
	while (head != null){
		list.add(head.val);
		head = head.next;
	}
	ArrayList<Integer> reverse = (ArrayList<Integer>) list.clone();
	Collections.reverse(reverse);
	return list.equals(reverse);
}

//TODO: Implement O(n) time and O(1) solution