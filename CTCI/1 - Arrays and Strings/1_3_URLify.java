/*  Write a method to replace all spaces in a string with '%20: You may assume that the string
    has sufficient space at the end to hold the additional characters, and that you are given the "true"
    length of the string. (Note: If implementing in Java, please use a character array so that you can
    perform this operation in place.)
    
	EXAMPLE
    Input: "Mr John Smith    ", 13
    Output: "Mr%20John%20Smith"
*/

public String URLify(String input, int length){
	if (input.length() == 0) return "";

	char[] chars = input.toCharArray();
	length = chars.length;
	int current = length - 1;
	int replace = length - 1;

	while (chars[current] == ' ') current--;

	while (current >= 0){
		if (chars[current] == ' '){
			chars[replace] = '0';
			chars[replace - 1] = '2';
			chars[replace - 2] = '%';
			replace = replace - 3;
		} else {
			chars[replace] = chars[current];
			replace--;
		}
		current--;
	}
	return new String(chars);
}