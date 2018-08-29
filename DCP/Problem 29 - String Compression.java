/*
This problem was asked by Amazon.

Run-length encoding is a fast and simple method of encoding strings. The basic idea is to represent repeated successive characters as a single count and character. For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".

Implement run-length encoding and decoding. You can assume the string to be encoded have no digits and consists solely of alphabetic characters. You can assume the string to be decoded is valid.
*/

public String stringCompression(String input) {
	if (input.length() < 2) return input;
	StringBuilder sb = new StringBuilder();

	char current = input.charAt(0);
	int prevChar = 0;
	for (int i = 0; i < input.length(); i++){
		if (input.charAt(i) != current) {
			sb.append(i - prevChar).append(current);
			current = input.charAt(i);
			prevChar = i;
		}
		if (i == input.length() - 1){
			sb.append(i - prevChar + 1).append(current);
		}
	}

	return sb.toString();
}

public String stringDecompression(String input) {
	StringBuilder sb = new StringBuilder();
	
	for (int i = 0; i < input.length(); i = i + 2) {
		int count = Integer.parseInt(input.charAt(i));
		char c = input.charAt(i + 1);
		
		for (int j = 0; j < count; j++) {
			sb.append(c);
		}
	}
	
	return sb.toString();
}