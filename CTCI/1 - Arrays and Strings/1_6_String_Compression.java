/*
Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
"compressed" string would not become smaller than the original string, your method should return
the original string. You can assume the string has only uppercase and lowercase letters (a - z).
*/

//Using StringBuilder
public String stringCompression(String input) {
	if (input.length() < 2) return input;
	StringBuilder sb = new StringBuilder();

	char current = input.charAt(0);
	int prevChar = 0;
	for (int i = 0; i < input.length(); i++){
		if (input.charAt(i) != current) {
			sb.append(current).append(i - prevChar);
			current = input.charAt(i);
			prevChar = i;
		}
		if (i == input.length() - 1){
			sb.append(current).append(i - prevChar + 1);
		}
	}

	return sb.length() > input.length() ? input : sb.toString();
}