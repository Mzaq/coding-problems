/*
5.1 - Insertion

You are given two 32-bit numbers, Nand M, and two bit positions, i and
j. Write a method to insert Minto N such that M starts at bit j and ends at bit i. You
can assume that the bits j through i have enough space to fit all of M. That is, if
M = 10011, you can assume that there are at least 5 bits between j and i. You would not, for
example, have j = 3 and i = 2, because M could not fully fit between bit 3 and bit 2.

EXAMPLE
Input: N = 10000000000 M = 10011, i = 2, j = 6
Output: N 10001001100
*/

public int insertion(int m, int n, int i, int j) {
	int mask = ~0 << j + 1 | (1 << i) - 1; //create mask to clear necessary bits in M
	int clearedM = m & mask; //clear necessary bits in M
	int shiftedN = n << i; //shift N to match location in M
	return clearedM | shiftedN; //merge M and N
}