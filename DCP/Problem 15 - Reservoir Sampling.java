/*
This problem was asked by Facebook and Google.

Given a stream of elements too large to store in memory, pick a random element from the stream with uniform probability.

Also on GeeksforGeeks: https://www.geeksforgeeks.org/select-a-random-number-from-stream-with-o1-space/
Also on LeetCode (similar): https://leetcode.com/problems/linked-list-random-node/

*/

//O(n) time and O(1) space solution with LinkedList, k = 1
ListNode head;
ListNode result;

public Solution(ListNode head) {
	this.head = head;
	result = head;
}

/** Returns a random node's value. */
public int getRandom() {
	Random r = new Random();
	ListNode current = head;
	int count = 1;
	
	while(true){
		if (current == null) break;
		
		if (r.nextInt(count) == count - 1){
			result = current;
		}
		
		current = current.next;
		count++;
	}
	
	return result.val;
}