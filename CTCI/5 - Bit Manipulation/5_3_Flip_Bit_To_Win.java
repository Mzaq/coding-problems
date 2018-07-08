/*
5.3 - Flip Bit to Win

You have an integer and you can flip exactly one bit from a 0 to a 1. Write code to
find the length of the longest sequence of 1 s you could create.

EXAMPLE
Input: 1775 (or: 11011101111)
Output: 8
*/

public int flipBitToWin(int number) {
	String binary = Integer.toBinaryString(number);
	int longest = 1;
	int currentLength = 0;
	boolean zeroFound = false;
	int i = 0;
	int lastZero = 0;
	while (i < binary.length()) {
	  char current = binary.charAt(i);
	  if (current == '0') {
		  if (!zeroFound) {
			zeroFound = true;
			lastZero = i;
		  } else {
			longest = Math.max(longest, currentLength);
			currentLength = -1;
			i = lastZero;
			zeroFound = false;
		  }
	  }
	  currentLength++;
	  i++;
	}

	return Math.max(currentLength, longest);
}