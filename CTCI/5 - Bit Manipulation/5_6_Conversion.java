/*
5.6 - Conversion

Write a function to determine the number of bits you would need to flip to convert
integer A to integer B.

EXAMPLE
Input:
Output:
29 (or: 11101), 15 (or: 01111)
2
*/

//String solution
public int bitsToConvert(int a, int b) {
	int difference = 0;
	String aString = Integer.toBinaryString(a);
    String bString = Integer.toBinaryString(b);    
    String longer = aString.length() > bString.length() ? aString : bString;
    String shorter = aString.length() <= bString.length() ? aString : bString;

	for (int i = 0; i < longer.length(); i++) {
		try {
			if (longer.charAt(i) != shorter.charAt(i)) {
				difference++; 
			}
		} catch (StringIndexOutOfBoundsException e) {
			if (longer.charAt(i) != 0) {
				difference++; 
			}
		}
	}
	return difference;
}

//Bitwise operation solution
public int bitsToConvert(int a, int b) {
	int xor = a ^ b;
	int difference = 0;
	
	for (int i = xor; i != 0; i >>= 1) {
		if ((i & 1) == 1) difference++;
	}
	
	return difference;
}