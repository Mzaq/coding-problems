/*
2.1 - Remove Dups
Write code to remove duplicates from an unsorted linked list
*/

//O(n) time, O(n) space
public ListNode<Integer> removeDupsUnsorted(ListNode<Integer> head) {
	Set<Integer> set = new HashSet<>();

	ListNode<Integer> current = head;
	set.add(head.val);
	while (current != null){
		while (current.next != null && !set.add(current.next.val)){
			current.next = current.next.next;
		}
		current = current.next;
	}
	return head;

} 

//Two pointer solution is O(n^2) time, O(1) space

