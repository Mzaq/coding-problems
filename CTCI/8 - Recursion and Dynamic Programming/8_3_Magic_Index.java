/*
8.3 - Magic Index

A magic index in an array A [1. .. n -1] is defined to be an index such that A[ i]
i. Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in
array A.

FOLLOW UP

What if the values are not distinct?

*/

//Distinct values
public int magicIndex(int[] numbers, int start, int end) {
	if (end < start) {
		return -1;
	}

	int middle = start + (end - start)/2;
	if (numbers[middle] == middle) {
		return middle;
	}

	if (numbers[middle] > middle) {
		return magicIndex(numbers, start, middle);
	} else {
		return magicIndex(numbers, middle + 1, end);
	}
}

//NOT distinct values
public int magicIndexNotDistinct(int[] numbers, int start, int end) {
	if (start < 0 || end < 0 || start >= numbers.length || end >= numbers.length) {
		return -1;
	}
	int middle = start + (end - start)/2;
	if (numbers[middle] == middle) return middle;
	if (start == end) return -1;

	int left = magicIndexNotDistinct(numbers, start, Math.min(middle - 1, numbers[middle]));
	if (left != -1) return left;

	int right = magicIndexNotDistinct(numbers, Math.max(middle + 1, numbers[middle]), end);
	return right;
}