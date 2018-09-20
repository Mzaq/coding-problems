/*
This problem was asked by Amazon, Facebook, Microsoft.

Compute the running median of a sequence of numbers. That is, given a stream of numbers, print out the median of the list so far on each new element.

Recall that the median of an even-numbered list is the average of the two middle numbers.

For example, given the sequence [2, 1, 5, 7, 2, 0, 5], your algorithm should print out:

2
1.5
2
3.5
2
2
2

Also on LeetCode: https://leetcode.com/problems/find-median-from-data-stream/description/

*/

PriorityQueue<Integer> max;
PriorityQueue<Integer> min;

public MedianFinder() {
	max = new PriorityQueue(Collections.reverseOrder());
	min = new PriorityQueue();
}

public void addNum(int num) {
	if (max.isEmpty()) {
		max.add(num);
		return;
	}
	
	if (num <= max.peek()) {
		max.add(num);
	} else {
		min.add(num);
	}
}

private void balance(PriorityQueue big, PriorityQueue small) {
	while (small.size() < big.size()) {
		small.add(big.poll());
	}
}

public double findMedian() {
	if (max.size() > min.size() + 1) {
		balance(max, min);
	} else if (min.size() > max.size() + 1) {
		balance(min, max);
	}
	
	if (min.size() == max.size()) {
		return (double) (min.peek() + max.peek()) / 2;
	} else if (min.size() > max.size()) {
		return min.peek();
	} else {
		return max.peek();
	}
}