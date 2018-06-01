/*
2.2 - Kth to last in Linked List

Implement an algorithm to find the kth to last element of a singly linked list.
*/

//Iterative solution
public ListNode<Integer> kthToLast(ListNode<Integer> head, int k) {
	ListNode<Integer> kth = head;
	for (int i = 0;  i < k; i++){
		head = head.next;
	}

	while (head != null){
		head = head.next;
		kth = kth.next;
	}
	return kth;
}

//TODO: Implement recursive solution