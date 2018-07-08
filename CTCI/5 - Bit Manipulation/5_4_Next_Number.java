/*
5.4 - Next Number

Given a positive integer, print the next smallest and the next largest number that
have the same number of 1 bits in their binary representation.
*/

//Initial attempt
public void nextNumber(int number) {
	String binary = Integer.toBinaryString(number);
	
	//Next smallest
	StringBuilder sb = new StringBuilder(binary);
	int i = binary.length() - 2;

	while (i >= 0) {
		if (binary.charAt(i) == '1' && binary.charAt(i + 1) == '0') {
			sb = swapSmaller(sb, i);
			break;
		}
		i--;  
	}

	System.out.println("Next smallest: " + sb.toString());
	
	//Next biggest
	sb = new StringBuilder(binary);
	i = binary.length() - 1;

	while (i > 0) {
		if (binary.charAt(i) == '1' && binary.charAt(i - 1) == '0') {
			sb = swapBigger(sb, i);
			break;
		}
		i--;
		if (i == 0) {
			sb = swapBigger(sb, i); 
		}
	}
	System.out.println("Next biggest: " + sb.toString());	
}

private StringBuilder swapSmaller(StringBuilder sb, int i) {
	sb.setCharAt(i, '0');
	sb.setCharAt(i + 1, '1');
	return sb;
}

private StringBuilder swapBigger(StringBuilder sb, int i) {
	if (i == 0) {
		sb.insert(0, '1');
		sb.setCharAt(1, '0');
		return sb;
	}

	sb.setCharAt(i, '0');
	sb.setCharAt(i - 1, '1');
	return sb;
}